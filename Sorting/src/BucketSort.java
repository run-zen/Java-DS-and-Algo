import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BucketSort {

    int[] arr;

    public BucketSort(int[] arr) {
        this.arr = arr;

    }

    public void printArray() {
        System.out.print("\nSorted Array : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // print bucket
    public void printBucket(ArrayList<Integer>[] buckets) {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print("\nBucket No. " + i + " : ");
            for (int j = 0; j < buckets[i].size(); j++) {
                System.out.print(buckets[i].get(j) + " ");
            }
        }
    }

    // bucketsort
    public void bucketSort(int[] arr) {
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));

        int maxValue = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > maxValue) {
                maxValue = i;
            }
        }

        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for (int value : arr) {
            int bucketNumber = (int) Math.ceil(((float) value * numberOfBuckets) / (float) maxValue);
            buckets[bucketNumber - 1].add(value);
        }

        System.out.print("\nPrinting buckets before sorting......");
        printBucket(buckets);

        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        System.out.print("\nPrinting buckets After sorting......");
        printBucket(buckets);

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 6, 3, 9, 5, 2, 1, 1};
        BucketSort bucketSort = new BucketSort(arr);
        bucketSort.bucketSort(bucketSort.arr);
        bucketSort.printArray();
    }
}
