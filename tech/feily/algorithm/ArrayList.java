package tech.feily.algorithm;

import java.util.Arrays;

/*
 * @author Feily Zhang
 * @version 1.0 
 */
public class ArrayList {

    private static final int INITIAL_SIZE = 10;
    private int size = 0;
    private int[] array;

    public ArrayList() {
        array = new int[INITIAL_SIZE];
    }

    public ArrayList(int initialSize) {
        if (initialSize < 0) {
            initialSize = INITIAL_SIZE;
        }
        array = new int[initialSize];
    }

    /**
     * 添加元素
     * @param ele
     */
    public void add(int ele) {
        if (size == array.length) {
            array = Arrays.copyOf(array, size * 2);
        }
        array[size++] = ele;
    }

    /**
     * 获取指定位置元素
     * @param index
     */
    public int get(int index) {
        if (index >= size ) {
            throw new IndexOutOfBoundsException("下标越界啦！");
        }
        return array[index];
    }

    /**
     * 设置指定位置元素并返回原元素
     * @param index
     * @param ele
     */
    public int set(int index, int ele) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("下标越界啦！");
        }
        int oldEle = array[index];
        array[index] = ele;
        return oldEle;
    }

    /**
     * 删除指定位置元素
     * @param index
     */
    public int del(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("下标越界啦！");
        }
        int oldEle = array[index];
        for (int i = index; i < array.length - 1; i++) {
            array[index] = array[index + 1];
        }
        size -= 1;
        return oldEle;
    }

    /**
     * 获取列表实际长度
     * @return
     */
    public int size() {
        return size;
    }

}
