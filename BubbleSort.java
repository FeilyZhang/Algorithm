package tech.feily.algorithm;

public class BubbleSort {

    private int[] array;

    public BubbleSort(int[] array) {
        this.array = array;
    }

    public void littleToBig() {
        int length = array.length;
        if (length > 0) {
            for (int i = 1; i < length; i++) {
                for (int j = 0; j < length - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        array[j] = array[j] + array[j + 1];
                        array[j + 1] = array[j] - array[j + 1];
                        array[j] = array[j] - array[j + 1];
                    }
                }
            }
        }
    }

    public void bigToLittle() {
        int length = array.length;
        if (length > 0) {
            for (int i = length - 1; i > 0; i--) {
                for (int j = length - 1; j > length - 1 - i; j--) {
                    if (array[j] > array[j - 1]) {
                        array[j] = array[j] + array[j - 1];
                        array[j - 1] = array[j] - array[j - 1];
                        array[j] = array[j] - array[j - 1];
                    }
                }
            }
        }
    }

    public void print() {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] array = {8, 6, 7, 0, 4, 9, 10};
        BubbleSort bs = new BubbleSort(array);
        bs.bigToLittle();
        bs.print();
        bs.littleToBig();
        bs.print();
    }

}
