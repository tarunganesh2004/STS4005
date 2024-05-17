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

public class rightView {
    public static node built(String s[]) {
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

    public static void rightview(node root, List<Integer> r, int level) {
        if (root == null) {
            return;
        }
        if (level == r.size()) {
            r.add(root.data);
        }
        if (root.right != null) {
            rightview(root.right, r, level + 1);
        }
        if (root.left != null) {
            rightview(root.left, r, level+1);
        }
    }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String s[] = sc.nextLine().split(" ");
       node root = built(s);

       List<Integer> r = new ArrayList<>();
       // Prints rightView
       rightview(root, r, 0);
       for (int i : r) {
        System.out.print(i + " ");
       }
       sc.close();
       
   } 
}
