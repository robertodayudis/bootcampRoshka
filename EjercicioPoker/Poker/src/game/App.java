package game;

import model.Carta;
import model.RangoMano;

public class App {
    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        Carta[] mano = mazo.repartirMano5();

        System.out.print("Mano: | ");
        for (Carta c : mano) {
            System.out.print(c + " | ");
        }
        System.out.println();

        VerifMano verificador = new VerifMano();
        RangoMano rango = verificador.evaluar(mano);

        System.out.println("Jugada: " + rango.getNombre());
    }
}

//Promedio
//package game;
//
//import model.Carta;
//import model.RangoMano;
//
//public class App {
//    public static void main(String[] args) {
//
//        final int Tiros = 10000000;
//
//        long totalNs = 0;
//
//        for (int i = 0; i < Tiros; i++) {
//            long inicioCont = System.nanoTime();
//
//            Mazo mazo = new Mazo();
//            Carta[] mano = mazo.repartirMano5();
//
////            System.out.println(i);
//
//            long end = System.nanoTime();
//            totalNs += (end - inicioCont);
//
//        }
//
//        double avgNs = totalNs / (double) Tiros;
//        System.out.printf("Promedio: %.3f ms (%.0f ns)%n",
//                avgNs / 1_000_000.0, avgNs);
//
//        System.out.println("--------------------------------------------------");
//
//    }
//}
