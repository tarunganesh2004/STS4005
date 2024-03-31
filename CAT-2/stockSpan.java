// Stock stack
// Input : 100 80 60 70 60 75 85
// o/p: 1 1 1 2 1 4 6

import java.util.Scanner;
import java.util.Stack;

public class stockSpan {
    public static void span(int[] p, int[] s, int n) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        s[0] = 1;
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && p[st.peek()] <= p[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                s[i] = i + 1;
            } else {
                s[i] = (i - st.peek());
            }
            st.push(i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n]; // Prices
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        int s[] = new int[n];
        span(p, s, n);
        for (int i = 0; i < n; i++) {
            System.out.print(s[i] + " ");
        }
        sc.close();
    }
}
