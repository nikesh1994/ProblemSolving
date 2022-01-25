package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
TC : O(n), where n is the number of nodes in the binary tree.
 */
public class RightView {

    static Node root;

    public static void rightView(Node node) {

        if(node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i=0;i<n;i++) {
                Node temp = queue.poll();
                if(i==0)
                    System.out.print(temp.data+" ");

                if(temp.right!=null)
                    queue.add(temp.right);
                if(temp.left!=null)
                    queue.add(temp.left);
            }
        }
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */

        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        rightView(root);
    }
}
