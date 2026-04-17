package ex1;

import java.util.Random;

public class Test {
    public static void main(String[] args) { // main added by Fatima

        int n = 10000;
        Random rand = new Random();

        double[] loadFactors = {0.25, 0.5, 0.75, 0.9};

        for (double lf : loadFactors) {
            ChainHashMap<Integer, Integer> map = new ChainHashMap<>(17, lf);

            long start = System.nanoTime();

            for (int i = 0; i < n; i++) {
                map.put(rand.nextInt(100000), i);
            }

            long end = System.nanoTime();

            System.out.println("Load Factor: " + lf +
                    " | Time: " + (end - start) + " ns" +
                    " | Size: " + map.size());
        }
    }
} 