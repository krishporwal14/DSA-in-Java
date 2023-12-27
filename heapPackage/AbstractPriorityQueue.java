import java.util.Comparator;

/**
 * An abstract implementation of the PriorityQueue interface.
 *
 * @param <K> The key type.
 * @param <V> The value type.
 */
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {

    /**
     * Inner class representing an entry in the priority queue.
     *
     * @param <K> The key type.
     * @param <V> The value type.
     */
    public class PQEntry<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        /**
         * Constructs a PQEntry with the given key and value.
         *
         * @param k The key.
         * @param v The value.
         */
        public PQEntry(K k, V v) {
            key = k;
            value = v;
        }

        /**
         * Retrieves the key of the entry.
         *
         * @return The key of the entry.
         */
        public K getKey() {
            return key;
        }

        /**
         * Retrieves the value of the entry.
         *
         * @return The value of the entry.
         */
        public V getValue() {
            return value;
        }

        /**
         * Sets the key of the entry.
         *
         * @param k The new key.
         */
        protected void setKey(K k) {
            key = k;
        }

        /**
         * Sets the value of the entry.
         *
         * @param v The new value.
         */
        protected void setValue(V v) {
            value = v;
        }
    }

    private Comparator<K> comp;

    /**
     * Constructs an AbstractPriorityQueue with the given comparator.
     *
     * @param c The comparator to be used for comparing keys.
     */
    protected AbstractPriorityQueue(Comparator<K> c) {
        comp = c;
    }

    /**
     * Constructs an AbstractPriorityQueue with the default comparator.
     */
    protected AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    }

    /**
     * Compares two entries based on their keys using the comparator.
     *
     * @param a The first entry.
     * @param b The second entry.
     * @return An integer representing the comparison result.
     */
    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    /**
     * Checks if the given key is compatible with the comparator.
     *
     * @param key The key to be checked.
     * @return True if the key is compatible, false otherwise.
     * @throws IllegalArgumentException If the key is not compatible.
     */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comp.compare(key, key) == 0);
        } catch (Exception e) {
            throw new IllegalArgumentException("Incompatible key.");
        }
    }

    /**
     * Checks if the priority queue is empty.
     *
     * @return True if the priority queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
}
