import java.util.Scanner;

public class towerOfHanoiAnother {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char s = 'A', a = 'B', d = 'C';
        towerOfHanoi1(n, s, a, d);
        toh1(n, 1, 3, 2);
        
    }

    public static int towerOfHanoi1(int n, char s, char a, char d) {
        if (n == 1) {
            System.out.println("Move 1 from " + s + " to " + d);
            return 1;
        }
        int c1 = towerOfHanoi1(n - 1, s, d, a);
        System.out.println("Move " + n + " from " + s + " to " + d);
        int c2 = towerOfHanoi1(n - 1, a, s, d);
        return c1 + c2 + 1;
    }

    static long count = 0;

    public static void toh1(int N, int from, int to, int aux) {
        if (N == 0) {
            return ;
        }
        toh1(N - 1, from, aux, to);
        System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
        // count++;
        toh1(N - 1, aux, to, from);
        // return count;
    }
}
