public class BinaryHeap {
    private int[] arr;
    private int size;
    private type heapType;

    public enum type {
        MIN, MAX
    }

    public BinaryHeap(int size) {
        arr = new int[size + 1];
        this.size = 0;
        heapType = type.MIN;
    }

    public Integer peek() {  // O(1)
        if (isEmpty()) {
            System.out.println("\nBinary Heap is empty");
        }

        return arr[1];
    }

    public boolean isEmpty() { // O(1)
        return size == 0;
    }

    public Integer size() {
        return this.size;
    }

    public void levelOrder() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private int getParentIndex(int index) {
        if (index % 2 == 0) {
            return index / 2;
        }

        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        if (index1 >= 1 && index2 >= 1) {
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }

    private void minHeapify(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex < 1) {
            return;
        }

        if (arr[index] <= arr[parentIndex]) {
            swap(index, parentIndex);
        }

        minHeapify(parentIndex);
    }

    public void minHeapify() {
        heapType = type.MIN;
        minHeapify(size);
    }

    private void maxHeapify(int index) {
        int parentIndex = getParentIndex(index);

        if (parentIndex < 1) {
            return;
        }

        if (arr[index] > arr[parentIndex]) {
            swap(index, parentIndex);
        }

        maxHeapify(parentIndex);
    }

    public void maxHeapify() {
        heapType = type.MAX;
        maxHeapify(size);
    }

    public void insert(int value) {
        arr[++size] = value;

        if (heapType == type.MIN) {
            minHeapify(size);
        } else {
            maxHeapify(size);
        }
    }

    private void heapifyTopToBottom(int index) {
        int left = index * 2;
        int right = left + 1;
        int swapChild;
        if (size < left) {
            return;
        }
        if (size == left) {
            if(arr[index] > arr[left]) {
                swap(index,left);
            }
            return;
        } else {
            if(arr[left] > arr[right]) {
                 swapChild = right;
            } else {
                swapChild = left;
            }

            if(arr[index] > arr[swapChild]) {
                swap(index,swapChild);
            }
        }
        heapifyTopToBottom(swapChild);
    }

    public int extractHead() {
        if(isEmpty()) {
            return -1;
        }

        int extracted = arr[1];
        arr[1] = arr[size--];
        heapifyTopToBottom(1);
        return extracted;

    }
}
