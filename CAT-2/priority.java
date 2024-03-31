import java.util.*;

public class priority {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int max = -1;
            int index = -1;
            for (int j = 0; j < p.length; j++) {
                if (p[j] > max) {
                    index = j;
                    max = p[j];
                }
            }
            System.out.print(arr[index]+" ");
            p[index] = -1;
        }
    }

}
