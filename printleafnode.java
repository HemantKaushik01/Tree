package treecons;


import java.util.*;

public class printleafnode {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        printleafnode m = new printleafnode();
        BinaryTree bt = m.new BinaryTree();
        bt.printLeafNodes();
    }

    private class BinaryTree {
        private class Node {
            int data;
            Node left;
            Node right;
        }

        private Node root;
        private int size;

        public BinaryTree() {
            this.root = this.takeInput();
        }

        public Node takeInput() {
            Queue<Node> queue = new LinkedList<>();
            int rootData = scn.nextInt();
            if (rootData == -1) {
                return null;
            }

            Node root = new Node();
            root.data = rootData;
            queue.add(root);

            while (!queue.isEmpty()) {
                Node current = queue.poll();

                int leftData = scn.nextInt();
                if (leftData != -1) {
                    Node left = new Node();
                    left.data = leftData;
                    current.left = left;
                    queue.add(left);
                }

                int rightData = scn.nextInt();
                if (rightData != -1) {
                    Node right = new Node();
                    right.data = rightData;
                    current.right = right;
                    queue.add(right);
                }
            }

            return root;
        }

        public void printLeafNodes() {
            printLeafNodes(this.root);
        }

        private void printLeafNodes(Node node) {
            if (node == null) {
                return;
            }

            if (node.left == null && node.right == null) {
                System.out.print(node.data + " ");
                return;
            }

            printLeafNodes(node.left);
            printLeafNodes(node.right);
        }
    }
}
