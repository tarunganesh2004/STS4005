import java.util.*;
class node{
    int data;
    node left;
    node right;
    node(int n){
        data=n;
        left=null;
        right=null;
    }
}
public class boundaryView
{
    static node built(String[] s){
        if(s.length==0||s[0].equals("N")){
            return null;
        }
        node root=new node(Integer.parseInt(s[0]));
        Queue<node> q=new LinkedList<>(); // for level order insertion we use Queue
        q.add(root);
        int i=1;
        while(!q.isEmpty()&& i<s.length){
            node cur=q.poll(); // 1
            String cval=s[i]; // 2
            if(!cval.equals("N")){
                cur.left=new node(Integer.parseInt(cval));
                q.add(cur.left);
            }
            i++;
            if(i>=s.length)  break;
            cval=s[i]; // 3
            if(!cval.equals("N")){
                cur.right=new node(Integer.parseInt(cval));
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }
    
    
    static void pb(node root){
        if(root== null) return;
        System.out.print(root.data+" ");
        lb(root.left);
        leaf(root.left); // left subtree
        leaf(root.right); // right subtree
        rb(root.right);
    }
    
    static void lb(node root){
        if(root==null) return;
        if(root.left!=null){
            System.out.print(root.data+" ");
            lb(root.left);
        }
        else if(root.right!=null){
            System.out.print(root.data+" ");
            lb(root.right);
        }
    }
    static void rb(node root){
        if(root==null) return;
        if(root.right!=null){
            System.out.print(root.data+" ");
            rb(root.right);
        }
        else if(root.left!=null){
            System.out.print(root.data+" ");
            rb(root.left);
        }
    }
    
    static void leaf(node root){
        if(root==null) return;
        leaf(root.left);
        if(root.left==null&&root.right==null){
            System.out.print(root.data+" ");
        }
        leaf(root.right);
    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    String[] s=sc.nextLine().split(" ");
	    node root=built(s);
	    pb(root); // print Boundary
	    
	} 
}