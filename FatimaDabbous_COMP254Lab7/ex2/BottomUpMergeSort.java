import java.util.*;

public class BottomUpMergeSort {

    // Merge two sorted queues
    public static Queue<Integer> merge(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> result = new LinkedList<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() <= q2.peek()) {
                result.add(q1.poll());
            } else {
                result.add(q2.poll());
            }
        }

        while (!q1.isEmpty()) result.add(q1.poll());
        while (!q2.isEmpty()) result.add(q2.poll());

        return result;
    }

    // Bottom-up merge sort
    public static Queue<Integer> mergeSort(List<Integer> list) {
        Queue<Queue<Integer>> queueOfQueues = new LinkedList<>();

        // Step 1: each element in its own queue
        for (int item : list) {
            Queue<Integer> q = new LinkedList<>();
            q.add(item);
            queueOfQueues.add(q);
        }

        // Step 2: merge queues
        while (queueOfQueues.size() > 1) {
            Queue<Integer> q1 = queueOfQueues.poll();
            Queue<Integer> q2 = queueOfQueues.poll();

            Queue<Integer> merged = merge(q1, q2);
            queueOfQueues.add(merged);
        }

        return queueOfQueues.poll();
    }

    // MAIN METHOD (TEST)
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(5, 2, 9, 1, 6, 3);

        Queue<Integer> sorted = mergeSort(data);

        System.out.println("Sorted Output:");
        for (int num : sorted) {
            System.out.print(num + " ");
        }
    }
}