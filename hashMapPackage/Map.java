package hashMapPackage;

/**
 * An interface representing a simple map, which maps keys to values.
 *
 * @param <K> The type of keys in the map.
 * @param <V> The type of values in the map.
 */
public interface Map<K, V> {
    /**
     * Returns the number of key-value pairs in the map.
     *
     * @return The number of key-value pairs in the map.
     */
    int size();

    /**
     * Checks if the map is empty.
     *
     * @return True if the map is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Retrieves the value associated with the specified key.
     *
     * @param key The key whose associated value is to be retrieved.
     * @return The value associated with the specified key, or null if the key is not present.
     */
    V get(K key);

    /**
     * Associates the specified value with the specified key in the map.
     *
     * @param key   The key with which the specified value is to be associated.
     * @param value The value to be associated with the specified key.
     * @return The previous value associated with the key, or null if the key was not present.
     */
    V put(K key, V value);

    /**
     * Removes the mapping for the specified key from the map.
     *
     * @param key The key whose mapping is to be removed from the map.
     * @return The value associated with the specified key, or null if the key was not present.
     */
    V remove(K key);

    /**
     * Returns an iterable collection of all keys in the map.
     *
     * @return An iterable collection of all keys in the map.
     */
    Iterable<K> keySet();

    /**
     * Returns an iterable collection of all values in the map.
     *
     * @return An iterable collection of all values in the map.
     */
    Iterable<V> valueSet();

    /**
     * Returns an iterable collection of all key-value entries in the map.
     *
     * @return An iterable collection of all key-value entries in the map.
     */
    Iterable<Entry<K, V>> entrySet();
}
