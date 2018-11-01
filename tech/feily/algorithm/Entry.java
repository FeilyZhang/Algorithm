package tech.feily.algorithm;

public class Entry {

    int key;
    int value;

    /*
     * 利用链地址法处理碰撞
     * 指向同地址的下一个key-value
     */
    Entry next;

    public Entry(int key, int value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

}
