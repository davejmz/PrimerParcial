import java.util.Scanner;

public class Parcial1_Ordenamiento {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el nombre del archivo CSV (incluyendo la extensión):");
            String archivo = scanner.nextLine();

            // Cargar los datos desde el archivo CSV
            int[] datos = DataEntryCSV.loadData(archivo);

            // Menú para seleccionar el algoritmo de ordenamiento
            System.out.println("Seleccione el algoritmo de ordenamiento:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Bubble Sort Optimizado");
            System.out.println("3. Quick Sort");
            System.out.println("4. Selection Sort");
            System.out.println("5. Merge Sort");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> BubbleSort.sort(datos);
                case 2 -> BubbleSort2.sort(datos);
                case 3 -> QuickSort.sort(datos, 0, datos.length - 1);
                case 4 -> SelectionSort.sort(datos);
                case 5 -> MergeSort.sort(datos, 0, datos.length - 1);
                default -> {
                    System.out.println("Opción no válida.");
                    return;
                }
            }

            // Búsqueda binaria
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
