import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cliente {
    private String nombre;
    private int turno;

    public Cliente(String nombre, int turno) {
        this.nombre = nombre;
        this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTurno() {
        return turno;
    }

    @Override
    public String toString() {
        return "Turno " + turno + " - " + nombre;
    }
}

public class ColaClientes {
    public static void main(String[] args) {
        Queue<Cliente> cola = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int contadorTurno = 1;

        do {
            System.out.println("\n--- Cola de Atención al Cliente ---");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Atender cliente");
            System.out.println("3. Ver siguiente cliente");
            System.out.println("4. Mostrar cola");
            System.out.println("5. ¿La cola está vacía?");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre del cliente: ");
                        String nombre = scanner.nextLine();
                        Cliente nuevo = new Cliente(nombre, contadorTurno++);
                        cola.add(nuevo);
                        System.out.println("Cliente agregado con éxito.");
                        break;
                    case 2:
                        if (cola.isEmpty()) {
                            System.out.println("No hay clientes en la cola.");
                        } else {
                            Cliente atendido = cola.poll();
                            System.out.println("Atendiendo a: " + atendido);
                        }
                        break;
                    case 3:
                        if (cola.isEmpty()) {
                            System.out.println("No hay clientes en la cola.");
                        } else {
                            System.out.println("Siguiente cliente: " + cola.peek());
                        }
                        break;
                    case 4:
                        if (cola.isEmpty()) {
                            System.out.println("La cola está vacía.");
                        } else {
                            System.out.println("Clientes en la cola:");
                            for (Cliente c : cola) {
                                System.out.println(c);
                            }
                        }
                        break;
                    case 5:
                        System.out.println(cola.isEmpty() ? "Sí, está vacía." : "No, hay clientes esperando.");
                        break;
                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida.");
                opcion = 0;
            }

        } while (opcion != 6);

        scanner.close();
    }
}
