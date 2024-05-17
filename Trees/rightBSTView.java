import java.util.*;
class node {
    int data;
    node left;
    node right;

    node(int n) {
        this.data = n;
        left = null;
        right = null;
    }
}

public class rightBSTView {
    public static node insert(node root, int data) {
        if (root == null) {
            return new node(data);

        }
        if (root.data > data) {
            root.left = insert(root.left, data);
        } else if (root.data < data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static void RV(node root, List<Integer> r, int level) {
        if (root == null) {
            return;
        }
        if (level == r.size()) {
            r.add(root.data);
        }
        RV(root.right, r, level + 1);
        RV(root.left, r, level + 1);
    }

    public static void LV(node root, List<Integer> l, int level) {
        if (root == null) {
            return;
        }
        if (level == l.size()) {
            l.add(root.data);
        }
        LV(root.left, l, level + 1);
        LV(root.right, l, level + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        node root = null;
        for (String i : s) {
            int data = Integer.parseInt(i);
            root = insert(root, data);
        }
        List<Integer> l = new ArrayList<>();
        LV(root, l, 0);
        for (int i : l) {
            System.out.print(i + " ");
        }
        System.out.println();
        List<Integer> r = new ArrayList<>();
        RV(root, r, 0);
        for (int i : r) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
