package tech.feily.algorithm;

public class Queue2Stack {

    private ArrayQueue arrayQueue1;
    private ArrayQueue arrayQueue2;
    private int maxLength;

    public Queue2Stack(int capacity) {
        maxLength = capacity;
        arrayQueue1 = new ArrayQueue(capacity);
        arrayQueue2 = new ArrayQueue(capacity);
    }

    public boolean push(int item) {
        if (size() == maxLength) {
            return false;
        }
        if (arrayQueue2.isEmpty()) {
            arrayQueue1.put(item);
        } else {
            arrayQueue2.put(item);
        }
        return true;
    }

    public Object pop() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("栈为空！");
        } else {
            if (arrayQueue2.isEmpty()) {
                while (arrayQueue1.size() > 1) {
                    arrayQueue2.put(arrayQueue1.pool());
                }
                return arrayQueue1.pool();
            } else {
                while (arrayQueue2.size() > 1) {
                    arrayQueue1.put(arrayQueue2.pool());
                }
                return arrayQueue2.pool();
            }
        }
    }

    public int size() {
        return arrayQueue1.size() + arrayQueue2.size();
    }
    
}
