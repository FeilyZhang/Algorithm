package tech.feily.algorithm;

public class SelectSort {

    private int[] array;

    public SelectSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    public void print() {
        for (int ele : array) {
            System.out.println(ele);
        }
    }

    public static void main(String[] args) {
        int[] array = {8, 6, 7, 0, 4, 9, 10};
        SelectSort bs = new SelectSort(array);
        bs.sort();
        bs.print();
    }

}
