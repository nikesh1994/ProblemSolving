package LinkedList;

/*
  Add “1” to a number represented as a Linked List.
  like: No 1999 represented as 1->9->9->9 , adding 1 to it 1 9 9 9 ->
  will be 2->0->0->0
 */

public class Add1 {

    static Node head;

    public static Node reverse(Node current, Node prev) {

        if(current==null) {
            return current;
        }

        //if current is last node, mark as head
        if(current.next==null) {
            head = current;
            current.next = prev;
            //printList(head);
            return head;
        }

        Node next1 = current.next;
        current.next = prev;
        reverse(next1,current);
        return head;

    }

    /*
    Algorithm :
    1 Consider the LL : 1 9 9 9
    2. Reverse the LL : 9 9 9 1
    3. Add 1 to LL and carry forward any remainder : 0
    4. Add the remainder and repeat above process
    5. Reverse the modified linked list
     */
    public static Node add1s(Node node) {

        Node temp = node;
        temp = reverse(node,null);
        //System.out.println(temp.data+" ");

        int rem = 0;
        Node modifiedTemp = temp;
        while(modifiedTemp!=null){
            int value;
            if(temp==modifiedTemp) {
                value = rem + modifiedTemp.data + 1;
            } else {
                value = rem + modifiedTemp.data;
            }
            if(value==10){
                modifiedTemp.data = value%10;
                rem =1;
            } else {
                modifiedTemp.data = value%10;
                rem =0;
            }
            modifiedTemp = modifiedTemp.next;
        }

        Node finalTemp = reverse(temp,null);
        return finalTemp;
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
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);


        printList(head);
        Node temp = add1s(head);
        printList(temp);
    }
}
