package hashMapPackage;

import java.util.ArrayList;

/**
 * An implementation of a hash map using separate chaining.
 *
 * @param <K> The type of keys.
 * @param <V> The type of values.
 */
public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
    private UnsortedTableMap<K, V>[] table;

    /**
     * Constructs a ChainHashMap with default capacity and prime factor.
     */
    public ChainHashMap() {
        super();
    }

    /**
     * Constructs a ChainHashMap with a specified initial capacity.
     *
     * @param cap The initial capacity of the hash map.
     */
    public ChainHashMap(int cap) {
        super(cap);
    }

    /**
     * Constructs a ChainHashMap with a specified initial capacity and prime factor.
     *
     * @param cap The initial capacity of the hash map.
     * @param p The prime factor used for hashing.
     */
    public ChainHashMap(int cap, int p) {
        super(cap, p);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void createTable() {
        table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
    }

    /**
     * Retrieves the value associated with the given key from the hash map.
     *
     * @param h The hash code of the key.
     * @param k The key to search for.
     * @return The value associated with the key, or null if the key is not found.
     */
    @Override
    protected V bucketGet(int h, K k) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) {
            return null;
        }
        return bucket.get(k);
    }

    /**
     * Associates the given key with the given value in the hash map.
     *
     * @param h The hash code of the key.
     * @param k The key to associate with the value.
     * @param v The value to be associated with the key.
     * @return The previous value associated with the key, or null if the key is new to the map.
     */
    @Override
    protected V bucketPut(int h, K k, V v) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) {
            bucket = table[h] = new UnsortedTableMap<>();
        }
        int oldSize = bucket.size();
        V answer = bucket.put(k, v);
        n += (bucket.size() - oldSize);
        return answer;
    }

    /**
     * Removes the entry associated with the given key from the hash map.
     *
     * @param h The hash code of the key.
     * @param k The key whose entry should be removed.
     * @return The value associated with the removed key, or null if the key is not found.
     */
    @Override
    protected V bucketRemove(int h, K k) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) {
            return null;
        }
        int oldSize = bucket.size();
        V answer = bucket.remove(k);
        n -= (oldSize - bucket.size());
        return answer;
    }

    /**
     * Returns an iterable collection of all entries in the hash map.
     *
     * @return Iterable collection of entries.
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (int h = 0; h < capacity; h++) {
            if (table[h] != null) {
                for (Entry<K, V> entry : table[h].entrySet()) {
                    buffer.add(entry);
                }
            }
        }
        return buffer;
    }
}
