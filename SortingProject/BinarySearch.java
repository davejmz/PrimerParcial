//BinarySearch.java
public class BinarySearch {
    public static int search(int[] arr, int clave) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == clave) {
                return mid;
            }
            if (arr[mid] < clave) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}