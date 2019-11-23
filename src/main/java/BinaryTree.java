class Node {
    Node left;
    Node right;
    int data;
}

public class BinaryTree {
    private Node root;

    public BinaryTree() {}

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void insert(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (root == null) {
            root = newNode;
        } else {
            Node pointer = root;
            while (pointer != null) {
                if (newNode.data > pointer.data) {
                    if (pointer.right == null) {
                        pointer.right = newNode;
                        pointer = null;
                    } else {
                        pointer = pointer.right;
                    }
                } else {
                    if (pointer.left == null) {
                        pointer.left = newNode;
                        pointer = null;
                    } else {
                        pointer = pointer.left;
                    }
                }
            }
        }
    }

    public int getHeight() {
        return getHeight(root, 0);
    }

    private int getHeight(Node node, int currentHeight) {
        if (node == null) {
            return currentHeight;
        } else {
            return Math.max(
                    getHeight(node.left, currentHeight + 1),
                    getHeight(node.right, currentHeight + 1)
            );
        }
    }

    public void print() {
        printBitmap(getBitmap(root));
    }

    private char[][] getBitmap(Node node) {
        if (node == null) {
            return null;
        }

        char[] dataChars = Integer.toString(node.data).toCharArray();
        char[][] leftBitmap = getBitmap(node.left);
        char[][] rightBitmap = getBitmap(node.right);
        if (leftBitmap == null && rightBitmap == null) {
            char[][] bitmap = new char[1][dataChars.length];
            for (int i = 0; i < dataChars.length; i++) {
                bitmap[0][i] = dataChars[i];
            }

            return bitmap;
        } else {
            int leftHeight = 0;
            int leftWidth = 0;
            int rightHeight = 0;
            int rightWidth = 0;
            if (leftBitmap != null) {
                leftHeight = leftBitmap.length;
                leftWidth = leftBitmap[0].length;
            }

            if (rightBitmap != null) {
                rightHeight = rightBitmap.length;
                rightWidth = rightBitmap[0].length;
            }

            int offset = dataChars.length;
            int width = leftWidth + rightWidth + offset;
            int height = Math.max(leftHeight, rightHeight) + 1;
            char[][] bitmap = new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    bitmap[i][j] = ' ';
                }
            }

            if (leftBitmap != null) {
                for (int i = 0; i < leftBitmap.length; i++) {
                    for (int j = 0; j < leftBitmap[0].length; j++) {
                        bitmap[i + 1][j] = leftBitmap[i][j];
                    }
                }
            }

            if (rightBitmap != null) {
                for (int i = 0; i < rightBitmap.length; i++) {
                    for (int j = 0; j < rightBitmap[0].length; j++) {
                        bitmap[i + 1][j + leftWidth + offset] = rightBitmap[i][j];
                    }
                }
            }

            for (int i = leftWidth; i < leftWidth + offset; i++) {
                bitmap[0][i] = dataChars[i - leftWidth];
            }

            return bitmap;
        }
    }

    private void printBitmap(char[][] bitmap) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bitmap.length; i++) {
            for (int j = 0; j < bitmap[0].length; j++) {
                sb.append(bitmap[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }

    public BinaryTree reverse() {
        Node newRoot = new Node();
        newRoot.data = root.data;
        newRoot.left = reverse(root.right);
        newRoot.right = reverse(root.left);
        return new BinaryTree(newRoot);
    }

    public Node reverse(Node node) {
        if (node == null) {
            return null;
        }

        Node newNode = new Node();
        newNode.data = node.data;
        newNode.left = reverse(node.right);
        newNode.right = reverse(node.left);
        return newNode;
    }
}
