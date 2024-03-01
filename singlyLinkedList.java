    import java.util.Scanner;
    public class singlyLinkedList {

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
        
        public boolean createCycle(int a, int b) {
            int c = 0;
            Node p1 = head, p2 = head;
            while (p1.data != a || c != b) {
                if (p1.data != a) {
                    p1 = p1.next;
                    if (p1.next == null) {
                        return false;
                    }
                }
                if (c != b) {
                    p2 = p2.next;
                    ++c;
                }
            }
            p2.next = p1;
            return true;
        }

        public boolean detectCycle() {
            Node fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }
            if (fast.next == null) {
                return false;
            }
            return false;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            singlyLinkedList sll = new singlyLinkedList();
            for (int i = 0; i < n; i++) {
                sll.insert(sc.nextInt());
            }
            int a = sc.nextInt();
            int b = n - 1;
            sll.createCycle(a, b);
            // if (sll.createCycle(a, b)) {
            //     System.out.println("Cycle created");
            // } else {
            //     System.out.println("Cycle not created");
            // }
            if (sll.detectCycle()) {
                System.out.println("Cycle detected");
            } else {
                System.out.println("Cycle not detected");
            }
            sc.close();
        }
    }
