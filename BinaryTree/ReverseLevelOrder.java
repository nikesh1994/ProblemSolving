package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
The idea is to print the last level first, then the second last level,
 and so on. Like Level order traversal, every level is printed from left to right.
 */
public class ReverseLevelOrder {

    static Node root;

    /*
    Algorithm :
    Step 1 : The idea is to use a queue and stack
    queue to add the nodes while doing level traversal ,
    We need to add right element first to queue, so that
    while pushing to stack, left element is processed first
     */
    public static void reverseLevel(Node node) {
        if(node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            stack.push(temp.data);
            if(temp.right!=null)
                queue.add(temp.right);
            if(temp.left!=null)
                queue.add(temp.left);
        }
        while(!stack.empty()) {
            System.out.print(stack.pop()+" ");
        }
    }

    public static void main(String args[])
    {

        // Let us create trees shown in above diagram
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Level Order traversal of binary tree is : ");
        reverseLevel(root);
    }
}
