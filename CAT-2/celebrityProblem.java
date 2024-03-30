import java.util.Scanner;
import java.util.Stack;

public class celebrityProblem {

    public static void findCelebrity(int[][] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(i); // push indices of all people
        }

        while (st.size() >= 2) {
            int c = st.pop(); // column
            int d = st.pop(); // row
            if (arr[c][d] == 1) {
                st.push(d);
            } else {
                st.push(c);
            }
        }

        int pc = st.pop();
        for (int i = 0; i < n; i++) {
            if (i != pc) {
                if (arr[i][pc] == 0 || arr[pc][i] == 1) {
                    System.out.println("No Celebrity");
                    return;
                }
            }

        }
        System.out.println(pc); // if we want index return pc+1
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        findCelebrity(arr);
        sc.close();
    }
}
