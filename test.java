import java.util.Scanner;

public class Main
{
    
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int n){
            data=n;
            next=null;
            prev=null;
        }
    }
    Node head=null;
    
    public void insert(int n){
        Node newNode=new Node(n);
        if(head==null){
            head=newNode;
        } else{
            Node curr=head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=newNode;
            newNode.prev=curr;
        }
    }
    
    public void displaydll(){
         Node current = head;  
        if(head == null) {   
            return;  
        }  
        while(current != null) {  
            System.out.print(current.data + " ");  
            current = current.next;  
        }  
    }  

    public void bitonic(){
        Node first = head;
        Node last = head;
        Node res = null;
        Node resend = null;
    
        while (last.next != null) {
            last = last.next;
        }
    
        while (first != null && first != last) {
            if (first.data < last.data) {
                if (res == null) {
                    res = resend = first;
                } else {
                    Node cur = first;
                    first = first.next;
                    cur.next = null;
                    cur.prev = null;
    
                    resend.next = cur;
                    cur.prev = resend;
                    resend = resend.next;
                }
            } else {
                if (res == null) {
                    res = resend = last;
                } else {
                    Node cur = last.prev;
                    last = cur;
                    cur.next = null;
                    cur.prev = null;
    
                    resend.next = cur;
                    cur.prev = resend;
                    resend = resend.next;
                }
            }
        }
    
        if (first != null) {
            resend.next = first;
            first.prev = resend;
        }
    
        head = res;
    }
    
    
	public static void main(String[] args) {
	Main dll=new Main();
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    for(int i=0;i<n;i++){
        int x=sc.nextInt();
        dll.insert(x);
    }
dll.displaydll();
System.out.println("\n");
dll.bitonic();
dll.displaydll();
	}
}