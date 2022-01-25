package BinaryTree;

import java.util.*;

public class ZigZag {

    static Node root;

    public static void zigZagLevel(Node node) {
        if(node==null)
            return;

        List<List> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        boolean flag =true;
        queue.add(node);
        while(!queue.isEmpty()) {
            List<Integer> list1 = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                Node temp = queue.poll();
                list1.add(temp.data);
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            if(flag) {
                list.add(list1);
            } else {
                Collections.reverse(list1);
                list.add(list1);
            }
            flag =!flag;
        }
        System.out.println(list);
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */

        /*
                   1
                 2   3
                4  56  7
                     8
         */

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        zigZagLevel(root);
    }
}
