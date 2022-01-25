package BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Mirror {

    static Node root;

    public static void mirrorTree(Node node) {
        if(node==null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            //System.out.print(temp.data+" ");
            Node swap = temp.left;
            temp.left = temp.right;
            temp.right = swap;
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
    }

    public static void inorder(Node node) {
        if(node==null)
            return;
        inorder(node.left);
        System.out.print(node.data+ " ");
        inorder(node.right);
    }

    public static void main(String []args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.left.left = new Node(10);

        inorder(root);
        mirrorTree(root);
        System.out.println();
        inorder(root);
    }
}
