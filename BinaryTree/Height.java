package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a binary tree, find height of it.
 Height of empty tree is -1, height of tree
  with one node is 0 and height of  tree is distance between root to node.
 */
public class Height {

    static Node root;

    public static int height(Node node) {
        int count = -1;
        if(node==null)
            return count;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i=0;i<n;i++) {
                Node temp = queue.poll();
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            count++;
        }
        return count;
    }

    public static void main(String []args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.left.left = new Node(10);

        System.out.println(height(root));
    }
}
