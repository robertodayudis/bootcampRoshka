import random

def generar_random():
    num1 = random.randint(1, 9)

    restantes = [num for num in range(10) if num != num1]
    num2, num3, num4 = random.sample(restantes, 3)

    return "".join(map(str, [num1, num2, num3, num4]))


def validar(s: str):
    s = s.strip()
    if len(s) != 4:
        return False
    if not s.isdigit():
        return False
    if s[0] == "0":
        return False
    if len(set(s)) != 4:
        return False
    return True

def juego(valorSecreto: str, valorJugador: str):
    toros = sum(1 for i in range(4) if valorJugador[i] == valorSecreto[i])
    vacas = sum(1 for j in valorJugador if j in valorSecreto) - toros
    return vacas, toros

def main ():
    replay = "Y"
    while (replay == "Y" or replay == "y"):
        numSecreto = generar_random().strip()

        intento = input("Ingrese un numero de 4 digitos, sin valores repetidos ni cero al inicio: ")
        while not validar(intento):
            intento = input("Intente de nuevo(4 digitos, sin 0 al inicio, ni repetir)").strip()
        
        vacas, toros = juego(numSecreto, intento)
        print(f"{vacas} vacas, {toros} toros")


        while toros != 4:
            intento = input("Probar de vuelta: ").strip()
            while not validar(intento):
                intento = input("Intente de nuevo(4 digitos, sin 0 al inicio, ni repetir)").strip()

            vacas, toros = juego(numSecreto, intento)
            print(f"{vacas} vacas, {toros} toros")
        
        
        print(f"¡Felicidades! El número secreto era: {numSecreto}")
        replay = input("Desea volver a jugar? (Y/N)")

if __name__ == "__main__":
    main()
