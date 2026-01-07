package ejercicios;
import java.util.Scanner;

public class ejercicio1{
    public static void run(Scanner leerEjercicio) {
        // Declara dos variables numéricas (con el valor que desees), muestra por consola la
        // suma, resta, multiplicación, división y módulo (resto de la división).
        System.out.println("Ejercicio 1");

        int num1 = 10;
        int num2 = 3;

        System.out.println("Los numeros son: " + num1 + " y " + num2);
        System.out.println("La suma es: " + (num1 + num2));
        System.out.println("La resta es: " + (num1 - num2));
        System.out.println("La multiplicacion es: " + (num1 * num2));
        System.out.println("La division es: " + (num1 / num2));
        System.out.println("El modulo es: " + (num1 % num2));
    }
}