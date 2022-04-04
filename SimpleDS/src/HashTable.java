import java.util.ArrayList;

public class HashTable<K, V> {

    static class KVPairs<K, V> {
        K key;
        V value;

        public KVPairs(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<KVPairs<K, V>>[] arr;
    private ArrayList<K> hKeys;
    private ArrayList<Integer> hashCodes;

    public HashTable(int size) {
        arr = new ArrayList[size];
        hashCodes = new ArrayList<>(size);
        hKeys = new ArrayList<>(size);
    }

    public int _hash(K key) {
        int hash = 0;
        String _key = String.valueOf(key);
        int len = _key.length();
        for (int i = 0; i < len; i++) {
            hash = (hash + (int) _key.charAt(i)) % arr.length;
        }
        return hash;
    }

    public void set(K key, V value) { // average case O(1) // worst case O(n)
        int hashKey = this._hash(key);

        if (hashKey >= this.arr.length) {
            ArrayList<KVPairs<K, V>>[] newarr = new ArrayList[2 * hashKey];
            for (int i = 0; i < arr.length; i++) {      // worst case O(n)
                newarr[i] = arr[i];
            }

            arr = newarr;
        }


        if (arr[hashKey] == null) {
            ArrayList<KVPairs<K, V>> newBucket = new ArrayList<>(1);
            newBucket.add(new KVPairs<>(key, value));
            arr[hashKey] = newBucket;
            hKeys.add(key);
            hashCodes.add(hashKey);
        } else {
            ArrayList<KVPairs<K, V>> currentBucket = arr[hashKey];
            boolean keyExists = false;
            for (int i = 0; i < currentBucket.size(); i++) {
                if(currentBucket.get(i).key == key) {
                    keyExists = true;
                    arr[hashKey].set(i,new KVPairs<>(key, value));
                    break;
                }
            }

            if(!keyExists) {
                arr[hashKey].add(new KVPairs<>(key, value));
                hKeys.add(key);
                hashCodes.add(hashKey);
            }
        }

    }

    //
    public V get(K key) {  // average case O(1) // worst case O(n)

        int hashKey = this._hash(key);

        if (hashKey > arr.length) {
            return null;
        }

        if (arr[hashKey] != null) {
            ArrayList<KVPairs<K, V>> currentBucket;
            currentBucket = arr[hashKey];
            for (KVPairs<K, V> kvkvPairs : currentBucket) {
                if (kvkvPairs.key == key) {
                    return kvkvPairs.value;
                }
            }
        }

        return null;
    }

    public ArrayList<K> keys() {
        ArrayList<K> keysArray = null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (keysArray == null) {
                    keysArray = new ArrayList<>(1);
                }
                ArrayList<KVPairs<K, V>> currentBucket = arr[i];
                for (int j = 0; j < currentBucket.size(); j++) {
                    keysArray.add(currentBucket.get(j).key);
                }
            }
        }

        return keysArray;
    }

    public static void main(String[] args) {
        HashTable<String,Integer> hmap = new HashTable<>(50);
        hmap.set("grapes",1000);
        hmap.set("mango",10);
        hmap.set("apple",50);
        hmap.set("apples",19);
        hmap.set("grapes",500);
        System.out.println(hmap.keys());
    }

}
