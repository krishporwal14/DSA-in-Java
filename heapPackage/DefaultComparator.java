import java.util.Comparator;

/** Built-in comparator by java. */
public class DefaultComparator<E> implements Comparator<E> {

    /**
     * Compare two keys based on:
     * i < 0
     * i = 0
     * i > 0
     * 
     * @return i
     */
    @SuppressWarnings("unchecked")
    public int compare(E a, E b) throws ClassCastException {
        return ((Comparable<E>) a).compareTo(b);
    }
}
