package tech.feily.algorithm;

public class QuickSort {

    private int[] array;

    public QuickSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        quickSort(array, 0, array.length - 1);
    }

    public void print() {
        for (int arr : array) {
            System.out.println(arr);
        }
    }

    /*
     * 快速排序
     * @param src
     * @param begin
     * @param end
     */
    private void quickSort(int[] src, int begin, int end) {
        if (begin < end) {
            int temp = src[begin];
            int i = begin;
            int j = end;
            /*
             * 每进行一次while循环，即完成一轮排序
             * 即当前数组中中间数左边一定小于该数，右边一定大于该数
             * 但左右两部分并非有序，仍然需要递归再进行处理
             */
            while (i != j) {
                /*
                 * 先从右往左寻找小于基准值的数字
                 * 若找到则终止该while循环，此时找到的数字由j指出
                 * 否则继续找，即j --
                 */
                while (i < j && src[j] >= temp) {
                    j --;
                }
                /*
                 * 再从左往右寻找大于该基准值的数字
                 * 若找到则终止该while循环， 此时找到的数字由i指出
                 * 否则继续找，即i ++
                 */
                while (i < j && src[i] <= temp) {
                    i ++;
                }
                /*
                 * 交换找到的两数，不使用额外空间
                 */
                if (i < j) {
                    src[i] = src[i] + src[j];
                    src[j] = src[i] - src[j];
                    src[i] = src[i] - src[j];
                }
            }
            /*
             * 若i与j相遇，即i == j，那么判定本轮排序完成
             * 基准值不一定位于待排序数组的中间位置
             * 但基准值的左边各数字一定小于基准值，但是并非有序，须递归再处理
             * 但基准值的右边各数字一定大于基准值，但是并非有序，须递归再处理
             */
            /*
             * 交换两数位置，即将基准值放到合适的位置
             */
            src[begin] = src[i];
            src[i] = temp;
            /*
             * 对左右两部分再进行处理
             */
            quickSort(src, begin, i - 1);
            quickSort(src, i + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] array = {8, 6, 7, 0, 4, 9, 10};
        QuickSort qs = new QuickSort(array);
        qs.sort();
        qs.print();
    }

}
