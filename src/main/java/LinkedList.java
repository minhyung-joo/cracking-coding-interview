public class LinkedList {
    private Node root;

    private class Node {
        public Node next;
        public int data;
    }

    public void append(int data) {
        Node newNode = new Node();
        newNode.data = data;

        if (root == null) {
            root = newNode;
        } else {
            newNode.next = root;
            root = newNode;
        }
    }

    public void reverse() {
        if (root == null) {
            return;
        }

        Node pointer = root;
        Node aheadPointer = pointer.next;
        pointer.next = null;
        while (aheadPointer != null) {
            Node nextAheadPointer = aheadPointer.next;
            aheadPointer.next = pointer;
            pointer = aheadPointer;
            aheadPointer = nextAheadPointer;
        }

        root = pointer;
    }

    public void print() {
        Node pointer = root;
        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }

        System.out.println();
    }
}
