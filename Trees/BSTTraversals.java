import java.util.Scanner;

class node {
    int data;
    node left;
    node right;

    node(int d) {
        data = d;
        left = null;
        right = null;
    }
    
}

public class BSTTraversals {
    public static node insert(node root, int data) {
        if (root == null) {
            return new node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);

        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }
    
    public static void inorder(node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }

    public static void preorder(node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(node root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String[] s = sc.nextLine().split(" ");
       node root = null;
       for (String i : s) {
           int data = Integer.parseInt(i);
           root = insert(root, data);
       }
       sc.close();
       System.out.println("Inorder Traversal: ");
       inorder(root);
       System.out.println("\nPreorder Traversal: ");
       preorder(root);
       System.out.println("\nPostorder Traversal: ");
         postorder(root);
   } 
}
