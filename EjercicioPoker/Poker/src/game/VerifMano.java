package game;

import model.Carta;
import model.RangoMano;
import model.Palo;

import java.util.Arrays;

public class VerifMano {

    public RangoMano evaluar(Carta[] mano) {
        int[] conteoValores = contarValores(mano);
        int[] conteoPalos = contarPalos(mano);

        boolean esColor = esColor(conteoPalos);
        boolean esEscalera = esEscalera(mano);

        if (esColor && esEscalera) return RangoMano.ESCALERA_COLOR;
        if (esPoker(conteoValores)) return RangoMano.POKER;
        if (esFull(conteoValores)) return RangoMano.FULL;
        if (esColor) return RangoMano.COLOR;
        if (esEscalera) return RangoMano.ESCALERA;
        if (esTrio(conteoValores)) return RangoMano.TRIO;
        if (esParDoble(conteoValores)) return RangoMano.PAR_DOBLE;
        if (esPar(conteoValores)) return RangoMano.PAR;

        return RangoMano.CARTA_ALTA;
    }

    private int[] contarValores(Carta[] mano) {
        int[] conteo = new int[15];
        for (Carta c : mano) {
            int v = c.getNumeroValor();
            conteo[v]++;
        }
        return conteo;
    }

    private int[] contarPalos(Carta[] mano) {
        int[] conteo = new int[Palo.values().length];
        for (Carta c : mano){
            conteo[c.getPalo().ordinal()]++;
        }
        return conteo;
    }

    private boolean esColor(int[] conteoPalos) {
        for (int cant : conteoPalos) {
            if (cant == 5) return true;
        }
        return false;
    }

    private boolean esEscalera(Carta[] mano){
        int[] valores = new int[5];
        for ( int i = 0; i < 5; i++)  valores[i] = mano[i].getNumeroValor();

        Arrays.sort(valores);

        for (int i = 1; i < 5; i++) {
            if (valores[i] == valores[i - 1]) return false;
        }

        boolean esAsBajo = (valores[0] == 2 && valores[1] == 3 && valores[2] == 4 && valores[3] == 5 && valores[4] == 14);
        if (esAsBajo) return true;

        for (int i = 1; i < 5; i++) {
            if (valores[i] != valores[i - 1] + 1) return false;
        }
        return true;
    }

    private boolean esPoker(int[] conteoValores) {
        for (int cant : conteoValores) {
            if (cant == 4) return true;
        }

        return false;
    }

    private boolean esFull(int[] conteoValores) {
        boolean hayTres = false;
        boolean hayDos = false;
        for (int cant : conteoValores) {
            if (cant == 3) hayTres = true;
            else if (cant == 2) hayDos = true;
        }
        return hayTres && hayDos;
    }

    private boolean esTrio(int[] conteoValores) {
        boolean hayTres = false;
        boolean hayDos = false;
        for (int cant : conteoValores) {
            if (cant == 3) hayTres = true;
            else if (cant == 2) hayDos = true;
        }
        return hayTres && !hayDos;
    }

    private boolean esParDoble(int[] conteoValores) {
        int pares = 0;
        for (int cant : conteoValores) {
            if (cant == 2) pares++;
        }
        return pares == 2;
    }

    private boolean esPar(int[] conteoValores) {
        int pares = 0;
        for (int cant : conteoValores) {
            if (cant == 2) pares++;
        }
        return pares == 1;
    }
}
