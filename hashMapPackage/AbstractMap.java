package hashMapPackage;

import java.util.Iterator;

/**
 * An abstract class providing a skeletal implementation of the Map interface.
 *
 * @param <K> The type of keys.
 * @param <V> The type of values.
 */
public abstract class AbstractMap<K, V> implements Map<K, V> {

    /**
     * A simple entry implementation representing a key-value pair.
     *
     * @param <K> The type of keys.
     * @param <V> The type of values.
     */
    protected static class MapEntry<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        /**
         * Constructs a MapEntry with the given key and value.
         *
         * @param k The key of the entry.
         * @param v The value of the entry.
         */
        public MapEntry(K k, V v) {
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
        public void setKey(K k) {
            key = k;
        }

        /**
         * Sets the value of the entry.
         *
         * @param v The new value.
         * @return The old value.
         */
        public V setValue(V v) {
            V old = value;
            value = v;
            return old;
        }
    }

    /**
     * An iterator over the keys in the map.
     */
    private class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator();

        /**
         * Checks if there are more keys in the map.
         *
         * @return true if there are more keys, false otherwise.
         */
        public boolean hasNext() {
            return entries.hasNext();
        }

        /**
         * Retrieves the next key in the iteration.
         *
         * @return The next key.
         */
        public K next() {
            return entries.next().getKey();
        }

        /**
         * Not supported. Throws UnsupportedOperationException.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * An iterable collection of keys in the map.
     */
    private class KeyIterable implements Iterable<K> {

        /**
         * Returns an iterator over the keys in the map.
         *
         * @return An iterator over the keys.
         */
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    /**
     * Retrieves an iterable collection of keys in the map.
     *
     * @return An iterable collection of keys.
     */
    public Iterable<K> keySet() {
        return new KeyIterable();
    }

    /**
     * An iterator over the values in the map.
     */
    private class ValueIterator implements Iterator<V> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator();

        /**
         * Checks if there are more values in the map.
         *
         * @return true if there are more values, false otherwise.
         */
        public boolean hasNext() {
            return entries.hasNext();
        }

        /**
         * Retrieves the next value in the iteration.
         *
         * @return The next value.
         */
        public V next() {
            return entries.next().getValue();
        }

        /**
         * Not supported. Throws UnsupportedOperationException.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * An iterable collection of values in the map.
     */
    private class ValueIterable implements Iterable<V> {

        /**
         * Returns an iterator over the values in the map.
         *
         * @return An iterator over the values.
         */
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    /**
     * Retrieves an iterable collection of values in the map.
     *
     * @return An iterable collection of values.
     */
    public Iterable<V> valueSet() {
        return new ValueIterable();
    }
}
