// Majority element

import java.util.Arrays;
import java.util.Scanner;

public class majorityElement {
    public static void main(String[] args) {
        //int[] a = { 1, 1, 2, 1, 3, 5, 1 }; //  majority element is 1

        var sc = new Scanner(System.in);
        var line = sc.nextLine().split(" ");
        int[] arr = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();

        // // Prompt the user to enter the array elements separated by spaces
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Enter the array elements separated by spaces: ");
        // String input = scanner.nextLine();

        // // Split the input string by spaces to get individual elements
        // String[] elements = input.split("\\s+");
        // int[] arr = new int[elements.length];

        // // Convert the string elements to integers and store them in the array
        // for (int i = 0; i < elements.length; i++) {
        //     arr[i] = Integer.parseInt(elements[i]);
        // }

        // scanner.close();

        majority(arr);
        FindmajorityElement(arr);
        sc.close();
    }

    // O(N^2)
    public static void majority(int[] a) {
        int maxCount = 0;
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                index = i;
            }

        }
        if (maxCount > a.length / 2) {
            System.out.println("Majority Element is " + a[index]);
        }
    }

    // O(N)
    // Boyer-Moore Voting Algorithm
    public static void FindmajorityElement(int[] a) {
        int count = 0;
        int candidate = 0;
        for (int nums : a) {
            if (count == 0) {
                candidate = nums;
            }
            if (nums == candidate) {
                count++;
            } else {
                count--;
            }
        }
        System.out.println(candidate);
    }
}
