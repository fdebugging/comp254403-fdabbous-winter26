    package ex2;
    public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1; // index of top element

    @SuppressWarnings({"unchecked"})
    public ArrayStack() { this(CAPACITY); }

    @SuppressWarnings({"unchecked"})
    public ArrayStack(int capacity) { data = (E[]) new Object[capacity]; }

    @Override
    public int size() { return t + 1; }

    @Override
    public boolean isEmpty() { return t == -1; }

    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e;
    }

    @Override
    public E top() { return isEmpty() ? null : data[t]; }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t--] = null;
        return answer;
    }

    public static <E> void transfer(Stack<E> S, Stack<E> T) {
        while (!S.isEmpty()) {
            T.push(S.pop());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int j = 0; j <= t; j++) {  
            sb.append(data[j]);
            if (j < t) sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> S = new ArrayStack<>();
        Stack<Integer> T = new ArrayStack<>();

        S.push(1);
        S.push(2);
        S.push(3); 

        System.out.println("Before transfer:");
        System.out.println("S list: " + S);
        System.out.println("T list: " + T);

        ArrayStack.transfer(S, T);

        System.out.println("\nAfter transfer:");
        System.out.println("S list: " + S);
        System.out.println("T list: " + T);
    }
}