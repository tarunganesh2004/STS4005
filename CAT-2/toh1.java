import java.util.Scanner;

public class toh1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char s = sc.next().charAt(0);
        char a = sc.next().charAt(0);
        char d = sc.next().charAt(0);
        toh2(n, s, a, d);
        sc.close();
    }

    public static void toh2(int n, char s, char a, char d) {
        if (n == 1) {
            System.out.println("Move 1 from " + s + " to " + d);
            return;
        }
        toh2(n - 1, s, d, a);
        System.out.println("Move " + n + " from " + s + " to " + d);
        toh2(n-1, a,s,d);
   }
}
