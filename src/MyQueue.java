/*
    Name: Kevin Chen
    PID:  A18063886
 */

/**
 * TODO
 *
 * @author Kevin Chen
 * @since 2/4/24
 */

public class MyQueue<T> implements MyQueueInterface<T> {
    
    /* instance variables, feel free to add if you need */

    /* ===separation=== */
    private DoublyLinkedList<Object> queue;
    /**
     * Constructor for MyQueue, uses DLL object as queue
     */
    public MyQueue() {
        // TODO
        queue = new DoublyLinkedList<>();
    }

    /**
     * Set the value of an element at a certain index in the list.
     * @return true if queue is empty with no elements, else false.
     */
    public boolean isEmpty() {
        // TODO
        return queue.isEmpty();
    }

    /**
     * Calculates number of elements in the queue.
     * @return integer showing size of queue.
     */
    public int size() {
        // TODO
        return queue.size();
    }
    /**
     * Adds an element to the end of the queue.
     * @param data generic data type that is to be added to end of queue.
     * @throws IllegalArgumentException if data is null
     */
    public void enqueue(T data) throws IllegalArgumentException{
        // TODO
        if (data == null){
            throw new IllegalArgumentException("data is null");
        }
        queue.add(data);
    }
    /**
     * Removes an element from the front of the queue.
     * @return data value of the element that was removed
     */
    public T dequeue() {
        // TODO
        if (size() <= 0){
            return null;
        }

        //int lastInd = queue.size() - 1;
        return (T) queue.remove(0);
    }
    /**
     * Returns the element from the front of the queue without removing..
     * @return data value of the element at the front
     */
    public T peek() {
        // TODO
        if (size() <= 0){
            return null;
        }
        return (T) queue.get(0);
    }

}
