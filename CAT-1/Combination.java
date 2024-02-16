import java.util.Arrays;
import java.util.Scanner;

public class Combination {
    static void com(int a[], int n, int r, int index, int d[], int i) {
        if (index == r) { // we got the combination with length r so print the combination
            for (int j = 0; j < r; j++)
                System.out.print(d[j] + " ");
            System.out.println(" ");
            return;
        }
        if (i >= n)
            return; // we don't have combinations to print so come out the method
        d[index] = a[i];
        com(a, n, r, index + 1, d, i + 1); // 1 2,1 3,1 4
        com(a, n, r, index, d, i + 1); // 2 3,3 4
    }

    static void printcom(int a[], int n, int r) {
        int d[] = new int[r]; // to store o/p
        com(a, n, r, 0, d, 0);
    }

    public static void main(String ar[]) {
        Scanner sw = new Scanner(System.in);
        // int n = sw.nextInt();
        var line = sw.nextLine().split(" ");
        int[] a = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        int n = a.length;

        // int a[] = new int[n];
        // for (int i = 0; i < n; i++)
        //     a[i] = sw.nextInt();
        int r = sw.nextInt();
        printcom(a, n, r);
        sw.close();
    }
}