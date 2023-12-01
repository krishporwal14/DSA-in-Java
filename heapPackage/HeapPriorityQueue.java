import java.util.ArrayList;
import java.util.Comparator;

/**
 * A binary heap-based implementation of the PriorityQueue interface.
 *
 * @param <K> The key type.
 * @param <V> The value type.
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    /**
     * Internal list representing the binary heap.
     */
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    /**
     * Constructs an empty HeapPriorityQueue using the default comparator.
     */
    public HeapPriorityQueue() {
        super();
    }

    /**
     * Constructs an empty HeapPriorityQueue using the given comparator.
     *
     * @param comp The comparator to be used for comparing keys.
     */
    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    /**
     * Retrieves the index of the parent of the element at index j.
     *
     * @param j The index of the element.
     * @return The index of the parent.
     */
    protected int parent(int j) {
        return (j - 1) / 2;
    }

    /**
     * Retrieves the index of the left child of the element at index j.
     *
     * @param j The index of the element.
     * @return The index of the left child.
     */
    protected int left(int j) {
        return 2 * j + 1;
    }

    /**
     * Retrieves the index of the right child of the element at index j.
     *
     * @param j The index of the element.
     * @return The index of the right child.
     */
    protected int right(int j) {
        return 2 * j + 2;
    }

    /**
     * Checks if the element at index j has a left child.
     *
     * @param j The index of the element.
     * @return True if the left child exists, false otherwise.
     */
    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    /**
     * Checks if the element at index j has a right child.
     *
     * @param j The index of the element.
     * @return True if the right child exists, false otherwise.
     */
    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    /**
     * Swaps elements at indices i and j in the heap.
     *
     * @param i Index of the first element.
     * @param j Index of the second element.
     */
    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Performs up-heap bubbling starting from the given index.
     *
     * @param j The index from which to start the up-heap operation.
     */
    protected void upheap(int j) {
        while (j > 0) {
            int p = parent(j);
            if (compare(heap.get(j), heap.get(p)) >= 0) {
                break;
            }
            swap(j, p);
            j = p;
        }
    }

    /**
     * Performs down-heap bubbling starting from the given index.
     *
     * @param j The index from which to start the down-heap operation.
     */
    protected void downHeap(int j) {
        while (hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0) {
                    smallChildIndex = rightIndex;
                }
            }
            if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0) {
                break;
            }
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }

    // Methods inherited from the PriorityQueue interface

    /**
     * Retrieves the number of elements in the priority queue.
     *
     * @return The number of elements in the priority queue.
     */
    public int size() {
        return heap.size();
    }

    /**
     * Retrieves the entry with the minimum key in the priority queue.
     *
     * @return The entry with the minimum key or null if the priority queue is
     *         empty.
     */
    public Entry<K, V> min() {
        if (heap.isEmpty()) {
            return null;
        }
        return heap.get(0);
    }

    /**
     * Inserts a new entry with the given key and value into the priority queue.
     *
     * @param key   The key of the new entry.
     * @param value The value of the new entry.
     * @return The new entry.
     * @throws IllegalArgumentException If the key is not compatible with the
     *                                  comparator.
     */
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        heap.add(newest);
        upheap(heap.size() - 1);
        return newest;
    }

    /**
     * Removes and returns the entry with the minimum key from the priority queue.
     *
     * @return The entry with the minimum key or null if the priority queue is
     *         empty.
     */
    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) {
            return null;
        }
        Entry<K, V> answer = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downHeap(0);
        return answer;
    }

    /**
     * Displays the elements of the heap in a tree-like structure.
     */
    public void displayQueue() {
        int depth = (int) (Math.log(heap.size() + 1) / Math.log(2));

        for (int i = 0; i <= depth; i++) {
            int levelSize = Math.min(heap.size() - (int) Math.pow(2, i) + 1, (int) Math.pow(2, i));
            for (int j = 0; j < levelSize; j++) {
                Entry<K, V> entry = heap.get((int) Math.pow(2, i) - 1 + j);
                System.out.print(entry.getKey() + ": " + entry.getValue() + " ");
            }
            System.out.println();
        }
    }
}
