import java.util.Scanner;
import ejercicios.*

public class App{
    public static void main(String[] args) throws Exception {
        Scanner leerEjercicio = new Scanner(System.in);
        // Cambiar de acuerdo al ejercicio que se quiera comprobar

        System.out.println("Ingrese el numero del ejercicio (1-10): ");
        int ejercicio = leerEjercicio.nextInt();

        leerEjercicio.nextLine();
        switch (ejercicio) {
            case 1 -> ejercicio1();
            case 2 -> ejercicio2();
            case 3 -> ejercicio3();
            case 4 -> ejercicio4.run(leerEjercicio);
            case 5 -> ejercicio5();
            case 6 -> ejercicio6();
            case 7 -> ejercicio7();
            case 8 -> ejercicio8();
            case 9 -> ejercicio9();
            case 10 -> ejercicio10();

            default -> System.out.println("Solo hay 10 ejercicios.");
        }
        leerEjercicio.close();
    }









    public static void ejercicio6() {
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

    public static void ejercicio7() {
        // Muestra los números del 1 al 100 (ambos incluidos) divisibles entre 2 y 3.
        System.out.println("Ejercicio 7");
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0 && i % 3 == 0) {
                System.out.println(i + "-");
            }
        }
    }

    public static void ejercicio8() {
        // Lee un número por teclado y comprueba que este numero es mayor o igual que cero, si
        // no lo es lo volverá a pedir (do while), después muestra ese número por consola.
        System.out.println("Ejercicio 8");
        Scanner numero = new Scanner(System.in);
        int numeroIngresado;
        do{
            System.out.println("Introduce un numero(mayor que cero): ");
            numeroIngresado = numero.nextInt();
        }while (numeroIngresado < 0);

        System.out.println("El numero valido es: " + numeroIngresado);

        numero.close();
    }

    public static void ejercicio9() {
        // Escribe una aplicación con un String que contenga una contraseña cualquiera. Después
        // se te pedirá que introduzcas la contraseña, con 3 intentos. Cuando aciertes ya no pedirá
        // mas la contraseña y mostrara un mensaje diciendo “Correcto!”. Piensa bien en la
        // condición de salida (3 intentos y si acierta sale, aunque le queden intentos, si no acierta
        // en los 3 intentos mostrar el mensaje “Fallaste jaja!!”).
        System.out.println("Ejercicio 9");
        final String contrasenaGenerada = "admin123";
        int intentos = 3;
        boolean acertado = false;
        Scanner contra = new Scanner(System.in);

        do{    
            System.out.println("Introduce la contrasena: ");
            String contrasena = contra.nextLine();
            if (contrasena.equals(contrasenaGenerada)){
                System.out.println("Contrasena correcta");
                acertado = true;
            }else{
                intentos--;
                System.out.println("Contrasena incorrecta. Te quedan " + intentos + " intentos.");
            }

        }while (intentos > 0 && !acertado);

        if (!acertado){
            System.out.println("Fallaste jaja!!");
        }

        contra.close();

    }

    public static void ejercicio10() {
        // Crea una aplicación que nos pida un día de la semana y que nos diga si es un dia
        // laboral o no (“De lunes a viernes consideramos dias laborales
        System.out.println("Ejercicio 10");
        Scanner dia = new Scanner(System.in);

        System.out.println("Introduce un dia de la semana: ");
        String diaIngresado = dia.nextLine().toLowerCase();

        switch (diaIngresado) {
            case "lunes", "martes", "miercoles", "jueves", "viernes":
                System.out.println("Es un dia laboral");
                break;
            case "sabado", "domingo":
                System.out.println("Es fin de semana");
                break;
            default:
                break;
        }
        dia.close();
    }

}
