package tech.feily.algorithm;

public class ArrayQueue {

    private final Object[] items;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.items = new Object[capacity];
    }

    /*
     * 添加元素至队列末尾
     * @param item
     * @return
     */
    public boolean put(Object item) {
        if (head == (tail + 1) % items.length) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % items.length;
        return true;
    }

    /*
     * 获取队列头元素，不出队
     * @return
     */
    public Object peek() {
        if (head == tail) {
            return null;
        }
        return items[head];
    }

    /*
     * 获取队列头元素，出队
     * @return
     */
    public Object pool() {
        if (head == tail) {
            return null;
        }
        Object item = items[head];
        items[head] = null;
        head = (head + 1) % items.length;
        return item;
    }

    /*
     * 队列是否已满
     * @return
     */
    public boolean isFull() {
        return head == (tail + 1) % items.length;
    }

    /*
     * 队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /*
     * 获取队列大小
     * @return
     */
    public int size() {
        if (tail >= head) {
            return tail - head;
        } else  {
            return tail + items.length - head;
        }
    }

}
