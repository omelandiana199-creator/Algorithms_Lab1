import java.util.*;

public class Algorithms {

    // 1. Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // 2. Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // 3. Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int[] L = Arrays.copyOfRange(arr, left, mid + 1);
        int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left;
        while (i < L.length && j < R.length) arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
    }

    // 4.  Counting Sort
    public static void countingSort(int[] arr, int maxVal) {
        int[] count = new int[maxVal + 1];
        for (int num : arr) count[num]++;
        int k = 0;
        for (int i = 0; i <= maxVal; i++) {
            while (count[i]-- > 0) arr[k++] = i;
        }
    }

    // 5. Kadane
    public static int kadane(int[] arr) {
        int max = arr[0], cur = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cur = Math.max(arr[i], cur + arr[i]);
            max = Math.max(max, cur);
        }
        return max;
    }

    // 6. String Search
    public static int naiveStringSearch(String txt, String pat) {
        int N = txt.length(), M = pat.length();
        for (int i = 0; i <= N - M; i++) {
            int j = 0;
            while (j < M && txt.charAt(i + j) == pat.charAt(j)) j++;
            if (j == M) return i;
        }
        return -1;
    }

    // 7. Fast Power
    public static long fastPower(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if (exp % 2 == 1) res *= base;
            base *= base;
            exp /= 2;
        }
        return res;
    }

    // 8. Matrix
    public static void multiplyMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++) C[i][j] += A[i][k] * B[k][j];
    }

    // 9. BFS
    public static void bfs(int[][] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(start); visited[start] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < graph.length; v++) {
                if (graph[u][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    // 10. Floyd Cycle
    static class Node { int val; Node next; Node(int v) { val = v; } }
    public static boolean hasCycle(Node head) {
        Node s = head, f = head;
        while (f != null && f.next != null) {
            s = s.next; f = f.next.next;
            if (s == f) return true;
        }
        return false;
    }
}