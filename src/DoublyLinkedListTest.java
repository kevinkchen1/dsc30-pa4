import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    public DoublyLinkedList<Object> doublyLinkedList;

    @BeforeEach
    public void beforeTests() {
        doublyLinkedList = new DoublyLinkedList<>();
    }

    @Test
    public void addTest() {
        //DoublyLinkedList<Object> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add(5);
        assertTrue(doublyLinkedList.add(10));
        assertEquals(10, doublyLinkedList.tail.prev.data);
        assertEquals(5, doublyLinkedList.head.next.data);
        Assertions.assertThrows(NullPointerException.class,() -> {
            doublyLinkedList.add(null);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> {
            doublyLinkedList.add(3, 1);
        });
        doublyLinkedList.add(1, 20);
        assertEquals(20, doublyLinkedList.head.next.next.data);
        assertEquals(5, doublyLinkedList.head.next.data);
        assertEquals(10, doublyLinkedList.tail.prev.data);

    }

    @Test
    public void clearTest() {
        doublyLinkedList.add(5);
        assertEquals(1, doublyLinkedList.size());
        doublyLinkedList.clear();
        assertTrue(doublyLinkedList.isEmpty());
        assertFalse(!doublyLinkedList.isEmpty());

    }

    @Test
    public void containsTest() {
        doublyLinkedList.add(5);
        doublyLinkedList.add(10);
        assertTrue(doublyLinkedList.contains(5));
        assertTrue(doublyLinkedList.contains(10));
        assertFalse(doublyLinkedList.contains(2));

    }

    @Test
    public void getTest() {
        doublyLinkedList.add(5);
        doublyLinkedList.add(10);
        doublyLinkedList.add(15);

        assertEquals(5, doublyLinkedList.get(0));
        assertEquals(10,doublyLinkedList.get(1));
        assertEquals(15,doublyLinkedList.get(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> {
            doublyLinkedList.get(3);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> {
            doublyLinkedList.get(-1);
        });

    }

    @Test
    public void isEmpty() {
        assertTrue(doublyLinkedList.isEmpty());
        doublyLinkedList.add(5);
        assertFalse(doublyLinkedList.isEmpty());
        doublyLinkedList.remove(0);
        assertFalse(doublyLinkedList.isEmpty()); //

    }

    @Test
    public void removeTest() {
        doublyLinkedList.add(5);
        doublyLinkedList.add(10);
        doublyLinkedList.add(15);
        assertEquals(15, doublyLinkedList.remove(2));
        assertEquals(5, doublyLinkedList.remove(0));
        assertEquals(10, doublyLinkedList.remove(0));
        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> {
            doublyLinkedList.remove(-1);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> {
            doublyLinkedList.add(1);
            doublyLinkedList.remove(1);
        });

    }

    @Test
    public void setTest() {
        doublyLinkedList.add(5);
        doublyLinkedList.add(10);
        doublyLinkedList.add(15);
        doublyLinkedList.set(0, 4);
        assertEquals(4, doublyLinkedList.get(0));
        assertEquals(10, doublyLinkedList.get(1));
        doublyLinkedList.set(1,11);
        assertEquals(11, doublyLinkedList.get(1));
        assertEquals(15, doublyLinkedList.set(2, 12));
        assertEquals(12, doublyLinkedList.get(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> {
            doublyLinkedList.set(-1,8);

        });
        Assertions.assertThrows(IndexOutOfBoundsException.class,() -> {
            doublyLinkedList.set(3,8);
        });
        Assertions.assertThrows(NullPointerException.class,() -> {
            doublyLinkedList.set(0,null);
        });



    }

    @Test
    public void sizeTest() {
        doublyLinkedList.add(5);
        doublyLinkedList.add(10);
        doublyLinkedList.add(15);
        assertEquals(3, doublyLinkedList.size());
        doublyLinkedList.add(3, 20);
        assertEquals(4, doublyLinkedList.size());
        assertEquals(20, doublyLinkedList.tail.prev.data);
    }

    @Test
    public void testToString() {
        doublyLinkedList.add(5);
        doublyLinkedList.add(10);
        doublyLinkedList.add(15);
        DoublyLinkedList<Object> dll = new DoublyLinkedList<>();
        assertEquals("[(head) -> (tail)]", dll.toString());
        assertEquals("[(head) -> 5 -> 10 -> 15 -> (tail)]", doublyLinkedList.toString());
        doublyLinkedList.remove(2);
        assertEquals("[(head) -> 5 -> 10 -> (tail)]", doublyLinkedList.toString());
        doublyLinkedList.remove(0);
        assertEquals("[(head) -> 10 -> (tail)]", doublyLinkedList.toString());
    }

    //@Test
    //public void removeMultipleOfTest() {
    //}

    //@Test
    //public void swapSegmentTest() {
    //}
}