import java.util.*;

public class Tests {

    public static void main(String[] args) {
        // Розміри даних для графіків
        int[] sizes = {100, 1000, 2000, 5000, 10000};
        // Назви заголовків для графіків в Excel
        System.out.println("Size,Linear,Insert,Merge,Count,Kadane,String,Power,Matrix,BFS,Floyd");

        for (int N : sizes) {
            int[] arr = new Random().ints(N, 0, N).toArray();
            String text = "a".repeat(N) + "b";

            StringBuilder sb = new StringBuilder();
            sb.append(N).append(",");

            long start;


            // 1. Linear Search
            start = System.nanoTime();
            Algorithms.linearSearch(arr, -1);
            sb.append(System.nanoTime() - start).append(",");

            // 2. Insertion Sort
            if (N <= 5000) {
                int[] clone = arr.clone();
                start = System.nanoTime();
                Algorithms.insertionSort(clone);
                sb.append(System.nanoTime() - start);
            } else {
                sb.append("0");
            }
            sb.append(",");

            // 3. Merge Sort
            int[] cloneMerge = arr.clone();
            start = System.nanoTime();
            Algorithms.mergeSort(cloneMerge, 0, N - 1);
            sb.append(System.nanoTime() - start).append(",");

            // 4. Counting Sort
            int[] cloneCount = arr.clone();
            start = System.nanoTime();
            Algorithms.countingSort(cloneCount, N);
            sb.append(System.nanoTime() - start).append(",");

            // 5. Kadane
            start = System.nanoTime();
            Algorithms.kadane(arr);
            sb.append(System.nanoTime() - start).append(",");

            // 6. String Search
            start = System.nanoTime();
            Algorithms.naiveStringSearch(text, "aaab");
            sb.append(System.nanoTime() - start).append(",");

            // 7. Fast Power
            start = System.nanoTime();
            Algorithms.fastPower(2, N);
            sb.append(System.nanoTime() - start).append(",");

            // 8. Matrix
            if (N <= 500) {
                int[][] M = new int[N][N];
                for(int[] row : M) Arrays.fill(row, 1);
                start = System.nanoTime();
                Algorithms.multiplyMatrices(M, M);
                sb.append(System.nanoTime() - start);
            } else {
                sb.append("0");
            }
            sb.append(",");

            // 9. BFS
            int gSize = Math.min(N, 2000); // Обмежуємо розмір графа
            int[][] graph = new int[gSize][gSize];
            for (int i = 0; i < gSize - 1; i++) graph[i][i+1] = 1;
            start = System.nanoTime();
            Algorithms.bfs(graph, 0);
            sb.append(System.nanoTime() - start).append(",");

            // 10. Floyd Cycle
            Algorithms.Node head = new Algorithms.Node(1);
            Algorithms.Node curr = head;
            for(int i=0; i<N; i++) { curr.next = new Algorithms.Node(i); curr = curr.next; }
            curr.next = head;
            start = System.nanoTime();
            Algorithms.hasCycle(head);
            sb.append(System.nanoTime() - start);

            // Виводимо рядок результатів
            System.out.println(sb.toString());
        }
    }
}