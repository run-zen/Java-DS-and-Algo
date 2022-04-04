public class DynamicArray<T> {

    private Object[] arr;
    private int count;
    public int capacity;
    public int length;

    public DynamicArray() {
        count = 0;
        capacity = 0;
        length=0;
    }

    public DynamicArray(int length) {
        arr = new Object[length];
        count = 0;
        capacity = length;
        this.length = length;
    }

    public void printArray() {
        System.out.println("");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void insert(T element) {
        if(this.arr == null) {
            arr = new Object[1];
            capacity = arr.length;
            length = arr.length;
        }
        if (arr.length == count) {
            Object[] newArr = new Object[2 * count];

            for (int i = 0; i < count; i++) {
                newArr[i] = arr[i];
            }

            arr = newArr;
            capacity = arr.length;
        }

        arr[count++] = element;
        length = count;
    }

    public static void main(String[] args) {

        DynamicArray<Integer> arr = new DynamicArray();

        arr.insert(1);
        arr.insert(2);
        arr.insert(2);
        arr.insert(2);
        arr.printArray();

        DynamicArray<Character> arr2 = new DynamicArray();

        arr2.insert('R');
        arr2.insert('A');
        arr2.insert('N');
        arr2.insert('J');
        arr2.insert('A');
        arr2.insert('N');
        arr2.printArray();
    }

}
