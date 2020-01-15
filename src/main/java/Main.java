import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;

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

        binaryTree.reverse().print();

        NewtonMethod nm = new NewtonMethod();
        System.out.println(nm.squareRoot(10000));

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.printf("Length of LCS between %s and %s is %d\n", s1, s2, LongestCommonSubsequence.longestCommonSubsequence(s1, s2));

        int[] arr = { 7, 5, 8, 2, 3, 1, 9, 12 };
        int[] arr2 = { 3, 3, 3, 2, 2, 5, 5 };
        int[] arr3 = Arrays.copyOf(arr, arr.length);
        int[] arr4 = Arrays.copyOf(arr2, arr2.length);
        Sort.quicksort(arr);
        Sort.quicksort(arr2);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();

        Sort.mergesort(arr3);
        for (int i : arr3) {
            System.out.print(i + " ");
        }
        System.out.println();

        Sort.mergesort(arr4);
        for (int i : arr4) {
            System.out.print(i + " ");
        }
        System.out.println();

        String str = "ABC ABCDAB ABCDABCDABDE";
        String pattern = "ABCDABD";
        System.out.println(Search.kmp(str, pattern));
        System.out.println(Search.rabinKarp(str, pattern));

        int[] values = { 60, 100, 120 };
        int[] weights = { 10, 20, 30 };
        System.out.println(Knapsack.knapsackRecursive(50, weights, values, values.length));
        System.out.println(Knapsack.knapsack(50, weights, values));
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
