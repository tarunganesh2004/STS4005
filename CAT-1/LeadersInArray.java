// Leaders in an array

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class LeadersInArray {
    public static void main(String[] args) {
        // int[] a = { 16, 17, 4, 3, 5, 2 };
        // int[] a1 = { 1, 2 };
        var sc = new Scanner(System.in);
        var line = sc.nextLine().split(" ");
        int[] arr = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        printLeaders(arr);
        System.out.println();
        // printleaders(a);
        sc.close();
    }

    // O(N^2)
    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for(int j=i+1;j<a.length;i++){
                if(a[i]<a[j]){
                    break;
             }
             if(j==a.length-1){
                System.out.print(a[i]+" ");
             }
            }
        }
    }

    // by Using ArrayList O(N)
    public static void printLeaders(int[] a) {
        List<Integer> leaders = new ArrayList<>();
        int max_from_right = a[a.length - 1];
        leaders.add(max_from_right);
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] >=max_from_right) {
                max_from_right = a[i];
                leaders.add(a[i]);
            }
        }
        for (int i = leaders.size() - 1; i >= 0; i--) {
            System.out.print(leaders.get(i) + " ");
        }
    }
    
    // by using stack
    public static void printleaders(int[] a) {
        Stack<Integer> stack = new Stack<>();
        stack.push(a[a.length - 1]);
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] > stack.peek()) {
                stack.push(a[i]);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }
}