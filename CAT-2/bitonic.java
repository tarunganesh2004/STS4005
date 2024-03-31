import
public class bitonic {
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
}
