package tree;

import java.util.Scanner;

public class BinaryTree {
    TreeNode root;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("1.  Insert Element in Binary Tree");
            System.out.println("2.  View elements InOrder");
            System.out.println("2.  Is Sum Tree");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    binaryTree.root = binaryTree.populateElements(binaryTree.root, sc);
                break;
                case 2:
                    binaryTree.inorder(binaryTree.root);
                break;
                case 3:
                    System.out.println(binaryTree.isSumTree(binaryTree.root));
                    break;

            }
        }
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    private TreeNode populateElements(TreeNode root, Scanner sc) {
        System.out.println("Enter element");
        int val = sc.nextInt();
        TreeNode node = new TreeNode(val);
        if (root == null) {
            root = node;
        }

        System.out.println("Do you want to enter left of: " + val);
        Boolean ans = sc.nextBoolean();

        if (ans) {
            root.left = populateElements(root.left, sc);
        }

        System.out.println("Do you want to enter right of: " + val);
        ans = sc.nextBoolean();

        if (ans) {
            root.right = populateElements(root.right, sc);
        }

        return root;

    }

    boolean isSumTree(TreeNode root)
    {
        // Your code here
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int left = add(root.left);
        int right = add(root.right);

        if (root.data == (left + right) && isSumTree(root.left) && isSumTree(root.right)) {
            return true;
        }
        return false;

    }

    int add(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = add(root.left);
        int right = add(root.right);
        return root.data + left + right;
    }
}
