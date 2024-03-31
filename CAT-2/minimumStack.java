// Minimum Stack
import java.util.*;
public class minimumStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Method 1
        Stack<Integer> st = new Stack<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
            if (min > st.peek()) {
                min = st.peek();
            }
        }
        System.out.println(min);
        sc.close();
    }
}
