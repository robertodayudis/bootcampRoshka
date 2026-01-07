package ejercicios;
import java.util.Scanner;

public class ejercicio4(){
    public static void run(Scanner leerEjercicio) {
        System.out.println("Ejercicio 4");
        // Modifica la aplicación anterior, para que nos pida el nombre que queremos introducir.
        Scanner nombre = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");

        String nombreIngresado = nombre.nextLine();
        System.out.println("Bienvenido, " + nombreIngresado);
        nombre.close();
    }
}
