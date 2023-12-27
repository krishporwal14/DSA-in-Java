package hashMapPackage;

import java.util.ArrayList;

/**
 * A hash map implementation using open addressing with linear probing.
 *
 * @param <K> The type of keys.
 * @param <V> The type of values.
 */
public class ProbeHashMap<K, V> extends AbstractHashMap<K, V> {
    private MapEntry<K, V>[] table;
    private MapEntry<K, V> DEFUNCT = new MapEntry<>(null, null);

    /**
     * Constructs a ProbeHashMap with default capacity and prime factor.
     */
    public ProbeHashMap() {
        super();
    }

    /**
     * Constructs a ProbeHashMap with a specified initial capacity.
     *
     * @param cap The initial capacity of the hash map.
     */
    public ProbeHashMap(int cap) {
        super(cap);
    }

    /**
     * Constructs a ProbeHashMap with a specified initial capacity and prime factor.
     *
     * @param cap The initial capacity of the hash map.
     * @param p   The prime factor used for probing.
     */
    public ProbeHashMap(int cap, int p) {
        super(cap, p);
    }

    /**
     * Creates the underlying table for storing entries.
     */
    @SuppressWarnings("unchecked")
    protected void createTable() {
        table = (MapEntry<K, V>[]) new MapEntry[capacity];
    }

    /**
     * Checks if the slot at index j is available.
     *
     * @param j The index to check.
     * @return True if the slot is available, false otherwise.
     */
    private boolean isAvailable(int j) {
        return (table[j] == null || table[j] == DEFUNCT);
    }

    /**
     * Finds the appropriate slot for a key in the hash table using linear probing.
     *
     * @param h The original hash value of the key.
     * @param k The key to find a slot for.
     * @return The index of the slot or a negative value indicating no available slot.
     */
    private int findSlot(int h, K k) {
        int avail = -1;
        int j = h;
        do {
            if (isAvailable(j)) {
                if (avail == -1) {
                    avail = j;
                }
                if (table[j] == null) {
                    break;
                }
            } else if (table[j].getKey().equals(k)) {
                return j;
            }
            j = (j + 1) % capacity;
        } while (j != h);
        return -(avail + 1);
    }

    /**
     * Retrieves the value associated with a key in the hash map.
     *
     * @param h The hash value of the key.
     * @param k The key to look up.
     * @return The value associated with the key, or null if the key is not present.
     */
    protected V bucketGet(int h, K k) {
        int j = findSlot(h, k);
        if (j < 0) {
            return null;
        }
        return table[j].getValue();
    }

    /**
     * Inserts a key-value pair into the hash map or updates the value if the key already exists.
     *
     * @param h The hash value of the key.
     * @param k The key to insert or update.
     * @param v The value associated with the key.
     * @return The previous value associated with the key, or null if the key is new.
     */
    protected V bucketPut(int h, K k, V v) {
        int j = findSlot(h, k);
        if (j >= 0) {
            return table[j].setValue(v);
        }
        table[-(j + 1)] = new MapEntry<>(k, v);
        n++;
        return null;
    }

    /**
     * Removes a key-value pair from the hash map.
     *
     * @param h The hash value of the key.
     * @param k The key to remove.
     * @return The value associated with the removed key, or null if the key is not present.
     */
    protected V bucketRemove(int h, K k) {
        int j = findSlot(h, k);
        if (j < 0) {
            return null;
        }
        V answer = table[j].getValue();
        table[j] = DEFUNCT;
        n--;
        return answer;
    }

    /**
     * Returns an iterable collection of all entries in the hash map.
     *
     * @return Iterable collection of entries.
     */
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (int h = 0; h < capacity; h++) {
            if (!isAvailable(h)) {
                buffer.add(table[h]);
            }
        }
        return buffer;
    }
}
