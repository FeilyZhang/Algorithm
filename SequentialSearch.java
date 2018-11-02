package tech.feily.algorithm;

public class SequentialSearch {

    private int[] array;

    public SequentialSearch(int[] array) {
        this.array = array;
    }

    public int search(int value) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (value == array[i]) {
                return i;
            }
        }
        return -1;
    }
    
}
