package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

public class CheckCousin {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        System.out.println(new CheckCousin().isCousins(node, 2, 3));
    }

    public boolean isCousins(Node root, int a, int b) {
        // your code here
        // This function should return true if x and y are cousins, else return false
        Map<Integer, Set<Node>> map = new HashMap<>();
        dfs(root, a, 0, map, null);
        dfs(root, b, 0, map, null);
        if (map.size() > 1) {
            return false;
        } else {
            for (Map.Entry<Integer, Set<Node>> entry : map.entrySet()) {
                if (entry.getValue().size() > 1) {
                    return true;
                }
            }
            return false;
        }

    }

    void dfs(Node root, int val, int level, Map<Integer, Set<Node>> map, Node parent) {
        if (root != null) {
            if (root.data == val) {
                if (map.containsKey(level)) {
                    Set<Node> set = map.get(level);
                    set.add(parent);
                    map.put(level, set);
                } else {
                    Set<Node> set = new HashSet<>();
                    set.add(parent);
                    map.put(level, set);
                }
            }
            dfs(root.left, val, level + 1, map, root);
            dfs(root.right, val, level + 1, map, root);
        }
    }

}
