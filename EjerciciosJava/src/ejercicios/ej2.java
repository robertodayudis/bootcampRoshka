package ejercicios;
import java.util.Scanner;

public class ejercicio2{
    public static void run(Scanner leerEjercicio) {
        System.out.println("Ejercicio 2");
        // Declara 2 variables numéricas (con el valor que desees), he indica cual es mayor de los dos.
        // Si son iguales indicarlo también. Ves cambiando los valores para comprobar que funciona.
        int num1 = 5;
        int num2 = 8;

        if (num1 > num2)
            System.out.println("El numero " + num1 + "es mayor que " + num2);
        else if (num2 > num1)
            System.out.println("El numero " + num2 + "es mayor que " + num1);
        else
            System.out.println("Los numeros son iguales.");
    }
}