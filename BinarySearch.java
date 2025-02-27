// BinarySearch.java
public class BinarySearch {
    public static int search(int[] sortedArr, int key) {
        int low = 0;
        int high = sortedArr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArr[mid] == key) {
                return mid;
            } else if (sortedArr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}