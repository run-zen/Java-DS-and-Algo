import java.util.LinkedList;
import java.util.PriorityQueue;

public class Sort {
    public static int[] bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] >= arr[j + 1]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i; j < len; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        // int[] arr = {7,6,3,9,5,2,1,1};
        int len = arr.length;

        for (int i = 1; i < len; i++) {
            int element = arr[i];
            int position = i;
            for (int j = i - 1; j >= 0; j--) {
                if (element < arr[j]) {
                    arr[j + 1] = arr[j];
                    position = j;
                }
            }

            arr[position] = element;
        }

        return arr;
    }

    public static void heapSort(int[] arr) {
        BinaryHeap minHeap = new BinaryHeap(arr.length);
        for (int value:arr) {
            minHeap.insert(value);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]= minHeap.extractHead();
        }
    }
}
