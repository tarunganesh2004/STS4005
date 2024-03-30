// Linked List Creation

import java.util.Scanner;

class node {
    int data;
    node next;

    node(int n) {
        data = n;
        next = null;
    }
}

class Main {
    public static node head=null;

    public static void insert(int n) {
        node newNode = new node(n);
        if (head == null) {
            head = newNode;
        } else {
            node cur = head;
            while (cur.next!= null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    public static void display() {
        node cur = head;
        while (cur != null) {
            System.out.print(cur.data + "-->");
            cur = cur.next;
        }
         System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            insert(sc.nextInt());
        }
        display();
    }
}