public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 },
                { 21, 22, 23, 24, 25 }
        };
        int[][] evenMatrix = {
                { 1, 2, 3, 4 },
                { 6, 7, 8, 9 },
                { 11, 12, 13, 14 },
                { 16, 17, 18, 19 }
        };

        rotateSquareMatrix90(matrix);
        rotateSquareMatrix90(evenMatrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < evenMatrix.length; i++) {
            for (int j = 0; j < evenMatrix.length; j++) {
                System.out.print(evenMatrix[i][j] + " ");
            }
            System.out.println();
        }

        LinkedList linkedList = new LinkedList();
        linkedList.append(3);
        linkedList.append(5);
        linkedList.append(7);
        linkedList.append(9);
        linkedList.print();
        linkedList.reverse();
        linkedList.print();

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(15);
        binaryTree.insert(9);
        binaryTree.insert(1);
        binaryTree.insert(12);
        binaryTree.insert(11);
        binaryTree.insert(8);
        binaryTree.print();

        NewtonMethod nm = new NewtonMethod();
        System.out.println(nm.squareRoot(10000));
    }

    public static void rotateSquareMatrix90(int[][] matrix) {
        int n = matrix.length;
        int columnBound = n % 2 == 0 ? n / 2 : n / 2 + 1;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < columnBound; j++) {
                int row = j;
                int column = n - 1 - i;
                int temp = matrix[row][column];
                int newTemp;
                matrix[row][column] = matrix[i][j];
                for (int k = 0; k < 3; k++) {
                    int tempPointer = row;
                    row = column;
                    column = n - 1 - tempPointer;
                    newTemp = matrix[row][column];
                    matrix[row][column] = temp;
                    temp = newTemp;
                }
            }
        }
    }
}
