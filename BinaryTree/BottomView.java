package BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

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
    -- Keeping all the hd's in map , since it will override the already
    existing hd of node, is the Bottom view
     */
    public static void bottomView(Node node) {

        if(node==null)
            return;

        Queue<Node> queue = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        node.hd = 0;
        queue.add(node);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            map.put(temp.hd, temp.data);
            if(temp.left!=null){
                temp.left.hd = temp.hd-1;
                queue.add(temp.left);
            }
            if(temp.right!=null){
                temp.right.hd = temp.hd+1;
                queue.add(temp.right);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            System.out.print(entry.getValue()+" ");
        }
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

        bottomView(root);
    }
}
