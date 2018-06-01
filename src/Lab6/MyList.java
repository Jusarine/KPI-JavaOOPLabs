package Lab6;

import java.io.Serializable;
import java.util.*;

public class MyList<E> implements List<E>, Serializable {

    /**
     * Pointer to first node.
     */
    private LLNode<E> head;

    /**
     * Pointer to last node.
     */
    private LLNode<E> tail;

    /**
     * The size of this list.
     */
    private int size;

    /**
     * Constructs an empty list.
     */
    public MyList() {
        size = 0;
        head = new LLNode<>(null);
        tail = new LLNode<>(null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Constructs a list containing the element.
     *
     * @param  e the element to be appended to this list
     */
    public MyList(E e){
        this();
        add(e);
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param  c the collection whose elements are to be placed into this list
     */
    public MyList(Collection<? extends E> c){
        this();
        addAll(c);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            int nextIndex = 0;
            LLNode<E> lastReturned = head;

            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                nextIndex++;
                lastReturned = lastReturned.next;
                return lastReturned.data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        LLNode curr = head.next;
        for (int i = 0; i < size; i++) {
            arr[i] = curr.data;
            curr = curr.next;
        }
        return arr;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);

        LLNode curr = head.next;
        for (int i = 0; i < size; i++) {
            a[i] = (T) curr.data;
            curr = curr.next;
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        LLNode<E> curr = new LLNode<>(e);
        curr.next = tail;
        curr.prev = tail.prev;
        tail.prev.next = curr;
        tail.prev = curr;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        LLNode<E> curr = head.next;
        for (int i = 0; i < size; i++){
            if (curr.data.equals(o)){
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E elem: c){
            add(elem);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        for (E elem: c){
            add(index, elem);
            index++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o: c){
            remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        LLNode<E> curr = head;
        boolean change = false;
        int listSize = size;
        for (int i = 0; i < listSize; i++) {
            curr = curr.next;
            if (!c.contains(curr.data)) {
                change = true;
                remove(curr.data);
            }
        }
        return change;
    }

    @Override
    public void clear() {
        size = 0;
        head = new LLNode<>(null);
        tail = new LLNode<>(null);
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return getNode(index).data;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        getNode(index).data = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        LLNode<E> curr = getNode(index);
        LLNode<E> elem = new LLNode<>(element);

        elem.prev = curr.prev;
        curr.prev.next = elem;
        curr.prev = elem;
        elem.next = curr;
        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        LLNode<E> curr = getNode(index);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;

        return curr.data;
    }

    @Override
    public int indexOf(Object o) {
        LLNode<E> curr = head.next;
        for (int i = 0; i < size; i++){
            if (curr.data.equals(o)){
                return i;
            }
            curr = curr.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int idx = -1;
        LLNode<E> curr = tail.prev;
        for (int i = size-1; i >= 0; i--){
            if (curr.data.equals(o)){
                idx = i;
                break;
            }
            curr = curr.prev;
        }
        return idx;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListIterator<>() {
            int nextIndex = 0;
            LLNode<E> lastReturned = head;

            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                nextIndex++;
                lastReturned = lastReturned.next;
                return lastReturned.data;
            }

            @Override
            public boolean hasPrevious() {
                return nextIndex != 0;
            }

            @Override
            public E previous() {
                if (!hasPrevious()) throw new NoSuchElementException();
                nextIndex--;
                lastReturned = lastReturned.prev;
                return lastReturned.data;
            }

            @Override
            public int nextIndex() {
                return nextIndex;
            }

            @Override
            public int previousIndex() {
                return nextIndex - 1;
            }

            @Override
            public void remove() {
                if (lastReturned == null) throw new IllegalStateException();
                lastReturned.prev.next = lastReturned.next;
                lastReturned.next.prev = lastReturned.prev;
                size--;
            }

            @Override
            public void set(E e) {
                if (lastReturned == null) throw new IllegalStateException();
                lastReturned.data = e;
            }

            @Override
            public void add(E e) {
                LLNode<E> elem = new LLNode<>(e);
                elem.next = tail;
                elem.prev = tail.prev;
                tail.prev.next = elem;
                tail.prev = elem;
                size++;
            }
        };
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        return new ListIterator<>() {
            int nextIndex = index;
            LLNode<E> lastReturned = getNode(index - 1);

            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                nextIndex++;
                lastReturned = lastReturned.next;
                return lastReturned.data;
            }

            @Override
            public boolean hasPrevious() {
                return nextIndex != 0;
            }

            @Override
            public E previous() {
                if (!hasPrevious()) throw new NoSuchElementException();
                nextIndex--;
                lastReturned = lastReturned.prev;
                return lastReturned.data;
            }

            @Override
            public int nextIndex() {
                return nextIndex;
            }

            @Override
            public int previousIndex() {
                return nextIndex - 1;
            }

            @Override
            public void remove() {
                if (lastReturned == null) throw new IllegalStateException();
                lastReturned.prev.next = lastReturned.next;
                lastReturned.next.prev = lastReturned.prev;
                size--;
            }

            @Override
            public void set(E e) {
                if (lastReturned == null) throw new IllegalStateException();
                lastReturned.data = e;
            }

            @Override
            public void add(E e) {
                LLNode<E> elem = new LLNode<>(e);
                elem.next = tail;
                elem.prev = tail.prev;
                tail.prev.next = elem;
                tail.prev = elem;
                size++;
            }
        };
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) throw new IndexOutOfBoundsException();

        LLNode<E> curr = getNode(fromIndex);
        List<E> list = new MyList<>();
        list.add(curr.data);
        for (int i = fromIndex; i < toIndex; i++){
            curr = curr.next;
            list.add(curr.data);
        }
        return list;
    }

    /**
     * Returns the node at the specified position in this list.
     *
     * @param index of the node to return
     * @return the node at the specified position in this list
     */
    private LLNode<E> getNode(int index){
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        LLNode<E> curr = head.next;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }
        return curr;
    }
}

class LLNode<E> implements Serializable{
    LLNode<E> prev;
    LLNode<E> next;
    E data;

    public LLNode(E data){
        this.data = data;
        this.prev = null;
        this.next = null;

    }
}