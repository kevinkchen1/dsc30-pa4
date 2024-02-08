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

    public MyQueue() {
        // TODO
        queue = new DoublyLinkedList<>();
    }

    public boolean isEmpty() {
        // TODO
        return queue.isEmpty();
    }

    public int size() {
        // TODO
        return queue.size();
    }

    public void enqueue(T data) throws IllegalArgumentException{
        // TODO
        if (data == null){
            throw new IllegalArgumentException("data is null");
        }
        queue.add(data);
    }

    public T dequeue() {
        // TODO
        int last_ind = queue.size() - 1;
        return (T) queue.remove(0);
    }

    public T peek() {
        // TODO
        return (T) queue.get(0);
    }

}
