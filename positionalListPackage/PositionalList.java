package positionalListPackage;
/**Interface for Positional List */
public interface PositionalList<E> {
    /** @return size of the list */
    public int size();
    /**@return Boolean value whether list is empty or not */
    public boolean isEmpty();
    /**@return The first position of the list or null, if empty */
    public Position<E> first();
    /**@return The last position of the list or null, if empty */
    public Position<E> last();
    /**@param p Position in the list 
     * @return The position before Position p or null, if p is first 
     */
    public Position<E> before(Position<E> p);
    /**@param p Position in the list
     * @return The position after Position p or null, if p is last
     */
    public Position<E> after(Position<E> p);
    /**Insert the element at the front of the list and return its new position 
     * @param e Element to be inserted
     * @return New Position
     */
    public Position<E> addFirst(E e);
    /**Insert the element at the end of the list and return its new position 
     * @param e Element to be inserted
     * @return New Position
     */
    public Position<E> addLast(E e);
    /**Inserts element immediately before position and return its new position
     * @param e Element to be inserted
     * @param p Position
     * @return New Position
     */
    public Position<E> addBefore(Position<E> p, E e);
    /**Inserts element immediately after position and return its new position
     * @param e Element to be inserted
     * @param p Position
     * @return New Position
     */
    public Position<E> addAfter(Position<E> p, E e);
    /**Replace the element stored at Position and return the replaced element
     * @parma e Element to be inserted
     * @param p Position
     * @return Replaced Element
     */
    public E set(Position<E> p, E e);
    /**Removes the element stored at Position and return it
     * @param p Position to be deleted
     * @return element at p
     */
    public E remove(Position<E> p);
}
