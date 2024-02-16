import java.util.Scanner;

public class findCombinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int r = sc.nextInt();
        printcom(a, n, r);
        sc.close();
    }

    public static void com(int[] a, int n, int r, int index, int[] d, int i) {
        if (index == r) {
            for (int j = 0; j < r; j++) {
                System.out.print(d[j] + " ");
            }
            System.out.println(" ");
            return;
        }
        if (i >= n) // if we dont have any combinations to print so return
            return;
        d[index] = a[i];
        com(a, n, r, index + 1, d, i + 1);
        com(a, n, r, index, d, i + 1);
    }

    public static void printcom(int a[], int n, int r) {
        int d[] = new int[r];
        com(a, n, r, 0, d, 0);
    }
}
