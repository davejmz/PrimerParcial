import java.io.File;
import java.util.Scanner;

public class Parcial1_Ordenamiento {

    public static void mostrarInformacion() {
        System.out.println("========================================");
        System.out.println("Universidad Da Vinci de Guatemala");
        System.out.println("Estructura de Datos");
        System.out.println("Ing. Brandon Chitay");
        System.out.println("Proyecto: Algoritmos de Ordenamiento y Búsqueda");
        System.out.println("Desarrollador: [Tu Nombre Aquí]");
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        mostrarInformacion();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Verificando archivos en la carpeta Numeros...");

            File folder = new File("../Numeros");
            File[] listOfFiles = folder.listFiles();

            if (listOfFiles != null) {
                System.out.println("Archivos en la carpeta Numeros:");
                for (File file : listOfFiles) {
                    System.out.println("- " + file.getName());
                }
            } else {
                System.out.println("No se encontró la carpeta Numeros.");
                return;
            }

            String archivo = "../Numeros/Numeros.csv";

            // Cargar los datos desde el archivo CSV
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

            int opcion = 0;
            while (opcion < 1 || opcion > 5) {
                try {
                    System.out.print("Ingrese una opción válida (1-5): ");
                    opcion = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Ingrese un número entre 1 y 5.");
                }
            }

            switch (opcion) {
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
    }
}
