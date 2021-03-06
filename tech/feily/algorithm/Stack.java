package tech.feily.algorithm;

import com.sun.java.util.jar.pack.ConstantPool;

import java.util.Arrays;

public class Stack {

    private int size = 0;
    private int[] array;

    public Stack(int init) {
        if (init < 0) {
            init = 10;
        }
        array = new int[init];
    }

    public Stack() {
        this(10);
    }

    public void push(int item) {
        if (size == array.length) {
            array = Arrays.copyOf(array, size * 2);
        }
        array[size ++] = item;
    }

    public int peek() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("栈为空！");
        }
        return array[size - 1];
    }

    public int pop() {
        int item = peek();
        size --;
        return item;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

}
