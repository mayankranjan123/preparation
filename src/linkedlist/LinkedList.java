package linkedlist;

import java.util.Scanner;

public class LinkedList {
    Node start;
    int size;

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LinkedList() {
        this.size = 0;
        this.start = null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        while (true) {
            System.out.println("Enter your choice: ");
            System.out.println("1. Insert element at beginning");
            System.out.println("2. Insert element at last");
            System.out.println("3. Insert element at position");
            System.out.println("4. Delete first element");
            System.out.println("5. Delete last element");
            System.out.println("6. Delete from position");
            System.out.println("7. View Elements");
            System.out.println("8. Is LinkedList empty");
            System.out.println("9. No. of elements");
            System.out.println("10. Sort linked list");
            System.out.println("11. Rotate linked list");
            System.out.println("12. Reverse linked list");
            System.out.println("13. Remove duplicates in linked list");
            System.out.println("14. Reverse linked list using recursion");
            System.out.println("15. Is Palindrome");

            int n = sc.nextInt();
            switch (n) {
                case (1):
                    System.out.println("Enter an element");
                    list.insertAtBeginning(sc.nextInt());
                    break;
                case (2):
                    System.out.println("Enter an element");
                    list.insertAtLast(sc.nextInt());
                    break;
                case (3):
                    System.out.println("Enter element position and value");
                    list.insertAtPosition(sc.nextInt(), sc.nextInt());
                    break;
                case (4):
                    list.deleteFirstElement();
                    break;
                case (5):
                    list.deleteLastElement();
                    break;
                case (6):
                    list.deleteAtPosition(sc.nextInt());
                    break;
                case (7):
                    list.display();
                    break;
                case (8):
                    System.out.println("Is Empty: " + list.isEmpty());
                    break;
                case (9):
                    System.out.println("No. Of Elements: " + list.getSize());
                    break;
                case (10):
                    list.mergeSort(list.start);
                    break;
                case (15):
                    list.isPalindrome(list.start);
                    break;
            }
        }
    }

    private Node mergeSort(Node start) {
        if (start == null || start.next == null) {
            return start;
        }
        Node mid = middleNode(start);
        Node nextStart = mid.next;
        mid.next = null;

        Node left = mergeSort(start);
        Node right = mergeSort(nextStart);

        return merge(left, right);
    }

    public Node middleNode(Node start) {
        Node fast = start.next, slow = start;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node merge(Node l1, Node l2) {
        Node dh = new Node(0);
        Node cur = dh;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return dh.next;
    }

    private void display() {
        if (isEmpty()) {
            System.out.println("No Elements Present");
            return;
        }

        Node temp = start;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void deleteAtPosition(int position) {
        if (isEmpty()) {
            System.out.println("No Elements Present");
            return;
        }

        if (position == 0) {
            deleteFirstElement();
        } else if (position == size) {
            deleteLastElement();
        } else {
            Node prev = start, temp = start;
            int index = 0;

            while (temp.next != null && index != position - 1) {
                prev = temp;
                temp = temp.next;
                index += 1;
            }
            prev.next = temp.next;
        }
        size -= 1;
    }

    private void deleteLastElement() {
        if (!isEmpty()) {
            if (size == 1) {
                deleteFirstElement();
            }

            Node temp = start;
            while (temp.next != null && temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            size -= 1;
        }
    }

    private void deleteFirstElement() {
        if (!isEmpty()) {
            start = start.next;
            size -= 1;
        }
    }

    private void insertAtPosition(int index, int num) {
        if (index > size + 1) {
            return;
        }

        Node node = new Node();
        node.data = num;
        if (index == 0 || isEmpty()) {
            insertAtBeginning(num);
        }
        if (index == size + 1) {
            insertAtLast(num);
        }

        Node temp = start, prev = start;
        int pos = 0;

        while (temp.next != null && pos != index) {
            prev = temp;
            temp = temp.next;
            pos += 1;
        }

        node.next = temp;
        prev.next = node;

        size += 1;
    }

    private void insertAtLast(int num) {
        Node node = new Node();
        node.data = num;

        if (isEmpty()) {
            start = node;
        } else {
            Node temp = start;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size += 1;
    }

    private void insertAtBeginning(int num) {
        Node node = new Node();
        node.data = num;

        if (!isEmpty()) {
            node.next = start;
        }

        start = node;
        size += 1;
    }

    private boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    public boolean isPalindrome(Node head) {
        Node temp = head;
        Node nh = reverseList(temp);
        while (temp != null && nh != null) {
            if (temp.data != nh.data) {
                return false;
            }
            temp = temp.next; 
            nh = nh.next;
        }
        if ((head == null && nh != null) || (head != null && nh == null)) {
            return false;
        }
        return true;
    }

    public Node reverseList(Node head) {
        Node curr = head, prev = null, next = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }
}

