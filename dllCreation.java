/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

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
    
	public static void main(String[] args) {
	Main dll=new Main();
dll.insert(4);
dll.insert(3);
dll.insert(9);
dll.insert(7);
dll.displaydll();
	}
}
