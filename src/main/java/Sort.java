import java.util.Arrays;

public class Sort {
    public static void mergesort(int[] arr) {
        mergesort(arr, 0, arr.length - 1);
    }

    private static void mergesort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (end - start) / 2 + start;
        mergesort(arr, start, mid);
        mergesort(arr, mid + 1, end);
        merge(arr, start, mid + 1, end);
    }

    private static void merge(int[] arr, int i, int j, int end) {
        int[] firstHalf = Arrays.copyOfRange(arr, i, j);
        int[] secondHalf = Arrays.copyOfRange(arr, j, end + 1);
        int firstPointer = 0;
        int secondPointer = 0;
        int mainPointer = i;
        while (firstPointer < firstHalf.length && secondPointer < secondHalf.length) {
            if (firstHalf[firstPointer] < secondHalf[secondPointer]) {
                arr[mainPointer] = firstHalf[firstPointer];
                firstPointer++;
            } else {
                arr[mainPointer] = secondHalf[secondPointer];
                secondPointer++;
            }

            mainPointer++;
        }

        // Only one of them will run
        while (firstPointer < firstHalf.length) {
            arr[mainPointer] = firstHalf[firstPointer];
            firstPointer++;
            mainPointer++;
        }

        while (secondPointer < secondHalf.length) {
            arr[mainPointer] = secondHalf[secondPointer];
            secondPointer++;
            mainPointer++;
        }
    }

    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private static void quicksort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = arr[end];
        int i = start, j = start;
        while (j < end) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
            j++;
        }

        swap(arr, i, end);
        quicksort(arr, start, i - 1);
        quicksort(arr, i + 1, end);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
