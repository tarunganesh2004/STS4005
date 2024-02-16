import java.util.Scanner;
import java.util.Arrays;
public class SelectionSort {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var line = sc.nextLine().split(" ");
        int[] arr = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        selection(arr);
        print(arr);
        sc.close();
    }

    public static void selection(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }

    public static void print(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
