package tree;

import java.util.Scanner;

public class BST {
    TreeNode root;

    public static void main(String[] args) {
        BST BST = new BST();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("1.  Insert Element in BST");
            System.out.println("2.  View elements InOrder");
            System.out.println("3.  View elements PreOrder");
            System.out.println("4.  View elements PostOrder");
            System.out.println("5.  Find element in BST");
            System.out.println("6.  Delete element in BST");
            System.out.println("7.  Inorder Successor in BST");
            System.out.println("8. No. of BST Possible");
            System.out.println("9. BFS(level order traversal)");
            System.out.println("10. Diameter of a binary tree");
            System.out.println("11. Height of a binary tree");
            System.out.println("12. Find Leaf Nodes");
            System.out.println("13. Check Sum tree");
            System.out.println("14. Add Tree");
            System.out.println("15: K Distance from root");
            System.out.println("16: Lowest Common Ancestor");
            System.out.println("17: Print K Leaves Nodes");
            System.out.println("18: Max Element in Tree");
            System.out.println("Enter your choice");
            int n = sc.nextInt();

            switch (n) {
                case (1):
                    System.out.println("Enter element");
                    BST.root = BST.insert(BST.root, sc.nextInt());
                    break;
                case (2):
                    if (BST.root == null) {
                        System.out.println("No elements");
                    } else {
                        BST.inorder(BST.root);
                    }
                    break;
                case (3):
                    if (BST.root == null) {
                        System.out.println("No elements");
                    } else {
                        BST.preorder(BST.root);
                    }
                    break;
                case (4):
                    if (BST.root == null) {
                        System.out.println("No elements");
                    } else {
                        BST.postorder(BST.root);
                    }
                    break;
                case (5):
                    if (BST.root == null) {
                        System.out.println("No elements");
                    } else {
                        System.out.println("Element Found:" + BST.find(BST.root, sc.nextInt()));
                    }
                    break;
                case (6):
                    if (BST.root == null) {
                        System.out.println("No elements");
                    } else {
                       BST.root = BST.deleteFromBST(BST.root, sc.nextInt());
                    }
                    break;
                case (18):
                    if (BST.root == null) {
                        System.out.println("No elements");
                    } else {
                        System.out.println("Max: " + BST.findMax(BST.root).data);
                    }
                    break;
            }
        }
    }

    private TreeNode deleteFromBST(TreeNode root, int item) {
        if (!find(root, item)) {
            System.out.println("Element Not Found");
            return root;
        } else {
            return delete(root, item);
        }
    }

    private TreeNode delete(TreeNode root, int item) {
        if (root == null) {
            return root;
        }
        if (root.data > item) {
            root.left = delete(root.left, item);
        } else if (root.data < item) {
            root.right = delete(root.right, item);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
                if (root.left != null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            } else {
                TreeNode max = findMax(root.left);
                root.data = max.data;
                root.left = delete(root.left, max.data);
            }
        }
        return root;
    }

    private TreeNode findMax(TreeNode root) {
        if (root == null) {
            return null;
        } else if (root.right != null) {
            return findMax(root.right);
        } else {
            return root;
        }
    }

    private boolean find(TreeNode root, int item) {
        if (root == null) {
            return false;
        } else if (root.data == item) {
            return true;
        } else if (root.data > item) {
            return find(root.left, item);
        } else if (root.data < item) {
            return find(root.right, item);
        }
        return false;
    }

    private void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data + " ");
        }
    }

    private void preorder(TreeNode root) {
        if (root != null) {
            System.out.println(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else {
            if (root.data > val) {
                root.left = insert(root.left, val);
            } else {
                root.right = insert(root.right, val);
            }
        }
        return root;
    }
}
