/**
 * Interface representing a Priority Queue which is implemented using a heap.
 */
public interface PriorityQueue<K, V> {
    /**
     * @return size of the priority queue
     */
    int size();

    /**
     * @return true if priority queue is empty else false
     */
    boolean isEmpty();

    /**
     * Method to insert a entry in the priority queue and upheap the newly added
     * entry to its appropriate position.
     * 
     * @param key   Priority of the entry
     * @param value Data element of the entry
     * @return Newly added entry
     * @throws IllegalArgumentException
     */
    Entry<K, V> insert(K key, V value) throws IllegalArgumentException;

    /**
     * @return The entry with the most minimum priority
     */
    Entry<K, V> min();

    /**
     * @return Removes the entry with the most minimum priority from the priority
     *         queue
     */
    Entry<K, V> removeMin();
}
