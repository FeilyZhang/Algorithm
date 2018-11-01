package tech.feily.algorithm;

public class HashTable {

    /*
     * 散列表的初始化长度
     * 这里定义的比较小，原因是为了更好的理解底层数组的扩容，其实很耗损性能
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 4;

    /*
     * 扩容因子
     * 多数编程语言一般默认为0.75
     */
    private static final float LOAD_FACTOR = 0.75f;

    /*
     * 散列表数组
     */
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];

    /*
     * 该字段为当前散列表的元素个数
     * 一般情况下并不等于数组的length，因为使用链地址法处理碰撞
     */
    private int size = 0;

    /*
     * 该字段散列表使用地址的个数
     * 当该字段大于等于扩容因子与散列表数组length的乘积之时，则对散列表数组进行扩容并进行元素的重新哈希
     */
    private int use = 0;

    /*
     * 添加/修改元素
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new Entry(-1, -1, null);
        }
        Entry e = table[index];
        if (e.next == null) {
            table[index].next = new Entry(key, value, null);
            size ++;
            use ++;
            if (use >= table.length * LOAD_FACTOR) {
                resize();
            }
        } else {
            for (e = e.next; e != null; e = e.next) {
                int k = e.key;
                if (k == key) {
                    e.value = value;
                    return;
                }
            }
            Entry temp = table[index].next;
            Entry newEntry = new Entry(key, value, temp);
            table[index].next = newEntry;
            size++;
        }
    }

    /*
     * 删除元素
     * @param key
     */
    public void remove(int key) {
        int index = hash(key);
        Entry e = table[index];
        Entry pre = table[index];
        if (e != null && e.next != null) {
            for (e = e.next; e != null; pre = e, e = e.next) {
                int k = e.key;
                if (k == key) {
                    pre.next = e.next;
                    size --;
                    return;
                }
            }
        }
    }

    /*
     * 获取元素
     * @param key
     * @return
     */
    public int get(int key) {
        int index = hash(key);
        Entry e = table[index];
        if (e != null && e.next != null) {
            for (e = e.next; e != null; e = e.next) {
                int k = e.key;
                if (k == key) {
                    return e.value;
                }
            }
        }
        return -1;
    }

    /*
     * 获取散列表元素数目
     * @return
     */
    public int size() {
        return size;
    }

    /*
     * 获取散列表数组的length
     * @return
     */
    public int getLength() {
        return table.length;
    }

    /*
     * 哈希函数
     * @param key
     * @return
     */
    private int hash(int key) {
        return key % table.length;
    }

    /*
     * 散列表数组扩容并进行元素重新哈希
     * @return
     */
    private void resize() {
        int newLength = table.length * 2;
        Entry[] oldTable = table;
        table = new Entry[newLength];
        use = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null &&oldTable[i].next != null) {
                Entry e = oldTable[i];
                while (null != e.next) {
                    Entry next = e.next;
                    int index = hash(next.key);
                    if (table[index] == null) {
                        use ++;
                        table[index] = new Entry(-1, -1, null);
                    }
                    Entry temp = table[index].next;
                    Entry newEntry = new Entry(next.key, next.value, temp);
                    table[index].next = newEntry;
                    e = next;
                }
            }
        }
    }
}
