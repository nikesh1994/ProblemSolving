package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*

Level order traversal of Binary tree
 */
public class LevelOrder {

    static Node root;

    /*
    Algorithm:
    Step 1 : Store root node in a queue
    Step 2 : loop till queue is not empty
    Step 3 : poll(removes and return the head node)
     from queue , print poll node data and add left and
     right child of removed node to queue
     */
    public static void levelOrderTraversal(Node node) {

        if(node == null) {
            return ;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
    }

    public static void main(String []args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        levelOrderTraversal(root);
    }
}
