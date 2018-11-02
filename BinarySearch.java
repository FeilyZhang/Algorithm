package tech.feily.algorithm;

public class BinarySearch {

    private int[] array;

    public  BinarySearch(int[] array) {
        this.array = array;
    }

    public int binarySearch(int value, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (array[mid] == value) {
            return mid;
        } else if (value < array[mid]) {
            return binarySearch(value, start, mid - 1);
        } else {
            return binarySearch(value, mid + 1, end);
        }
    }

    public int search(int value) {
        if (array != null) {
            return binarySearch(value, 0, array.length - 1);
        }
        return -1;
    }
    
}
