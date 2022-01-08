package LinkedList;

/*
Add two numbers represented by linked lists.

 */
public class AddNumbers {

    /*
    Algorithm :
    1. reverse both the linked list
    2. Iterate through link list and add the node
    3. Add the carry forward to the next node
    4. Reverse the link list
     */

    static Node head1;
    static Node head2;

    public static Node reverse(Node head) {

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


    public static void addNumbers(Node node1, Node node2) {

        Node temp1 = reverse(node1);
        Node temp2 = reverse(node2);

        Node newNode = new Node(Integer.MIN_VALUE);
        Node temp = newNode;
        int quotient = 0;

        while(temp1!=null && temp2!=null) {
            int value = temp1.data+ temp2.data;

            int remainder = value%10;
            Node tempNode = new Node(quotient+remainder);
            temp.next = tempNode;
            temp = tempNode;
            quotient = value/10;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp1!=null) {
            Node tempNode = new Node(quotient+ temp1.data);
            temp.next = tempNode;
            temp = tempNode;
        }
        while(temp2!=null) {
            Node tempNode = new Node(quotient+ temp2.data);
            temp.next = tempNode;
            temp = tempNode;
        }

        Node finalTemp = reverse(newNode.next);

        while(finalTemp!=null) {
            System.out.print(finalTemp.data+" ");
            finalTemp = finalTemp.next;
        }
        System.out.println();

        //return node;
    }

    public static void main(String []args) {
        //LinkedList list = new LinkedList();
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(1);

        addNumbers(head1,head2);


    }
}
