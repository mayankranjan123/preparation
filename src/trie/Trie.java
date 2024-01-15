package trie;

import java.util.HashMap;
import java.util.Map;

class Trie {
    Node root;

    class Node {
        Map<Character, Node> children;
        boolean isEnd;

        public Node() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }

        public boolean contains(char ch) {
            return !this.children.isEmpty() && this.children.containsKey(ch);
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public Node get(char ch) {
            return this.children.get(ch);
        }

        public void put(char ch, Node node) {
            this.children.put(ch, node);
        }
    }


    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            if (node.contains(ch)) {
                node = node.get(ch);
            } else {
                node.put(ch, new Node());
                node = node.get(ch);
            }
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;

        for (char ch : word.toCharArray()) {
            if (!node.contains(ch)) {
                return false;
            } else {
                node = node.get(ch);
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = root;

        for (char ch : prefix.toCharArray()) {
            if (!node.contains(ch)) {
                return false;
            } else {
                node = node.get(ch);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");

        System.out.println(trie.search("apple"));
    }
}
