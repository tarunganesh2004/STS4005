import java.util.*;

public class towerOfHanoi {
    static Stack<Integer> sr = new Stack<>();
    static Stack<Integer> ax = new Stack<>();
    static Stack<Integer> ds = new Stack<>();

    public static void change(Stack<Integer> s1, Stack<Integer> s2, char a, char b) {
        int v1, v2;
        if (s1.isEmpty()) {
            v1 = Integer.MIN_VALUE;
        } else {
            v1 = s1.pop();
        }
        if (s2.isEmpty()) {
            v2 = Integer.MIN_VALUE;
        } else {
            v2 = s2.pop();
        }

        if (v1 == Integer.MIN_VALUE) {
            s1.push(v2);
            System.out.println("The value " + v2 + " moved from " + b + " to " + a);
        }
        else if(v2==Integer.MIN_VALUE){
            s2.push(v1);
            System.out.println("The value " + v1 + " moved from " + a + " to " + b);
        }
        else if (v1 < v2) {
            s2.push(v2);
            s2.push(v1);
            System.out.println("The value " + v1 + " moved from " + a + " to " + b);
        }
        else {
            s1.push(v1);
            s1.push(v2);
            System.out.println("The value " + v2 + " moved from " + b + " to " + a);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = n; i > 0; i--) {
            sr.push(i);
        }
        char s = 'S', a = 'A', d = 'D';
        int moves = (int) (Math.pow(2, n) - 1);
        if (n % 2 == 0) {
            char temp = a;
            a = d;
            d = temp;
        }
        for (int i = 1; i <= moves; i++) {
            if (i % 3 == 1) {
                change(sr, ds, s, d);
            }
            if (i % 3 == 2) {
                change(sr, ax, s, a);
            }
            if (i % 3 == 0) {
                change(ax, ds, a, d);
            }
        }
    }
    
    public static int toh(int n, char s, char a, char d) {
        if (n == 1) {
            System.out.println("Move 1 from " + s + " to " + d);
            return 1;
        }
        int c1 = toh(n - 1, s, d, a);
        System.out.println("Move " + n + " from " + s + " to " + d);
        int c2 = toh(n - 1, a, s, d);
        return c1 + c2 + 1;
    }
}
