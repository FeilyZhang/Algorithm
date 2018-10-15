package tech.feily.algorithm;

public class Test {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        System.out.println(arrayList.size());
        for (int i = 0; i < 12; i++) {
            arrayList.add(i * i);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + "\t");
        }
        System.out.println();
        arrayList.set(10, 10);
        arrayList.del(11);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + "\t");
        }
    }
}
