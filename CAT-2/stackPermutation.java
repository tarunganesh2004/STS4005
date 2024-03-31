import java.util.*;
// import java.io.*;

public class stackPermutation {
    
    public static void stackpermutation(Queue<Integer> q1, Queue<Integer> q2) {
        int n=q1.size();
        int j = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            st.push(q1.peek());
            while(!st.isEmpty()&&st.peek()==q2.peek()){
                st.pop();
                q2.poll();
            }
            q1.poll();
        }
        if(j==n||st.isEmpty()){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Queue<Integer> q1 = qfromArr(arr1);
        Queue<Integer> q2 = qfromArr(arr2);
        stackpermutation(q1, q2);
        sc.close();
    }

    static Queue<Integer> qfromArr(int[] arr){
        Queue<Integer> q = new LinkedList<>();
        for (int i : arr) {
            q.add(i);
        }
        return q;
    }
}
