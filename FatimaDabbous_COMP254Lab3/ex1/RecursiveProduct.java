public class RecursiveProduct {

    public static int recursiveProduct(int m, int n) {
        if (n == 0) {
            return 0; // base case
        }
        return m + recursiveProduct(m, n - 1); // recursive case
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 4;

        System.out.println("Product of " + m + " and " + n + " is: "
                + recursiveProduct(m, n));
    }
}
