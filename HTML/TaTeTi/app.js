// Variables globales

let board = Array(9).fill("");
let gameOver = false;

let playerX = 1;       // 1 o 2
let currentPlayer = 1; // 1 o 2
let currentMark = "X";

const modeSelected = document.querySelectorAll('input[name="mode"]');
const jugDos = document.getElementById("jugDos");

let config = null;



// leer cual esta checked, si hvc -> deshabilitar jugDos, agregar nombre a computadora, sino, habilitar jugDos y limpiar input
function handleModeChange() {
  const selectedMode = document.querySelector('input[name="mode"]:checked').value;

  if (selectedMode === "hvc") {
    jugDos.value = "Computadora";
    jugDos.disabled = true;
  } else {
    jugDos.value = "";
    jugDos.disabled = false;
  }
}

// para cada radiobtn mode, agregar evento change
modeSelected.forEach(radio => {
  radio.addEventListener("change", handleModeChange);
});

// ejecutar una vez para inicializar el estado
handleModeChange();


// El submit
const form = document.getElementById("setupForm");
let gameStarted = false;

form.addEventListener("submit", function(event) {
  event.preventDefault();

  const jugUno = document.getElementById("jugUno").value.trim();
  const jugDos = document.getElementById("jugDos").value.trim();
  const mode = document.querySelector('input[name="mode"]:checked').value;
  const jugX = document.querySelector('input[name="jugX"]:checked').value;

  if (jugUno === "") return alert("Ingrese nombre para jugador 1");
  if (jugDos === "") return alert("Ingrese nombre para jugador 2");

  config = {
    player1: jugUno,
    player2: jugDos,
    mode: mode,
    startsX: jugX
  }
  // Hasta aca valida
  // Aca se define tablero, quien empieza con X, jugador actual e inicio de juego
  board = Array(9).fill("");
  gameOver = false;

  playerX = (jugX === "jugUx") ? 1 : 2;
  currentPlayer = playerX;
  currentMark = "X";

  gameStarted = true;
  updateStatus(config);
  if (config.mode === "hvc" && currentPlayer === 2) {
    setTimeout(cpuPlay, 300);
  }

});



// Setup de tablero
const cells = document.querySelectorAll("td[data-cell]");

// Insertar X o Y al tablero
cells.forEach(cell =>{
  cell.addEventListener("click", function (){
    if (!gameStarted || gameOver) return;

    const idx = Number(cell.dataset.cell);

    if (board[idx] !== "") return;

    // marca según quién es X
    const mark = (currentPlayer === playerX) ? "X" : "Y";

    board[idx] = mark;
    cell.textContent = mark;

    const result = checkWinner(board);

    if (result !== null) {
      gameOver = true;

      // (a) resaltar la combinación ganadora
      resaltarCombo(result.combo);

      // (b) status de ganador (usa currentPlayer porque es el que acaba de jugar)
      const winnerName = (currentPlayer === 1) ? config.player1 : config.player2;
      statusEl.textContent = `Ganó: ${winnerName} (${result.mark})`;

      endGame(`El ganador es ${winnerName}!!!`);
      return;
    }

    if (board.every(cell => cell !== "")) {
      // empate
      gameOver = true;
      statusEl.textContent = "Empate";
      endGame("El juego termina en empate");
      return;
    }

    // cambiar turno
    currentPlayer = (currentPlayer === 1) ? 2 : 1;
    updateStatus(config);
    // after changing currentPlayer and updateStatus
    if (config.mode === "hvc" && currentPlayer === 2) {
      setTimeout(cpuPlay, 300); // tiny delay feels nicer
    }

  });
});

// Aca se actualiza el estado del juego
const statusEl = document.querySelector(".status");

function updateStatus(config) {
  const mark = (currentPlayer === playerX) ? "X" : "Y";
  const playerName = (currentPlayer === 1) ? config.player1 : config.player2;
  statusEl.textContent = `Turno: ${playerName} (${mark})`;
}


function checkWinner (board){
  const wins = [
    [0,1,2], [3,4,5], [6,7,8],
    [0,3,6], [1,4,7], [2,5,8],
    [0,4,8], [2,4,6]
  ];
  for (const [a,b,c] of wins){
    if (board[a] === "") continue;

    if (board[a] === board[b] && board[a] === board[c]) {
      return { mark: board[a], combo: [a, b, c] };
    }
  }
  return null;
}

function resaltarCombo(combo){
  combo.forEach( i => {
    const cell = document.querySelector(`td[data-cell="${i}"]`);
    cell.classList.add("win");
  } )
}


const resetBtn = document.getElementById("resetGame");

resetBtn.addEventListener("click", resetGame);

function resetGame(){
  board = Array(9).fill("");
  gameOver=false;
  gameStarted=false;
  config=null;

  cells.forEach(cell => {
    cell.textContent = "";
    cell.classList.remove("win");
  });
  form.reset();
  statusEl.textContent = "Estado";
  handleModeChange();

}

function endGame(message) {
  gameOver = true;

  setTimeout(() => {
    alert(message);
    resetGame();
  }, 300); // try 80–150ms
}

// CPU

function getMarkForPlayer(playerNum) {
  return (playerNum === playerX) ? "X" : "Y";
}

function findWinningMove(b, mark) {
  const wins = [
    [0,1,2], [3,4,5], [6,7,8],
    [0,3,6], [1,4,7], [2,5,8],
    [0,4,8], [2,4,6]
  ];

  for (const [a,b2,c] of wins) {
    const line = [a,b2,c];
    const values = [b[a], b[b2], b[c]];

    // count marks and empties
    let markCount = 0;
    let emptyCount = 0;
    let emptyIndex = -1;

    for (let i = 0; i < 3; i++) {
      if (values[i] === mark) markCount++;
      if (values[i] === "") {
        emptyCount++;
        emptyIndex = line[i];
      }
    }

    if (markCount === 2 && emptyCount === 1) {
      return emptyIndex; // winning/blocking move
    }
  }

  return null;
}

function getBestCpuMove(b, cpuMark, humanMark) {
  // 1) win now
  const winMove = findWinningMove(b, cpuMark);
  if (winMove !== null) return winMove;

  // 2) block human
  const blockMove = findWinningMove(b, humanMark);
  if (blockMove !== null) return blockMove;

  // 3) center
  if (b[4] === "") return 4;

  // 4) corners
  const corners = [0, 2, 6, 8];
  for (const i of corners) if (b[i] === "") return i;

  // 5) sides
  const sides = [1, 3, 5, 7];
  for (const i of sides) if (b[i] === "") return i;

  return null;
}

// CPU PLAY

function cpuPlay() {
  if (!gameStarted || gameOver) return;
  if (!config || config.mode !== "hvc") return;

  const CPU_PLAYER = 2;


  if (currentPlayer !== CPU_PLAYER) return;

  const cpuMark = getMarkForPlayer(CPU_PLAYER);
  const humanMark = getMarkForPlayer(1);

  const idx = getBestCpuMove(board, cpuMark, humanMark);
  if (idx === null) return;


  board[idx] = cpuMark;
  const cellEl = document.querySelector(`td[data-cell="${idx}"]`);
  cellEl.textContent = cpuMark;

  // check winner
  const result = checkWinner(board);
  if (result) {
    gameOver = true;
    resaltarCombo(result.combo);
    statusEl.textContent = `Ganó: ${config.player2} (${result.mark})`;

    endGame(`Ganó: ${config.player2} (${result.mark})`);
    return;
  }

  // check draw
  if (board.every(v => v !== "")) {
    gameOver = true;
    statusEl.textContent = "Empate";
    endGame("El juego termina en empate");
    return;
  }

  // swap turn back to human
  currentPlayer = 1;
  updateStatus(config);
}

