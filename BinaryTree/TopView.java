package BinaryTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

    static class Node {
        int data;
        int hd;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            left=right=null;
            hd=Integer.MIN_VALUE;
        }
    }

    static Node root;

    /*
    Algorithm:
    Step 1 : Idea is to store the horizontal distance of node
    as key in map, all the key that has been added to map is
    the top view of tree
     */
    public static void topView(Node node) {
        if(node==null)
            return;

        Queue<Node> queue = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        node.hd = 0;
        queue.add(node);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            if(!map.containsKey(temp.hd)) {
                map.put(temp.hd, temp.data);
            }
            if(temp.left!=null) {
                temp.left.hd = temp.hd-1;
                queue.add(temp.left);
            }
            if(temp.right!=null) {
                temp.right.hd = temp.hd+1;
                queue.add(temp.right);
            }
        }
        System.out.println(map.values());
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

        topView(root);
    }
}
