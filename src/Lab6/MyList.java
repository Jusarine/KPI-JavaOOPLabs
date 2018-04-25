package Lab6;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyList<E> implements List<E> {
    LLNode<E> head;
    LLNode<E> tail;
    private int size;

    public MyList() {
        size = 0;
        head = new LLNode<>(null);
        tail = new LLNode<>(null);
        head.next = tail;
        tail.prev = head;
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
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public E next() {
                if (!hasNext()) return null;
                i++;
                return get(i - 1);
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
    public <T> T[] toArray(T[] a) {
        if (a.length < size) a = (T[]) new Object[size];

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
        LLNode<E> elem = new LLNode<>((E) o);
        LLNode<E> curr = head.next;

        for (int i = 0; i < size; i++){
            if (curr.data == elem.data){
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
        return getNode(index).data;
    }

    @Override
    public E set(int index, E element) {
        getNode(index).data = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
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
        LLNode<E> curr = getNode(index);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;

        return curr.data;
    }

    @Override
    public int indexOf(Object o) {
        LLNode<E> curr = head.next;
        LLNode<E> elem = new LLNode<>((E) o);
        for (int i = 0; i < size; i++){
            if (elem.data == curr.data){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int idx = -1;
        LLNode<E> curr = head.next;
        LLNode<E> elem = new LLNode<>((E) o);
        for (int i = 0; i < size; i++){
            if (elem.data == curr.data){
                idx = i;
            }
        }
        return idx;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListIterator<>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public E next() {
                if (!hasNext()) return null;
                i++;
                return get(i - 1);
            }

            @Override
            public boolean hasPrevious() {
                return i != 0;
            }

            @Override
            public E previous() {
                if (!hasPrevious()) return null;
                i--;
                return get(i - 1);

            }

            @Override
            public int nextIndex() {
                return i + 1;
            }

            @Override
            public int previousIndex() {
                return i - 1;
            }

            @Override
            public void remove() {
                LLNode<E> elem = getNode(i);
                elem.prev.next = elem.next;
                elem.next.prev = elem.prev;
                size--;
            }

            @Override
            public void set(E e) {
                LLNode<E> elem = getNode(i);
                elem.data = e;
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

        return new ListIterator<>() {
            int i = index;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public E next() {
                if (!hasNext()) return null;
                i++;
                return get(i - 1);
            }

            @Override
            public boolean hasPrevious() {
                return i != 0;
            }

            @Override
            public E previous() {
                if (!hasPrevious()) return null;
                i--;
                return get(i - 1);

            }

            @Override
            public int nextIndex() {
                return i + 1;
            }

            @Override
            public int previousIndex() {
                return i - 1;
            }

            @Override
            public void remove() {
                LLNode<E> elem = getNode(i);
                elem.prev.next = elem.next;
                elem.next.prev = elem.prev;
                size--;
            }

            @Override
            public void set(E e) {
                LLNode<E> elem = getNode(i);
                elem.data = e;
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
        LLNode<E> curr = getNode(fromIndex);
        List<E> list = new MyList<>();
        list.add(curr.data);
        for (int i = fromIndex; i < toIndex; i++){
            curr = curr.next;
            list.add(curr.data);
        }
        return list;
    }

    private LLNode<E> getNode(int index){
        LLNode<E> curr = head.next;
        for (int i = 0; i < index; i++){
            curr = curr.next;
        }
        return curr;
    }
}

class LLNode<E>{
    LLNode<E> prev;
    LLNode<E> next;
    E data;

    public LLNode(E data){
        this.data = data;
        this.prev = null;
        this.next = null;

    }
}