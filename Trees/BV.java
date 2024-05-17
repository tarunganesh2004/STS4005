import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class node {
    int data;
    node left;
    node right;

    node(int n) {
        this.data = n;
        this.left = null;
        this.right = null;
    }
}

public class BV {
    public static node built(String[] s) {
        if (s.length == 0 || s[0].equals("-1")) {
            return null;
        }
        node root = new node(Integer.parseInt(s[0]));
        Queue<node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            node cur = q.poll();
            String cval = s[i];
            if (!cval.equals("-1")) {
                cur.left = new node(Integer.parseInt(cval));
                q.add(cur.left);
            }
            i++;
            if (i >= s.length)
                break;
            cval = s[i];
            if (!cval.equals("-1")) {
                cur.right = new node(Integer.parseInt(cval));
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void printBoundary(node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        leftBoundary(root.left);
        leaf(root.left);
        leaf(root.right);
        rightBoundary(root.right);
    }

    public static void leftBoundary(node root) {
        if (root == null)
            return;
        if (root.left != null) {
            System.out.print(root.data + " ");
            leftBoundary(root.left);
        } else if (root.right != null) {
            System.out.print(root.data + " ");
            leftBoundary(root.right);
        }
    }

    public static void rightBoundary(node root) {
        if (root == null)
            return;
        if (root.right != null) {
            rightBoundary(root.right);
            System.out.print(root.data + " ");
            // rightBoundary(root.right);
        } else if (root.left != null) {
            rightBoundary(root.left);
            System.out.print(root.data + " ");
            // rightBoundary(root.left);
        }
    }

    public static void leaf(node root) {
        if (root == null)
            return;
        leaf(root.left);
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        leaf(root.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        node root = built(s);
        printBoundary(root);
        sc.close();
    }
}
