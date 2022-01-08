package LinkedList;

/*
 Problem Statement :- Intersection of two Sorted Linked List.
   1 -> 2-> 3 -> 4 -> 5 -> 6 -> NULL
   3 -> 4-> 5 -> 7 -> NULL
 */
public class IntersectionList {

    static Node head1;
    static Node head2;

    /* Algorithm :
       step 1 : iterate through both LL
       step 2 : if node1.data < node2.data , move node1
       step 3 : else if move node2
       step 4 : else make a ll with either of node's and move node1 and node
     */

    public static Node intersectionList(Node node1, Node node2) {

        if(node1==null && node2==null) {
            return node1;
        }

        Node newHead = new Node(Integer.MAX_VALUE);
        Node temp = newHead ;

        while(node1 !=null && node2 !=null) {
            if(node1.data < node2.data)
                node1 = node1.next;

            else if(node1.data > node2.data)
                node2 = node2.next;

            else {
                Node newNode = new Node(node1.data);
                temp.next = newNode ;
                temp = newNode;
                node1 = node1.next;
                node2 = node2.next;
            }
        }



        return newHead.next;
    }

    public static void printList(Node node) {
        Node temp =node;
        while(temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String []args) {
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next
                = new Node(7);
        head1.next.next.next.next.next.next.next
                = new Node(8);

        head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(4);
        head2.next.next.next = new Node(5);


        Node temp = intersectionList(head1,head2);
        printList(temp);
    }
}
