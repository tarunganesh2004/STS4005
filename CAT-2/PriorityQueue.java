import java.util.Scanner;
class node{
    int data;
    int pr;
    node next;
    node prev;
    
    node(int n,int pri){
        data=n;
        pr=pri;
        next=null;
        prev=null;
    }
}
public class PriorityQueue
{
    static node front=null;
    static node rear=null;
    public static void insert(int n,int pri){
        node newNode=new node(n,pri);
        if(front==null){
            front=newNode;
            rear=newNode;
        }
        else{
            if(pri<front.pr){
                newNode.next=front;
                front.prev=newNode;
                front=newNode;
            }
            else{
                node cur=front;
                while(cur.next!=null&&cur.next.pr<pri){
                    cur=cur.next;
                }
                if(cur.next==null){
                    cur.next=newNode;
                    newNode.prev=cur;
                    rear=newNode;
                }
                else{
                    newNode.next=cur.next;
                    newNode.prev=cur;
                    cur.next.prev=newNode;
                    cur.next=newNode;
                }
            }
        }
    }
    public static void display(){
        node cur=front;
        while(cur!=null){
            System.out.println(cur.data+" "+cur.pr);
            cur=cur.next;
        }
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
		    int c=sc.nextInt();
		    int d=sc.nextInt();
		    insert(c,d);
		}
		System.out.println("The Priority Queue is: ");
		display();
	}
}