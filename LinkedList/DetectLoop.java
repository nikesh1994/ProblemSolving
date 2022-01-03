package LinkedList;

/* Write a program to detect a loop in LinkedList*/
public class DetectLoop {

    static Node head;

    //Using Floyd-Warshall (Rabbit-Tortoise Algorith)
    //Step - 1 : slow=fast=head;
    //step - 2 : loop (fast!=null && fast.next!=null)
    //step -3 : slow=slow.next and fast=fast.next.next
    //step -4 : check if slow==fast, then break(loop detected)
    //Remove the loop
    //step -5 : set fast=head;
    //srep-6 : Move slow and fast one node till(slow.next !=fast.next)
    //step:6 : Make slow.next as null

    //Point is : At the meeting post, if we move one of the pointer to head
    //and start iterating one node they meet at the start of the loop
    //at the same time(Floyd warshall algo)

    public static boolean detectRemoveLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null &&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                removeLoop(slow,head);
                return true;
            }
        }
        return false;
    }

    public static void removeLoop(Node slow, Node head) {
        Node temp = head;
        while(slow.next!=temp.next) {
            slow=slow.next;
            temp=temp.next;
        }
        slow.next=null;
    }

    static void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String []args) {
        head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        head.next.next.next.next.next = head.next.next;

        System.out.println(detectRemoveLoop(head));
        System.out.println("Linked List after removing loop : ");
        printList(head);
    }

}
