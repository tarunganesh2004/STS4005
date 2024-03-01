import java.util.Scanner;
public class Main {

        class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public Node head = null;

        public void insert(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
        
        public static void printList(Main list) { 
        Node currNode = list.head; 
        while (currNode != null) { 
            System.out.print(currNode.data + " "); 
    
            currNode = currNode.next; 
        } 
    } 
        
        public  void seggregate(){
            Node evenStart=null;
            Node evenEnd=null;
            Node oddStart=null;
            Node oddEnd=null;
            Node curr=head;
            
            while(curr!=null){
                if(curr.data%2==0){
                    if(evenStart==null){
                        evenStart=curr;
                        evenEnd=curr;
                    } else{
                        evenEnd.next=curr;
                        evenEnd=curr;
                    }
                }
                else{
                    if(oddStart==null){
                        oddStart=curr;
                        oddEnd=curr;
                    } else{
                        oddEnd.next=curr;
                        oddEnd=curr;
                    }
                }
                curr=curr.next;
            }
            if(evenStart==null){
                head=oddStart;
            } else{
                head=evenStart;
                evenEnd.next=oddStart;
                oddEnd.next=null;
            }
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            Main sll = new Main();
            for (int i = 0; i < n; i++) {
                sll.insert(sc.nextInt());
            }
            // printList(sll);
            sll.seggregate();
            // System.out.println("\n");
            printList(sll);
        }
        
}
