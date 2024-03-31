import java.util.*;

public class sortQueue {
    public static int min(Queue<Integer> q, int index) {
        int minVal = Integer.MAX_VALUE;
        int min_index = -1;
        int n = q.size();
        for (int i = 0; i < n; i++) {
            int cur = q.poll();
            if (cur <= minVal && i < index) {
                minVal = cur;
                min_index = i;
            }
            q.add(cur);
        }
        return min_index;
    }

    public static void insertAtEnd(Queue<Integer> q, int min_index) {
        int minVal = 0;
        int n = q.size();
        for (int i = 0; i < n; i++) {
            int cur = q.poll();
            if (i != min_index)
                q.add(cur);
            else
                minVal = cur;
        }
        q.add(minVal);
    }

    public static void sort(Queue<Integer> q) {
        for (int i = 0; i < q.size(); i++) {
            int min_index = min(q, q.size() - i);
            insertAtEnd(q, min_index);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }
        sort(q);
        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
    }
}