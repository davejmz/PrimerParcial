import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parcial1_Ordenamiento {

    public static void mostrarInformacion() {
        //Datos fijos del proyecto
        String universidad = "Universidad Da Vinci de Guatemala";
        String curso = "Estructura de Datos";
        String docente = "Ing. Brandon Chitay";
        String proyecto = "Proyecto: Algoritmos de Ordenamiento y Búsqueda";
        String desarrollador = "Desarrollador: David Cristopher Coronado Jiménez Cabrera / 202401777";

        //Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        //Solicitar el nombre del estudiante
        System.out.print("Ingrese su nombre: ");
        String estudiante = scanner.nextLine();

        //Listas de tareas completadas y pendientes
        List<String> puntosHechos = new ArrayList<>();
        List<String> puntosFaltantes = new ArrayList<>();

        //Se inicia el proyecto con los primeros puntos completados
        puntosHechos.add("1. Información del Desarrollador");

        //Lista de tareas restantes
        puntosFaltantes.add("2. Menú Principal");
        puntosFaltantes.add("3. Carga de Datos desde un CSV");
        puntosFaltantes.add("4. Algoritmo de Ordenamiento - Bubble Sort");
        puntosFaltantes.add("5. Algoritmo de Ordenamiento - Bubble Sort 2 (Mejorado :D)");
        puntosFaltantes.add("6. Algoritmo de Ordenamiento - Quick Sort");
        puntosFaltantes.add("7. Algoritmo de Ordenamiento - Selection Sort");
        puntosFaltantes.add("8. Algoritmo de Ordenamiento - Merge Sort");
        puntosFaltantes.add("9. Algoritmo de Búsqueda - Binary Search");

        //Mostrar la información en consola
        System.out.println("\n========================================");
        System.out.println(universidad);
        System.out.println(curso);
        System.out.println(docente);
        System.out.println(proyecto);
        System.out.println(desarrollador);
        System.out.println("Nombre del estudiante: " + estudiante + "\n");

        //Mostrar tareas completadas
        System.out.println("PUNTOS HECHOS:");
        for (String punto : puntosHechos) {
            System.out.println("DONE" + punto);
        }

        //Mostrar tareas pendientes
        System.out.println("\nPUNTOS FALTANTES:");
        for (String punto : puntosFaltantes) {
            System.out.println("PENDING" + punto);
        }

        System.out.println("========================================");

        //Esperar a que el usuario presione Enter antes de continuar
        System.out.println("Presione Enter para continuar...");
        scanner.nextLine();  // Captura la entrada del usuario

        //Llamar al menú principal
        mostrarMenu(scanner);
    }

    public static void mostrarMenu(Scanner scanner) {
        try (scanner) {
            System.out.println("\n========== MENÚ PRINCIPAL ==========");
            System.out.println("1. Cargar datos desde un archivo CSV");
            System.out.println("2. Ordenar datos usando Bubble Sort");
            System.out.println("3. Ordenar datos usando Enhanced Bubble Sort");
            System.out.println("4. Ordenar datos usando Quick Sort");
            System.out.println("5. Ordenar datos usando Selection Sort");
            System.out.println("6. Ordenar datos usando Merge Sort");
            System.out.println("7. Buscar un número con Binary Search");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  //Limpiar el buffer
            
            switch (opcion) {
                case 1 -> {
                    System.out.println("Ingrese el nombre del archivo CSV (incluyendo la extensión):");
                    String archivo = scanner.nextLine();
                    int[] datos = DataEntryCSV.loadData(archivo);
                    
                    if (datos == null || datos.length == 0) {
                        System.out.println("No se pudieron cargar los datos. Verifique el archivo CSV.");
                        return;
                    }
                    
                    System.out.println("Seleccione el algoritmo de ordenamiento:");
                    System.out.println("1. Bubble Sort");
                    System.out.println("2. Bubble Sort Optimizado");
                    System.out.println("3. Quick Sort");
                    System.out.println("4. Selection Sort");
                    System.out.println("5. Merge Sort");
                    
                    int algoritmo = scanner.nextInt();
                    switch (algoritmo) {
                        case 1 -> BubbleSort.sort(datos);
                        case 2 -> BubbleSort2.sort(datos);
                        case 3 -> QuickSort.sort(datos, 0, datos.length - 1);
                        case 4 -> SelectionSort.sort(datos);
                        case 5 -> MergeSort.sort(datos, 0, datos.length - 1);
                    }
                    
                    System.out.println("Ingrese el número a buscar:");
                    int clave = scanner.nextInt();
                    int resultado = BinarySearch.search(datos, clave);
                    
                    if (resultado != -1) {
                        System.out.println("Número encontrado en la posición: " + resultado);
                    } else {
                        System.out.println("Número no encontrado.");
                    }
                }
                
                case 8 -> System.out.println("👋 Saliendo del programa...");
                
                default -> System.out.println("⚠️ Opción no válida. Intente de nuevo.");
            }
        }
    }

    public static void main(String[] args) {
        mostrarInformacion();  //Llamamos a la función principal
    }
}