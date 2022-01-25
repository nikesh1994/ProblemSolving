package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
TC : O(n), where n is the number of nodes in the binary tree
 */
public class LeftView {

    static Node root;

    public static void leftView(Node node) {
        if(node==null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i=0;i<n;i++) {
                Node temp = queue.poll();
                if(i==0)
                    System.out.print(temp.data+" ");
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
        }
        System.out.println();
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */

        root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(8);
        root.right.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right.left = new Node(14);



        leftView(root);
    }
}
