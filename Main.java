import java.util.Scanner;

// Define la interfaz Conducible
interface Conducible {
    void acelerar(int velocidad);
    void frenar();
}

// Crea una clase base abstracta llamada Vehiculo que implementa la interfaz Conducible
abstract class Vehiculo implements Conducible {
    protected String nombre;

    // Constructor de Vehiculo
    public Vehiculo(String nombre) {
        this.nombre = nombre;
    }
}

// Crea una clase derivada de Vehiculo: Automovil
class Automovil extends Vehiculo {
    private int pasajeros;

    // Constructor de Automovil
    public Automovil(String nombre, int pasajeros) {
        super(nombre);
        this.pasajeros = pasajeros;
    }

    // Implementa los métodos acelerar y frenar
    @Override
    public void acelerar(int velocidad) {
        System.out.println("El automóvil " + nombre + " está acelerando a " + velocidad + " km/h.");
    }

    @Override
    public void frenar() {
        System.out.println("El automóvil " + nombre + " está frenando.");
    }
}

// Crea otra clase derivada de Vehiculo: Bicicleta
class Bicicleta extends Vehiculo {
    // Constructor de Bicicleta
    public Bicicleta(String nombre) {
        super(nombre);
    }

    // Implementa los métodos acelerar y frenar
    @Override
    public void acelerar(int velocidad) {
        System.out.println("La bicicleta " + nombre + " está acelerando a " + velocidad + " km/h.");
    }

    @Override
    public void frenar() {
        System.out.println("La bicicleta " + nombre + " está frenando.");
    }
}

// Clase principal (main)
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.print("Ingrese el nombre del automóvil: ");
            String nombreAuto = scanner.nextLine();
            Automovil auto = new Automovil(nombreAuto, 5);

            System.out.print("Ingrese el nombre de la bicicleta: ");
            String nombreBici = scanner.nextLine();
            Bicicleta bici = new Bicicleta(nombreBici);

            System.out.println("\nAcciones del usuario:");
            System.out.print("Ingrese la velocidad de aceleración para el automóvil: ");
            int velocidadAuto = scanner.nextInt();
            auto.acelerar(velocidadAuto);
            auto.frenar();

            System.out.print("Ingrese la velocidad de aceleración para la bicicleta: ");
            int velocidadBici = scanner.nextInt();
            bici.acelerar(velocidadBici);
            bici.frenar();

            scanner.nextLine();  // Limpia el búfer de entrada
            System.out.print("¿Desea realizar otra simulación? (s/n): ");
            String respuesta = scanner.nextLine().toLowerCase();
            if (!respuesta.equals("s")) {
                continuar = false;
            }
        }

        scanner.close();
    }
}
