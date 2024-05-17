import java.util.*;

class node {
    int data;
    node left;
    node right;

    node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class view {
    public static node built(String[] s) {
        if (s.length == 0 || s[0] == "-1") {
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

    public static void lv(node root, List<Integer> l, int level) {
        if (root == null) {
            return;
        }
        if (level == l.size()) {
            l.add(root.data);
        }
        if (root.left != null) {
            lv(root.left, l, level + 1);
        }
        if (root.right != null) {
            lv(root.right, l, level + 1);
        }
    }
    
    public static void rv(node root, List<Integer> l, int level) {
        if (root == null) {
            return;
        }
        if (level == l.size()) {
            l.add(root.data);
        }
        if (root.right != null) {
            rv(root.right, l, level + 1);
        }
        if (root.left != null) {
            rv(root.left, l, level + 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        node root = built(s);
        List<Integer> l = new ArrayList<>();
        lv(root, l, 0);
        System.out.println("Left view: ");
        for (int i : l) {
            System.out.print(i + " ");
        }
        l.clear();
        rv(root, l, 0);
        System.out.println("\nRight view: ");
        for (int i : l) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
