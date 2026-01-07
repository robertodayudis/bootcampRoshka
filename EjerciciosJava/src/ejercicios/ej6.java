package ejercicios;
import java.util.Scanner;

public class ejercicio6{
    public static void run(Scanner leerEjercicio) {
        // Lee un número por teclado que pida el precio de un producto (puede tener
        // decimales) y calcule el precio final con IVA. El IVA sera una constante que sera del
        // 10%.
        System.out.println("Ejercicio 6");
        Scanner precio = new Scanner(System.in);

        System.out.println("Introduce el precio del producto: ");
        int precioProducto = precio.nextInt();

        int precioConIva = precioProducto + (precioProducto * 10/100);
        System.out.println("El precio del producto es: " + precioConIva);

        precio.close();
    }
}
