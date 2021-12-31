package LinkedList;
/*Reverse a Linked List in groups of given size.
        Given a linked list of size N. The task is to reverse every k nodes
        (where k is an input to the function) in the linked list. If the number
        of nodes is not a multiple of k then left-out nodes, in the end, should
        be considered as a group and must be reversed
        Input:
        LinkedList: 1->2->2->4->5->6->7->8
        K = 4
        Output: 4 2 2 1 8 7 6 5

        LinkedList: 1->2->3->4->5
        K = 3
        Output: 3 2 1 5 4*/

import java.util.Stack;

public class ReverseGroupLL {

    static Node head;

    //Logic is push upto the count of k in stack
    //and pop it and make a LL using the popped node
    public static Node reverseUsingStack(int k) {
        Node current = head;
        Node head1 = null;
        int i=0;
        int track=0;
        Stack<Node> stack = new Stack<>();
        Node temp = null;
        while(current != null && i<k) {
            stack.push(current);
            i++;
            current = current.next;
            if(current ==null || i==k) {
                while(!stack.empty()){
                    Node pop= stack.pop();
                    pop.next=null;
                    if(track==0) {
                        head1 = pop;
                        temp = pop;
                        track++;
                    } else {
                        temp.next = pop;
                        temp = temp.next;
                    }
                }
                i=0;
            }
        }
        return head1;
    }

    /*Complexity Analysis:

    Time Complexity: O(n).
    Traversal of list is done only once and it has ‘n’ elements.
    Auxiliary Space: O(n/k).
    For each Linked List of size n, n/k or (n/k)+1 calls will be made during the recursion.*/
    //using recursion
    public static Node reverseUsingRecursion(Node head, int k) {

        Node current = head;
        Node prev = null;
        Node next = null;
        int count =0;

        while(count <k && current!=null) {
            next = current.next;
            current.next=prev;
            prev=current;
            current=next;
            count++;
        }
         /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if(next !=null){
            head.next = reverseUsingRecursion(next,k);
        }
        return prev;
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
        Node temp = reverseUsingRecursion(head,4);
        //System.out.println(temp.data);
        printList(temp);
    }
}
