import java.util.HashMap;

public class FirstRecurringChar {

    // naive approach
    public static Integer naive(int[] arr) {

        for(int i=0;i< arr.length;i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }

        return -1;
    }


    // HashMap implementation
    public static Integer findFirstRecurringChar(int[] arr) { // time complexity -> O(n)
        HashMap<Integer, Integer> hmap = new HashMap<>(1000);

        for (int i : arr) {
            if (hmap.get(i) != null) {
                return i;
            }

            hmap.put(i, 1);
        }

        return -1;

    }

    public static void main(String[] args) {

        int[] arr = new int[]{2, 3,3, 4, 1, 2, 5};

        System.out.println(findFirstRecurringChar(arr));
        System.out.println(naive(arr));

    }
}
