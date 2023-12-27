package hashMapPackage;

import java.util.ArrayList;
import java.util.Random;

/**
 * An abstract class providing a skeletal implementation of the HashMap interface.
 *
 * @param <K> The type of keys.
 * @param <V> The type of values.
 */
public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
    protected int n = 0;
    protected int capacity;
    private int prime;
    long scale, shift;

    /**
     * Constructs an AbstractHashMap with the specified initial capacity and prime factor.
     *
     * @param cap The initial capacity of the hash map.
     * @param p The prime factor used for hashing.
     */
    public AbstractHashMap(int cap, int p) {
        prime = p;
        capacity = cap;
        Random rand = new Random();
        scale = rand.nextInt(prime - 1) + 1;
        shift = rand.nextInt(prime);
        createTable();
    }

    /**
     * Constructs an AbstractHashMap with the specified initial capacity and a default prime factor.
     *
     * @param cap The initial capacity of the hash map.
     */
    public AbstractHashMap(int cap) {
        this(cap, 109345121);
    }

    /**
     * Constructs an AbstractHashMap with a default initial capacity and prime factor.
     */
    public AbstractHashMap() {
        this(17);
    }

    /**
     * Retrieves the number of entries in the hash map.
     *
     * @return The number of entries.
     */
    public int size() {
        return n;
    }

    /**
     * Checks if the hash map is empty.
     *
     * @return true if the hash map is empty, false otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Retrieves the value associated with the specified key.
     *
     * @param key The key to search for.
     * @return The value associated with the key, or null if the key is not found.
     */
    public V get(K key) {
        return bucketGet(hashValue(key), key);
    }

    /**
     * Removes the entry associated with the specified key from the hash map.
     *
     * @param key The key whose entry should be removed.
     * @return The value associated with the removed key, or null if the key is not found.
     */
    public V remove(K key) {
        return bucketRemove(hashValue(key), key);
    }

    /**
     * Associates the specified key with the specified value in the hash map.
     *
     * @param key The key to associate with the value.
     * @param value The value to be associated with the key.
     * @return The previous value associated with the key, or null if the key is new to the map.
     */
    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);
        if (n > capacity / 2) {
            resize(2 * capacity - 1);
        }
        return answer;
    }

    /**
     * Calculates the hash value for the given key.
     *
     * @param key The key for which to calculate the hash value.
     * @return The hash value.
     */
    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    }

    /**
     * Resizes the hash map to the specified new capacity.
     *
     * @param newCap The new capacity for the hash map.
     */
    private void resize(int newCap) {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (Entry<K, V> e : entrySet()) {
            buffer.add(e);
        }
        capacity = newCap;
        createTable();
        n = 0;
        for (Entry<K, V> e : buffer) {
            put(e.getKey(), e.getValue());
        }
    }

    /**
     * Creates the underlying table for the hash map.
     */
    protected abstract void createTable();

    /**
     * Retrieves the value associated with the specified key and hash code.
     *
     * @param h The hash code of the key.
     * @param k The key to search for.
     * @return The value associated with the key, or null if the key is not found.
     */
    protected abstract V bucketGet(int h, K k);

    /**
     * Associates the specified key with the specified value and hash code in the hash map.
     *
     * @param h The hash code of the key.
     * @param k The key to associate with the value.
     * @param v The value to be associated with the key.
     * @return The previous value associated with the key, or null if the key is new to the map.
     */
    protected abstract V bucketPut(int h, K k, V v);

    /**
     * Removes the entry associated with the specified key and hash code from the hash map.
     *
     * @param h The hash code of the key.
     * @param k The key whose entry should be removed.
     * @return The value associated with the removed key, or null if the key is not found.
     */
    protected abstract V bucketRemove(int h, K k);
}
