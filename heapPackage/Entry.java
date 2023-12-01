/**
 * An interface representing a single node or entry in the heap priority queue.
 */
public interface Entry<K, V> {
    /**
     * Accessor method
     * 
     * @return the key or priority of the entry
     */
    K getKey();

    /**
     * Accessor method
     * 
     * @return the data stored at the entry
     */
    V getValue();
}
