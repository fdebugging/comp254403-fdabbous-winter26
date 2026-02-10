import java.util.Random;

public class PrefixAverageExperiment {

    public static void main(String[] args) {
        int[] sizes = {500, 1000, 2000, 4000, 8000, 16000};

        for (int n : sizes) {
            double[] data = generateArray(n);

            long start1 = System.nanoTime();
            PrefixAverage.prefixAverage1(data);
            long end1 = System.nanoTime();

            long start2 = System.nanoTime();
            PrefixAverage.prefixAverage2(data);
            long end2 = System.nanoTime();

            long time1 = end1 - start1;
            long time2 = end2 - start2;

            System.out.println("n = " + n);
            System.out.println("prefixAverage1 time: " + time1 + " ns");
            System.out.println("prefixAverage2 time: " + time2 + " ns");
            System.out.println();
        }
    }

    private static double[] generateArray(int n) {
        Random rand = new Random();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextDouble();
        }
        return arr;
    }
}
