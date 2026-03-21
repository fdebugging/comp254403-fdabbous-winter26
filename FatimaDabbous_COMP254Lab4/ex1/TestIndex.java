package ex1;
public class TestIndex {
    public static void main(String[] args) {
        LinkedPositionalList<String> list = new LinkedPositionalList<>();

        Position<String> p1 = list.addLast("A");
        Position<String> p2 = list.addLast("B");
        Position<String> p3 = list.addLast("C");

        System.out.println("List: " + list);
        System.out.println("Index of A: " + list.indexOf(p1));
        System.out.println("Index of B: " + list.indexOf(p2));
        System.out.println("Index of C: " + list.indexOf(p3));
    }
}