/*
 * NAME: Kevin Chen
 * PID: A18063886
 */

import java.util.AbstractList;

/**
 * TODO
 * @author Kevin Chen
 * @since 2/4/24
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int nelems;
    public Node head; //change back to private!! and for tail
    public Node tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {

        /* Node instance variables */
        T data;
        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         * @param element is a value of a generic data type, which can be any value
         */
        private Node(T element) {
            // TODO: complete constructor
            data = element;
            next = null;
            prev = null;
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
            // TODO: complete implementation
            data = element;
            next = nextNode;
            prev = prevNode;
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            // TODO: complete implementation
            data = element;
        }

        /**
         * Accessor to get the Nodes Element
         * @return the data value of generic type T in the node
         */
        public T getElement() {
            // TODO: complete implementation
            return data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            // TODO: complete implementation
            next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            // TODO: complete implementation
            return next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            // TODO: complete implementation
            prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {
            // TODO: complete implementation
            return prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            // TODO: complete implementation
            prev.next = next;
            next.prev = prev;
            //prev = null;
            //next = null;

        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        // TODO: complete default constructor
        head = new Node(null);
        tail = new Node(null);

    }

    /**
     * Add an element to the end of the list
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        // TODO: Implementation for throwing exceptions followed by
        // implementation of adding the new data
        if (element == null){
            throw new NullPointerException("data is null");
        }
        if (head.next == null && tail.next == null){
            Node newNode = new Node(element);
            head.next = newNode;
            tail.prev = newNode;
            newNode.setNext(tail);
            newNode.setPrev(head);
            //newNode.next = tail;
            //newNode.prev = head;

        } else {
            Node lastNode = tail.prev;
            Node newNode = new Node(element, tail, lastNode);
            lastNode.setNext(newNode);
            tail.setPrev(newNode);
            newNode.setNext(tail);
            //lastNode.next = newNode;
            //tail.prev = newNode;
            //tail = newNode;
        }
        nelems++;
        return true;
    }


    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     * TODO: Javadoc comments
     * Add an element to the end of the list
     * @param index the position where element will be added
     * @param element data to be added
     * @throws IndexOutOfBoundsException if index is outside the range [0, size]
     * @throws NullPointerException if data received is null
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        // TODO: Implementation for throwing exceptions followed by
        // implementation of adding the new data
        if ((index < 0) || (index > nelems)) {
            throw new IndexOutOfBoundsException("index is outside the range [0, size]");
        }
        if (element == null) {
            throw new NullPointerException("data is null");
        }
        if (head.next == null && tail.next == null){
            Node newNode = new Node(element);
            head.next = newNode;
            tail.prev = newNode;
            newNode.setNext(tail);
            newNode.setPrev(head);
        }

        if (index == 0) {
            Node newNode = new Node(element, head.next, head);
            head.next = newNode;
        } else {
            Node node = head.next; //.next
            int i = 1; // 0
            while (node != null) {
                if (i == index) {
                    Node sucNode = node.next;
                    Node newNode = new Node(element, sucNode, node);
                    node.setNext(newNode);
                    sucNode.setPrev(newNode);
                    //node.next = newNode;
                    //sucNode.prev = newNode;
                }
                i++;
                node = node.next;
            }

            //}
            ;

        }
        nelems++;
    }
    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        // TODO: implement clear
        nelems = 0;
        head = new Node(null);
        tail = new Node(null);
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     * TODO: Javadoc comments
     * @param element is checked if it appears in the list at least once
     * @return boolean, true if the element is in the list, else false
     */
    @Override
    public boolean contains(Object element) {
        T data = (T) element;
        Node node = head.next;
        while (node != null){
            if (node.data == data){
                return true;
            }
            node = node.next;
        }
        // TODO: Fill in implementation
        return false;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     * @param index the position of the node's data being accessed
     * @throws IndexOutOfBoundsException if index is outside the range [0, size]
     * @return data value of generic type of the node at specified index
     * TODO: Javadoc comments
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        // TODO: Fill in implementation to get the node at index
        if ((index < 0) || (index > nelems - 1)) {
            throw new IndexOutOfBoundsException("index is outside the range [0, size - 1]");
        }
        if (nelems <= 0){
            throw new IndexOutOfBoundsException("getting index of empty list");
        }

        Node node = head.next;
        int i = 0;
        while (node != null) {
            if (i == index){
                return node.data;
            }
            i ++;
            node = node.next;
        }
        return null;
    }

    /**
     * Helper method to get the Nth node in our list
     * @param index the position of the node's data being accessed
     * @return
     * TODO: Javadoc comments
     */
    private Node getNth(int index) {
        // TODO: implement
        Node node = head.next;
        int i = 1;
        while (node != null) {
            if (i == index){
                return node;
            }
            i ++;
            node = node.next;
        }
        return null;
    }

    /**
     * Determine if the list empty
     * @return true if the list is empty, else false
     * TODO: javadoc comments
     */
    @Override
    public boolean isEmpty() {
        // TODO: implement isEmpty
        if (nelems == 0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove the element from position index in the list
     * @param index the position of the element to be removed
     * @throws IndexOutOfBoundsException if index is outside the range [0, size - 1]
     * @return data value of generic type which is the data of the node being removed
     * TODO: javadoc comments
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if ((index < 0) || (index > nelems - 1)) {
            throw new IndexOutOfBoundsException("index is outside the range [0, size - 1]");
        }
        if (nelems <= 0){
            throw new IndexOutOfBoundsException("cannot remove from empty list");
        }
        Node node = head.next;
        if (index == 0) {
            T val;
            val = head.next.data;
            node.remove();
            //Node sucNode = node.next;
            //sucNode.prev = head;
            //head.next = sucNode;
            nelems --;
            return val;
        } else {
            int i = 1;
            node = head.next.next;
            while (node != null) {
                if (i == index) {
                    T val;
                    val = node.data;
                    //Node sucNode = node.next;
                    //Node prevNode = node.prev;
                    //sucNode.prev = prevNode;
                    //prevNode.next = sucNode;
                    node.remove();
                    nelems --;
                    return val;
                }
                node = node.next;
                i ++;
            }
        }
        // TODO: Fill in implementation
        return null;
    }

    /**
     * Set the value of an element at a certain index in the list.
     * @param index the position of the element's that's data is to be altered
     * @param element new data to alter old data
     * @throws IndexOutOfBoundsException if index is outside the range [0, size-1]
     * @throws NullPointerException if data received is null
     * @return original data value of the node who's element's was changed.
     * TODO: javadoc comments
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if ((index < 0) || (index > nelems - 1)) {
            throw new IndexOutOfBoundsException(" index is outside the range [0, size - 1]");
        }
        if (element == null) {
            throw new NullPointerException("data received is null");
        }
        Node node = head.next;
        int ind = 0;
        while (node != null) {
            if (ind == index) {
                T val = node.data;
                node.setElement(element);
                return val;
            }
            ind ++;
            node = node.next;

        }
        // TODO: Fill in implmentation
        return null;
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     * @return number of elements in list
     * TODO: javadoc comments
     */
    @Override
    public int size() {
        // TODO: complete implementation
        return nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     * @return a String that shows the list and elements are represented in String format
     * TODO: javadoc comments
     */
    @Override
    public String toString() {
        if ((head.next == null) && (tail.prev == null)) {
            return "[(head) -> (tail)]";
        }
        StringBuilder result = new StringBuilder("[(head) -> ");
        Node node = head.next;
        while (node != null) {
            if (node.next == null) {
                result.append("(tail)]");
            } else {
                String elem = String.valueOf(node.data);
                result.append(elem).append(" -> ");

            }
            node = node.next;
        }
        return result.toString();
    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * Remove nodes whose index is a multiple of base
     * @param base is an integer where elements in the list that are multiples of base are removed
     * @throws IllegalArgumentException
     * TODO: javadoc comments
     */
    public void removeMultipleOf(int base) throws IllegalArgumentException{
        // TODO: complete implementation
        if (base < 1) {
            throw new IllegalArgumentException("base is less than 1");
        }
        Node node = head.next;
        int count = 0;
        while (node != null && node.data != null) {
            //int val = (int) node.data;
            if (count % base == 0) {
                Node sucNode = node.getNext();
                Node prevNode = node.getPrev();
                sucNode.setPrev(prevNode);
                prevNode.setNext(sucNode);
                nelems --;
            }
            count ++;
            node = node.next;
        }
    }

    /**
     * Swap the nodes between index [0, splitIndex] of two lists
     * @param other is another linked list who's segement will be swapped.
     * @param splitIndex is the index up to where the two linked lists will be swapped.
     * TODO: javadoc comments
     */
    public void swapSegment(DoublyLinkedList<T> other, int splitIndex) {
        // TODO: complete implementation
        Node node1 = head.next;
        Node node2 = other.head.next;

        int ind = 0;
        DoublyLinkedList<Object> copy = new DoublyLinkedList<>();
        DoublyLinkedList<Object> temp1 = new DoublyLinkedList<>();
        DoublyLinkedList<Object> temp2 = new DoublyLinkedList<>();
        while (ind <= splitIndex) {
            temp1.add(node1.data);
            temp2.add(node2.data);
            Node node1temp = node1.next;
            Node node2temp = node2.next;
            node1.remove();
            node2.remove();
            nelems --;
            other.nelems --;
            /*
            Node sucNode = node1.getNext();
            Node prevNode = node1.getPrev();
            sucNode.setPrev(prevNode);
            prevNode.setNext(sucNode);
            Node sucNode2 = node2.getNext();
            Node prevNode2 = node2.getPrev();
            sucNode2.setPrev(prevNode2);
            prevNode2.setNext(sucNode2);
            */
            node1 = node1temp;
            node2 = node2temp;
            ind ++;
        }
        while (!temp1.isEmpty()) {
            T val1 = (T) temp1.remove(temp1.size()-1);
            other.add(0, val1);
            T val2 = (T) temp2.remove(temp2.size()-1);
            add(0, val2);
        }



    }

}
