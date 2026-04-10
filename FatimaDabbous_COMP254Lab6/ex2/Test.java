package ex2;

public class Test {

    //main added by Fatima
    public static void main(String[] args) {

        SortedTableMap<Integer, String> map = new SortedTableMap<>();

        map.put(10, "Apple");
        map.put(20, null);
        map.put(30, "Banana");

        System.out.println("Key 10 exists: " + map.containsKey(10)); // true
        System.out.println("Key 20 exists: " + map.containsKey(20)); // true
        System.out.println("Key 40 exists: " + map.containsKey(40)); // false
    }
}