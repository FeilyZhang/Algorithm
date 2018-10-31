package tech.feily.algorithm;

public class InsertSort {

    private int[] array;

    public InsertSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        if (array == null) {
            throw new RuntimeException("数组为空！");
        }
        int length = array.length;
        if (length > 0) {
            for (int i = 1; i < length; i++) {
                int temp = array[i];
                int j = i;
                for (; j > 0 && array[j - 1] > temp; j--) {
                    array[j] = array[j - 1];
                }
                array[j] = temp;
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
        InsertSort bs = new InsertSort(array);
        bs.sort();
        bs.print();
    }

}
