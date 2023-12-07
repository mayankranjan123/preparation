package tree;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int data;

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public TreeNode(int val) {
        this.data = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
