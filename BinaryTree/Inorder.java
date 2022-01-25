package BinaryTree;

import java.util.Stack;

public class Inorder {

    static Node root;

    /*
    Algorithm: (L->R->Right) DFS
    Step 1 : Initialize stack , assign current = node
    Step 2 : Loop , till current !=null || !stack.empty()
    Step 3 : Push left nodes to stack, till node.left becomes null
    Step 4 : Pop the node from stack and print it and assign current = popped node.right
     */
    public static void inorder(Node node) {
        if(node==null)
            return;

        Stack<Node> stack = new Stack<>();
        Node current = node;
        while(current!=null || !stack.empty()) {

            while(current!=null){
                stack.push(current);
                current = current.left;
            }

            Node temp = stack.pop();
            System.out.print(temp.data+" ");
            current = temp.right;
        }
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
    }
}
