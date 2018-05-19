package Lab7;

import Lab5.Color;
import Lab5.Size;
import Lab5.Toy;
import Lab6.MyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

class MyListTester {
    private static final int LONG_LIST_LENGTH = 10;

    MyList<String> shortList;
    MyList<Integer> emptyList;
    MyList<Integer> longerList;
    MyList<Integer> list;

    @BeforeEach
    public void setUp(){
        shortList = new MyList<>();
        shortList.add("A");
        shortList.add("B");
        emptyList = new MyList<>();
        longerList = new MyList<>();
        for (int i = 0; i < LONG_LIST_LENGTH; i++) {
            longerList.add(i);
        }
        list = new MyList<>();
        list.add(65);
        list.add(21);
        list.add(42);
    }

    /**
     * Test returning the element at the specified position in the list
     */
    @Test
    public void testGet(){
        assertEquals("A", shortList.get(0), "Check first");
        assertEquals("B", shortList.get(1), "Check second");

        for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
            assertEquals((Integer)i, longerList.get(i), "Check " + i + " element");
        }

        assertAll(
                "Get: check out of bounds",
                () -> assertThrows(IndexOutOfBoundsException.class, () -> emptyList.get(0)),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> longerList.get(-1)),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> longerList.get(LONG_LIST_LENGTH))
        );
    }

    /**
     * Test removing an element from the list.
     */
    @Test
    public void testRemove() {
        int a = list.remove(0);
        assertEquals(65, a, "Remove: check a is correct ");
        assertEquals((Integer)21, list.get(0), "Remove: check element 0 is correct ");
        assertEquals(2, list.size(), "Remove: check size is correct ");

        assertAll(
                "Remove: Check out of bounds",
                () -> assertThrows(IndexOutOfBoundsException.class, () -> shortList.remove(-1)),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> shortList.remove(3))
        );

    }

    /** Test the size of the list */
    @Test
    public void testSize()
    {
        assertEquals(3, list.size(), "Size: check list is correct ");
        assertEquals(0, emptyList.size(), "Size: check empty list is correct ");
    }


    /**
     * Test adding an element into the list at a specified index
     */
    @Test
    public void testAddAtIndex()
    {
        assertAll(
                "AddAtIndex: check out of bounds",
                () -> assertThrows(IndexOutOfBoundsException.class, () -> shortList.add(-1, "N")),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> shortList.add(3, "N"))
        );

        list.add(1, 12);
        assertEquals((Integer)65, list.get(0), "AddAtIndex: check first element is correct ");
        assertEquals((Integer)12, list.get(1), "AddAtIndex: check current element is correct ");
        assertEquals((Integer)42, list.get(list.size()-1), "AddAtIndex: check last element is correct ");

        list.add(0, 35);
        assertEquals((Integer)35, list.get(0), "AddAtIndex: check adding to the start");

        shortList.add(shortList.size(), "C");
        assertEquals("C", shortList.get(shortList.size()-1), "AddAtIndex: check adding to the end");
    }


    /**
     * Test setting an element in the list
     */
    @Test
    public void testSet()
    {
        assertEquals((Integer)58, list.set(1, 58), "Set: check a is correct");

        assertAll(
                "Set: check out of bounds",
                () -> assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, 39)),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> shortList.set(3, "C"))
        );
    }

    /**
     * Test checking for empty
     */
    @Test
    public void testIsEmpty(){
        assertAll(
                "IsEmpty: check size",
                () -> assertTrue(emptyList.isEmpty()),
                () -> assertFalse(shortList.isEmpty()),
                () -> shortList.clear(),
                () -> assertTrue(shortList.isEmpty())
        );
    }

    /**
     * Test index of the first occurrence of the element
     */
    @Test
    public void testIndexOf(){
        assertAll(
                "IndexOf: check index of elements",
                () -> assertEquals(1, shortList.indexOf("B")),
                () -> assertFalse(shortList.contains("C")),
                () -> assertEquals(-1, shortList.indexOf("C"))
        );

        list.add(21);
        list.add(79);

        assertEquals(3, list.lastIndexOf(21), "IndexOf: check lastIndexOf");
    }

    /**
     * Test returning an array containing all of the elements in the list
     */
    @Test
    public void testToArray(){
        Object[] temp = list.toArray();
        assertAll(
                "ToArray: check elements order and size of the list",
                () -> assertEquals(list.size(), temp.length),
                () -> assertEquals(list.get(0), temp[0]),
                () -> assertEquals(list.get(1), temp[1])
        );
    }

    /**
     * Test returning a view of the portion of this list between fromIndex and toIndex, exclusive
     */
    @Test
    public void testSubList(){
        assertAll(
                "SubList: check fromIndex and toIndex are correct",
                () -> assertEquals((Integer)3, longerList.subList(2, 6).get(1)),
                () -> assertEquals((Integer)4, longerList.subList(0, 5).get(4))
        );

        assertAll(
                "SubList: check out of bounds",
                () -> assertThrows(IndexOutOfBoundsException.class, ()->longerList.subList(-1, 5)),
                () -> assertThrows(IndexOutOfBoundsException.class, ()->longerList.subList(2, (LONG_LIST_LENGTH + 1))),
                () -> assertThrows(IndexOutOfBoundsException.class, ()->longerList.subList(4, 1))
        );
    }

    /**
     * Test list iterator over the elements in the list
     */
    @Test
    public void testListIterator(){
        ListIterator<String> iterator = shortList.listIterator();
        assertTrue(iterator.hasNext(), "ListIterator: check hasNext");
        assertEquals("A", iterator.next(), "ListIterator: check next");
        iterator.remove();
        assertEquals(null, iterator.previous(), "ListIterator: check remove and previous are correct");
        assertFalse(iterator.hasPrevious(), "ListIterator: check hasPrevious");
        iterator.next();
        assertFalse(iterator.hasNext(), "ListIterator: check hasNext");
        assertEquals(0, iterator.previousIndex(), "ListIterator: check previousIndex");
        iterator.add("C");
        assertEquals("C", iterator.next(), "ListIterator: check next and add are correct");
    }

    /**
     * Test retaining the elements in this list that are contained in the specified collection
     */
    @Test
    public void testRetainAll(){
        MyList<Integer> temp = new MyList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        longerList.retainAll(temp);
        assertAll(
                "RetainAll: check elements order and size of the list",
                () -> assertEquals((Integer)2, longerList.get(1)),
                () -> assertEquals(3, longerList.size())
        );
    }

    /**
     * Test WrongMinAgeException and WrongPrizeException
     */
    @Test
    public void testToyExceptions() {
        assertThrows(WrongMinAgeException.class, () -> new Toy(-2, 5, Size.Small, Color.Blue),
                "TestToyExceptions: check minAge");
        assertThrows(WrongPrizeException.class, () -> new Toy(5, -10, Size.Medium, Color.Red),
                "TestToyExceptions: check prize");
    }
}