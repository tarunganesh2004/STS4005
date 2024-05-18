import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

class Pair {
    TreeNode node;
    int hd;

    Pair(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class bottomView {
    public static TreeNode built(String[] s) {
        if (s == null || s.length == 0 || s[0].equals("-1")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int i = 1;

        while (!q.isEmpty() && i < s.length) {
            Pair cur = q.poll();
            String cval = s[i];

            if (!cval.equals("-1")) {
                cur.node.left = new TreeNode(Integer.parseInt(cval));
                q.add(new Pair(cur.node.left, cur.hd - 1));
            }
            i++;
            if (i >= s.length)
                break;

            cval = s[i];
            if (!cval.equals("-1")) {
                cur.node.right = new TreeNode(Integer.parseInt(cval));
                q.add(new Pair(cur.node.right, cur.hd + 1));
            }
            i++;
        }

        return root;
    }

    public static void bottomView(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            // Always update the map for bottom view
            map.put(cur.hd, cur.node.data);
            if (cur.node.left != null) {
                q.add(new Pair(cur.node.left, cur.hd - 1));
            }
            if (cur.node.right != null) {
                q.add(new Pair(cur.node.right, cur.hd + 1));
            }
        }

        for (int val : map.values()) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        TreeNode root = built(s);
        bottomView(root);
        sc.close();
    }
}
