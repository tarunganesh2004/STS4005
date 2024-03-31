import java.util.Scanner;

public class bitonic {
    static class node {
        int data;
        node next;
        node prev;

        node(int n) {
            data = n;
            next = null;
            prev = null;
        }
    }

    static node head = null;

    static void insert(int n) {
        node cur = new node(n);
        if (head == null)
            head = cur;
        else {
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            cur.prev = temp;
            temp.next = cur;
        }
    }

    static void display() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    static void bit() {
        node first = head;
        node last = head;
        node res = null;
        node resend = null;
        while (last.next != null)
            last = last.next;
        // start the condition checking
        while (first != last) {
            if (first.data <= last.data) {
                if (res == null) {
                    res = resend = first;
                    first = first.next;
                } else {
                    node cur = first.next;
                    resend.next = first;
                    first.prev = resend;
                    cur.prev = null;
                    first = cur;
                    resend = resend.next;
                }
            } else {
                if (res == null) {
                    res = resend = last;
                    last = last.prev;
                } else {
                    node cur = last.prev;
                    resend.next = last;
                    last.prev = resend;
                    cur.next = null;
                    last = cur;
                    resend = resend.next;
                }
            }
        }
        // after while
        resend.next = first;
        first.prev = resend;
        head = res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            insert(sc.nextInt());
        }
        display();
        System.out.println();
        bit();
        display();
    }
}