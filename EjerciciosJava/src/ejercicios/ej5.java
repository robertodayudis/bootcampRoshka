package ejercicios;
import java.util.Scanner;

public static void ejercicio5() {
    System.out.println("Ejercicio 5");
    // Lee un número por teclado e indica si es divisible entre 2 (resto = 0). Si no lo es,
    // también debemos indicarlo.
    Scanner numero = new Scanner(System.in);

    System.out.println("Introduce un numero: ");

    int numeroIngresado = numero.nextInt();
    if (numeroIngresado % 2 == 0)
        System.out.println("El numero " + numeroIngresado + " es divisible entre 2.");
    else
        System.out.println("El numero " + numeroIngresado + " no es divisible entre 2.");

    numero.close();
}
