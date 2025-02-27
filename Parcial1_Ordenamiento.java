import java.util.Scanner;

public class Parcial1_Ordenamiento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del archivo CSV (incluyendo la extensión):");
        String archivo = scanner.nextLine();

        // Cargar los datos desde el archivo CSV
        int[] datos = DataEntryCSV.loadData(archivo);

        // Mostrar el arreglo original
        System.out.println("Arreglo original:");
        for (int num : datos) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Menú para seleccionar el algoritmo de ordenamiento
        System.out.println("Seleccione el algoritmo de ordenamiento:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Bubble Sort Optimizado");
        System.out.println("3. Quick Sort");
        System.out.println("4. Selection Sort");
        System.out.println("5. Merge Sort");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                BubbleSort.sort(datos);
                break;
            case 2:
                BubbleSort2.sort(datos);
                break;
            case 3:
                QuickSort.sort(datos, 0, datos.length - 1);
                break;
            case 4:
                SelectionSort.sort(datos);
                break;
            case 5:
                MergeSort.sort(datos, 0, datos.length - 1);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        // Mostrar el arreglo ordenado
        System.out.println("Arreglo ordenado:");
        for (int num : datos) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Búsqueda binaria
        System.out.println("Ingrese el número a buscar:");
        int clave = scanner.nextInt();
        int resultado = BinarySearch.search(datos, clave);

        if (resultado != -1) {
            System.out.println("Número encontrado en la posición: " + resultado);
        } else {
            System.out.println("Número no encontrado.");
        }
        scanner.close();
    }
}
