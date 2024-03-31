// segregrate even and odd nodes in a linked list

import java.util.Scanner;

public class segregrate {
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
        node cur = new node(n);
        if (head == null)
            head = cur;
        else {
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
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

    static void seg() {
        node evenStart = null;
        node evenEnd = null;
        node oddStart = null;
        node oddEnd = null;
        node cur = head;
        while (cur != null) {
            if (cur.data % 2 == 0) {
                if (evenStart == null) {
                    evenStart = cur;
                    evenEnd = cur;
                } else {
                    evenEnd.next = cur;
                    evenEnd = cur;
                }
            } else {
                if (oddStart == null) {
                    oddStart = cur;
                    oddEnd = cur;
                } else {
                    oddEnd.next = cur;
                    oddEnd = cur;
                }
            }
            cur = cur.next;
        }
        if (evenStart == null) {
            head = oddStart;
        } else {
            head = evenStart;
            evenEnd.next = oddStart;
            oddEnd.next = null;
        }
        // if (oddEnd != null) {
        //     oddEnd.next=null;
        // }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            insert(sc.nextInt());
        }
        display();
        seg();
        System.out.println();
        display();
    }
}
