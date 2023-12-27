package hashMapPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of a map using an unsorted table.
 *
 * @param <K> The type of keys.
 * @param <V> The type of values.
 */
public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
    private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    /**
     * Constructs an empty UnsortedTableMap.
     */
    public UnsortedTableMap() {}

    private int findIndex(K key) {
        int n = table.size();
        for (int j = 0; j < n; j++) {
            if (table.get(j).getKey().equals(key)) {
                return j;
            }
        }
        return -1;
    }

    /**
     * Returns the number of entries in the map.
     *
     * @return The number of entries in the map.
     */
    public int size() {
        return table.size();
    }

    /**
     * Checks if the map is empty.
     *
     * @return True if the map is empty, false otherwise.
     */
    public boolean isEmpty() {
        return table.isEmpty();
    }

    /**
     * Retrieves the value associated with the specified key.
     *
     * @param key The key to search for.
     * @return The value associated with the key, or null if not found.
     */
    public V get(K key) {
        int j = findIndex(key);
        if (j == -1) {
            return null;
        }
        return table.get(j).getValue();
    }

    /**
     * Associates the specified value with the specified key in the map.
     * If the key is not present, a new entry is added.
     * If the key is already present, the existing value is replaced.
     *
     * @param key   The key to associate with the value.
     * @param value The value to be associated with the key.
     * @return The previous value associated with the key, or null if the key is new.
     */
    public V put(K key, V value) {
        int j = findIndex(key);
        if (j == -1) {
            table.add(new MapEntry<>(key, value));
            return null;
        } else {
            return table.get(j).setValue(value);
        }
    }

    /**
     * Removes the entry with the specified key from the map.
     *
     * @param key The key of the entry to be removed.
     * @return The value associated with the removed key, or null if the key is not found.
     */
    public V remove(K key) {
        int j = findIndex(key);
        int n = size();
        if (j == -1) {
            return null;
        }
        V answer = table.get(j).getValue();
        if (j != n - 1) {
            table.set(j, table.get(n - 1));
        }
        table.remove(n - 1);
        return answer;
    }

    private class EntryIterator implements Iterator<Entry<K, V>> {
        private int j = 0;

        /**
         * Checks if there is another entry in the iterator.
         *
         * @return True if there is another entry, false otherwise.
         */
        public boolean hasNext() {
            return j < table.size();
        }

        /**
         * Retrieves the next entry in the iterator.
         *
         * @return The next entry in the iterator.
         * @throws NoSuchElementException If there are no more entries.
         */
        public Entry<K, V> next() {
            if (j == table.size()) throw new NoSuchElementException();
            return table.get(j++);
        }

        /**
         * Unsupported operation. Removal of entries is not supported.
         *
         * @throws UnsupportedOperationException Always thrown.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class EntryIterable implements Iterable<Entry<K, V>> {

        /**
         * Returns an iterator over the entries in the map.
         *
         * @return An iterator over the entries in the map.
         */
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }

    /**
     * Returns an iterable collection of all entries in the map.
     *
     * @return Iterable collection of entries.
     */
    public Iterable<Entry<K, V>> entrySet() {
        return new EntryIterable();
    }
}
