import java.util.Scanner;
public class mergeSortUsingDLL
{
    static Node head=null;
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int d){
            data=d;
            next=prev=null;
        }
    }
    static void insert(int n){
        Node newNode=new Node(n);
        if(head==null){
            head=newNode;
        }
        else{
            Node cur=head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=newNode;
            newNode.prev=cur;
        }
    }
    
    static void display(){
        Node cur=head;
        while(cur!=null){
            System.out.print(cur.data+"<--->");
            cur=cur.next;
        }
        System.out.print("null");
    }
    
    static Node sort(Node first){
        if(first==null||first.next==null){
            return first;
        }
        Node second=split(first);
        first=sort(first);
        second=sort(second);
        
        return merge(first,second);
    }
    static Node split(Node first){
        Node fast=first;
        Node slow=first;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        Node temp=slow.next;
        slow.next=null;
        return temp;
    }
    static Node merge(Node first,Node second){
        if(first==null)  return second;
        if(second==null)  return first;
        
        if(first.data<=second.data){
            first.next=merge(first.next,second);
            first.next.prev=first;
            first.prev=null;
            return first;
        } else{
            second.next=merge(first,second.next);
            second.next.prev=second;
            second.prev=null;
            return second;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            insert(sc.nextInt());
        }
        display();
        head=sort(head);
        System.out.println();
        display();
    }
}
