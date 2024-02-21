import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    MyQueue queue1;
    MyQueue queue2;
    MyQueue queue3;
    @BeforeEach
    public void beforeTests(){
        queue1 = new MyQueue();
        queue2 = new MyQueue();
        queue3 = new MyQueue();
    }
    @Test
    public void isEmptyTest() {
        queue2.enqueue('a');
        queue3.enqueue('o');
        queue3.enqueue('m');
        assertTrue(queue1.isEmpty());
        assertFalse(queue2.isEmpty());
        assertFalse(queue3.isEmpty());
    }

    @Test
    public void sizeTest() {
        queue2.enqueue('a');
        queue3.enqueue('o');
        queue3.enqueue('m');
        assertEquals(0, queue1.size());
        assertEquals(1, queue2.size());
        assertEquals(2, queue3.size());
        queue3.dequeue();
        assertEquals(1, queue3.size());
    }

    @Test
    public void enqueueTest() {
        queue2.enqueue('a');
        queue1.enqueue('o');
        queue3.enqueue('m');
        assertEquals(1, queue1.size());
        assertFalse(queue3.isEmpty());
        assertEquals('a', queue2.peek());
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            MyQueue queue4 = new MyQueue();
            queue4.enqueue(null);
        });
    }

    @Test
    public void dequeueTest() {
        assertNull(queue1.dequeue());
        queue2.enqueue('a');
        queue1.enqueue('o');
        queue1.enqueue('l');
        queue3.enqueue('m');
        queue3.enqueue('p');
        //String hi = queue1.toString();
        assertEquals('o', queue1.dequeue());
        assertEquals('l', queue1.dequeue());
        queue2.dequeue();
        queue3.dequeue();
        assertTrue(queue2.isEmpty());
        assertEquals('p', queue3.peek());


    }

    @Test
    public void peekTest() {
        assertNull(queue1.peek());
        queue2.enqueue('a');
        queue1.enqueue('o');
        queue1.enqueue('l');
        queue3.enqueue('m');
        queue3.enqueue('p');
        assertEquals('o', queue1.peek());
        assertEquals('m', queue3.peek());
        assertEquals('a', queue2.peek());
    }
}