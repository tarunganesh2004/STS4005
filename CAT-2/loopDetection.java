import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class loopDetection {
    static class node {
        int data;
        node next;

        node(int n) {
            data = n;
            next = null;
        }
    }

    static node head = null;

    static void insert(int n) {
        node newNode = new node(n);
        if (head == null) {
            head = newNode;
        } else {
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    static void display() {
        node cur = head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    static boolean createCycle(int a, int b) {
        // create cycle
        int c = 0;
        node p1 = head;
        node p2 = head;
        while (p1.data != a || c != b) {
            if (p1.data != a) {
                p1 = p1.next;
                if (p1.next == null) {
                    return false;
                }
            }
            if (c != b) {
                p2 = p2.next;
                ++c;
            }
        }
        p2.next = p1;
        return true;
    }
    static boolean detectCycle() {
        node slow = head;
        node fast = head;
        while (fast.next!= null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }

        }
        if (fast.next == null) {
            return false;

        }
        return false;

    }

    // public static boolean loopDetectionII(node h) {
    //     HashSet<node> s = new HashSet<>();
    //     while (h != null) {
    //         if (s.contains(h)) {
    //             return true;
    //         }
    //         s.add(h);
    //         h = h.next;
    //     }
    //     return false;
    // }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            insert(sc.nextInt());
        }
        // display();
        // boolean x = loopDetectionII(head);
        System.out.println(createCycle(2, 5));
        boolean x1 = detectCycle();
        // System.out.println(x);
        System.out.println(x1);
        sc.close();
    }
}