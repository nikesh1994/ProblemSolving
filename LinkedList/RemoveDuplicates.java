package LinkedList;

//Remove Duplicates in a sorted Linked List.

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    static Node head;

    public static Node removeDuplicatesFromSortedList(Node node) {

        if (node == null) {
            return node;
        }

        //Node newHead = new Node(-1);

        Node start = node;
        Node track = node;
        Node end = null;

        while (start != null) {
            end = start.next;
            if (end!=null && start.data == end.data) {
                while (end != null && start.data == end.data) {
                    end = end.next;
                }
                start.next = end;
            }
            start = start.next;
        }

        return track;
    }

    /* Algo :-
       1->3->4->2->1->2->4

       1. Loop till temp!=null
       2. check in hashset if node exist
          a) if yes , iterate to next node
          b) if No , add the node to a new Linked List and iterate to next node
     */
    public static Node removeDuplicateFromUnsortedList(Node node) {

        if(node==null) {
            return node;
        }

        Node temp =node;
        Set<Integer> set = new HashSet<>();
        Node newHead = new Node(Integer.MIN_VALUE);
        Node tempHead = newHead;

        while(temp !=null) {
            if(!set.contains(temp.data)) {
                set.add(temp.data);
                Node newNode = new Node(temp.data);
                tempHead.next = newNode;
                tempHead = newNode;
            }
            temp = temp.next;

        }

        return newHead.next;
    }

    public static void printList(Node temp1) {
        Node temp = temp1;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(20);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(21);
        head.next.next.next.next.next = new Node(20);
        head.next.next.next.next.next.next
                = new Node(1);
        head.next.next.next.next.next.next.next
                = new Node(21);

        Node temp = removeDuplicateFromUnsortedList(head);

        printList(temp);
    }
}
