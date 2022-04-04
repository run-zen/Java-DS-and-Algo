public class ContainsCommonElement {

    public static boolean hasCommonElement(Character[] arr1, Character[] arr2) { // O(a+b)

        // input parameter validation

        HashTable<Character, Integer> hmap = new HashTable<>(arr1.length);

        for (Character i : arr1) {
            hmap.set(i, 1);
        }

        for (Character i : arr2) {
            if (hmap.get(i) != null && hmap.get(i) == 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Character[] array1 = new Character[]{'a', 'b', 'c', 'x'};
        Character[] array2 = new Character[]{'z', 'y', 'f'};

        System.out.println(hasCommonElement(array1,array2));

    }
}
