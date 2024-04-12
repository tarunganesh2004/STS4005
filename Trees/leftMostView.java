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

public class leftMostView {
    public static void leftView(node root, List<Integer> l, int level) {
        if (root == null)
            return;

        if (level == l.size()) {
            l.add(root.data);
        }
        if (root.left != null) {
            leftView(root.left, l, level + 1);
        }
        if (root.right != null) {
            leftView(root.right, l, level + 1);
        }
    }

    public static node built(String s[]) {
        // base condition
        if (s.length == 0 || s[0] == "N")
            return null;
        node root = new node(Integer.parseInt(s[0]));
        Queue<node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            node cur = q.poll();
            String cval = s[i];
            if (!cval.equals("N")) {
                cur.left = new node(Integer.parseInt(cval));
                q.add(cur.left);
            }
            i++;
            if (i >= s.length)
                break;
            cval = s[i];
            if (!cval.equals("N")) {
                cur.right = new node(Integer.parseInt(cval));
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        node root = built(s);
        ArrayList<Integer> l = new ArrayList<>();
        leftView(root, l, 0);
        for (int i : l) {
            System.out.print(i + " ");
        }

    }
}