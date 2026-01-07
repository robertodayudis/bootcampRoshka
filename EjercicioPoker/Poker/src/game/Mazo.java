package game;

import model.Carta;
import model.Palo;
import model.Valor;

import java.util.Random;

public class Mazo {
    private final Random random;

    public Mazo() {
        this.random = new Random();
    }

    public Carta[] repartirMano5(){
        Carta[] mano = new Carta[5];
        int i = 0;

        while (i<5){
            Valor valor = valorRandom();
            Palo palo = paloRandom();
            Carta nueva = new Carta(valor, palo);

            if(!existeEnMano(mano, i, nueva)){
                mano[i] = nueva;
                i++;
            }
        }
        return mano;
    }
    private boolean existeEnMano(Carta[] mano, int hasta, Carta candidata){
        for (int j = 0; j < hasta; j++) {
            if (mano[j].getValor() == candidata.getValor() && mano[j].getPalo() == candidata.getPalo()){
                return true;
            }
        }
        return false;
    }

    private Valor valorRandom(){
        Valor[] valores = Valor.values();
        return valores[random.nextInt(valores.length)];
    }

    private Palo paloRandom(){
        Palo[] palos = Palo.values();
        return palos[random.nextInt(palos.length)];
    }


}
