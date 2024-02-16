// Max Equilibrium sum in an Array
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;
public class maxEquilibriumSum {
    public static void main(String[] args) {
        // arr=[-1, 2, 3, 0, 3, 2, -1]
        // arr=[-7, 1, 5, 2, -4, 3, 0]
        var sc = new Scanner(System.in);
        var line = sc.nextLine().split(" ");
        int[] arr = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        int max = findSum(arr);
        System.out.println(max);
        sc.close();
    }

    // Brute force O(N^2)
    public static int findMaxSum(int[] arr) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int prefix_sum = arr[i];
            for (int j = 0; j < i; j++) {
                prefix_sum += arr[j];
            }
            int suffix_sum = arr[i];
            for (int j = arr.length - 1; j > i; j--) {
                suffix_sum += arr[j];
            }

            if (prefix_sum == suffix_sum) {
                res = Math.max(res, prefix_sum);
            }
        }
        return res;
    }

    // GFG code O(N)
    public static int findSum(int[] arr) {
        int sum = IntStream.of(arr).sum();
        int n = arr.length;
        int prefix_sum = 0,
                res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            prefix_sum += arr[i];
            if (prefix_sum == sum)
                res = Math.max(res, prefix_sum);
            sum -= arr[i];
        }
        return res;
    }

    // O(N)
    public static int maxSum(int[] arr) {
        int totalSum = 0;
        int leftSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for (int num : arr) {
            totalSum += num;
        }

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            int rightSum = totalSum - leftSum ;
            if (leftSum == rightSum) {
                maxSum = Math.max(maxSum, leftSum);
            }
        }
        return maxSum != Integer.MIN_VALUE ? maxSum : -1;
    }
}
