public class QuickSort {

    public static int partition(int[] arr, int start, int end) {
        int pivot = end;

        int i = start - 1;

        for (int j = start; j <= end; j++) {
            if (arr[j] <= arr[pivot]) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return i;
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    public void quickSort(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }

    // to print the array
    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
