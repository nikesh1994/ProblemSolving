package LinkedList;

/*
Write a Program to reverse the Linked List. (Both Iterative and recursive)
*/

//1->2->3->4->Null

public class ReverseLL {

    static Node head;

    /*Iterative method to reverse the LinkedList
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public static Node reverseIterative(Node head) {

        Node prev=null;
        Node after=null;
        Node current = head;
        while(current!=null) {
            after=current.next;
            current.next=prev;
            prev=current;
            current=after;
        }
        return prev;
    }

    //A recursive approach to reverse a Linked List, prev is passed
    //as null initially
    public static Node reverseRecursion(Node current, Node prev) {

        if(head==null ) {
            return head;
        }

        //if last node then mark it as head
        if(current.next==null) {
            head=current;
            current.next=prev;
            return head;
        }

        //Store current's next value in a Node
        Node next1 = current.next;
        current.next=prev;
        reverseRecursion(next1,current);
        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String []args) {
        //LinkedList list = new LinkedList();
        head = new Node(1);
        head.next = new Node(20);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next
                = new Node(7);
        head.next.next.next.next.next.next.next
                = new Node(8);

        printList(head);
        Node temp = reverseRecursion(head,null);
        printList(temp);
    }

}
