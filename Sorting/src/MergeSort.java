public class MergeSort {

    private void merge(int[] A, int beg, int mid, int end) {
        int n1 = mid - beg + 1;
        int n2 = end - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = A[beg + i];
        }

        for (int i = 0; i < n2; i++) {
            rightArr[i] = A[mid + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = beg;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                A[k] = leftArr[i++];
            } else {
                A[k] = rightArr[j++];
            }
            k++;
        }

        while (i < n1) {
            A[k++] = leftArr[i++];
        }

        while (j < n2) {
            A[k++] = rightArr[j++];
        }
    }

    private void merge_sort(int[] A, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            merge_sort(A, l, mid);
            merge_sort(A, mid + 1, r);
            merge(A, l, mid, r);
        }
    }

    public void merge_sort(int[] A) {
        merge_sort(A, 0, A.length - 1);
    }

    public void printArray(int[] arr) {
        System.out.print("\n");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
