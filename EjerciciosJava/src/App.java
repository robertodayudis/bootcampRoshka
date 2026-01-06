import java.util.Scanner;

public class App{
    public static void main(String[] args) throws Exception {
        Scanner leerEjercicio = new Scanner(System.in);
        // Cambiar de acuerdo al ejercicio que se quiera comprobar

        System.out.println("Ingrese el numero del ejercicio (1-10): ");
        int ejercicio = leerEjercicio.nextInt();
        switch (ejercicio) {
            case 1 -> ejercicio1();
            case 2 -> ejercicio2();
            case 3 -> ejercicio3();
            case 4 -> ejercicio4();
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

    public static void ejercicio1() {
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

    public static void ejercicio2() {
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

    public static void ejercicio3() {
        System.out.println("Ejercicio 3");
        // Declara un String que contenga tu nombre, después muestra un mensaje de bienvenida
        // por consola. Por ejemplo: si introduzco “Fernando”, me aparezca “Bienvenido Fernando”.
        String nombre = "Roberto";
        System.out.println("Bienvenido, " + nombre);    
    }

    public static void ejercicio4() {
        System.out.println("Ejercicio 4");
        // Modifica la aplicación anterior, para que nos pida el nombre que queremos introducir.
        Scanner nombre = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        
        String nombreIngresado = nombre.nextLine();
        System.out.println("Bienvenido, " + nombreIngresado);
        nombre.close();
    }

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
