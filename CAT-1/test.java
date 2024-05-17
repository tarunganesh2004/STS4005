import java.util.Stack;

public class test {
    public static void main(String[] args) {
        int[] a = { -2, 5, 3, 1, 2, 6, -4, 2 };
        int n = a.length;
        System.out.println(findMaxSum(a, n));
        System.out.println(findEquilibriumIndex(a, n));
        int[] a1 = { 1, 1, 2, 1, 3, 5, 1 };
        System.out.println(majorityElement(a1));
    }

    public static int findMaxSum(int[] a, int n) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];

        }
        int prefixSum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            prefixSum += a[i];
            if (prefixSum == sum) {
                res = Math.max(res, prefixSum);
            }
            sum -= a[i];
        }
        return res;
    }

    public static int findEquilibriumIndex(int[] a, int n) {
        int sum = 0;
        int leftSum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        for (int i = 0; i < n; i++) {
            sum -= a[i];
            if (sum == leftSum) {
                return i;
            }
            leftSum += a[i];
        }
        return -1;
    }

    public static void printLeaders(int[] a) {
        // int[] a={16,17,4,3,5,2};
        Stack<Integer> stack = new Stack<>();
        stack.push(a[a.length - 1]);
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] > stack.peek()) {
                stack.push(a[i]);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "  ");
        }
    }
    
    // majority element
    public static int majorityElement(int[] a) {
        // int[] a={2,4,3,4,4};
        int count = 0;
        int candidate = 0;
        for (int num : a) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    // josephus trap
    public static int josephus(int n, int k) {
        if (n == 1) {
            return 1;
        } else {
            return (josephus(n - 1, k) + k - 1) % (n+1);
        }
    }
}
