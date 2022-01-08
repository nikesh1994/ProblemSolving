package LinkedList;

import static java.lang.Math.abs;

/*
  Problem : Intersection Point of two Linked Lists. Given a Y shaped Linked List,
  find out the intersection point
 */
public class IntersectionPoint {

    static Node head1;
    static Node head2;

    /*
    Algorithm :
    step1 : find the count of both the link list
    step2 : difference = abs(c1-c2)
    step3 : Iterate through the bigger LL till difference, from down
    there both the Linked List would be same
    step4 : now check the node's address , if matches break else iterate
     */

    public static int count(Node node) {
        Node temp = node;
        int count =0;
        while(temp!=null) {
            count++;
            temp=temp.next;
        }
        return count;
    }

    public static boolean intersectionPoint(Node node1, Node node2) {

        if(node1==null || node2==null) {
            return false;
        }

        int count1 = count(node1);
        int count2 = count(node2);

        int diff = abs(count1-count2);
        while(diff>0) {
            if(count1>count2) {
                node1 = node1.next;
            } else {
                node2 = node2.next;
            }
            diff--;
        }

        while(node1!=null && node2!=null) {
            if(node1.next==node2.next){
                return true;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return false;
    }

    public static void main(String[] args)
    {
        //LinkedList list = new LinkedList();

        // creating first linked list
        head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(30);

        // creating second linked list
        head2 = new Node(10);
        head2.next = new Node(15);
        head2.next.next = new Node(30);

        System.out.println("The node of intersection is " + intersectionPoint(head1,head2));
    }
}

