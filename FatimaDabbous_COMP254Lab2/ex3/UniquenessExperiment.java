

public class UniquenessExperiment {

    private static final long ONE_MINUTE = 60_000_000_000L; // 60s in nanoseconds

    public static void main(String[] args) {
        testAlgorithm("unique1");
        testAlgorithm("unique2");
    }

    private static void testAlgorithm(String method) {
        long bestN = 0;
        
        long low = 1;
        long high = method.equals("unique1") ? 150_000L : 80_000_000L;

        while (low <= high) {
            int mid = (int) ((low + high) / 2);
            int[] data = generateWorstCaseArray(mid);

            long start = System.nanoTime();
            if (method.equals("unique1")) {
                Uniqueness.unique1(data);
            } else {
                Uniqueness.unique2(data);
            }
            long end = System.nanoTime();
            long duration = end - start;

            if (duration <= ONE_MINUTE) {
                bestN = mid;
                low = mid + 1; // Try larger n
            } else {
                high = mid - 1; // Too slow, try smaller n
            }
        }

        System.out.println(method + " max n in <= 1 min: " + bestN);
    }

    private static int[] generateWorstCaseArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i; // Ensures worst-case: elements are unique 
        }
        return arr;
    }
}