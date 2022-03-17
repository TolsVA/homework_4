package homework_4;

public class LinkedQueue<E> implements Queue<E> {
    private final DoublyLinkedList<E> data;

    public LinkedQueue() {
        this.data = new DoublyLinkedList<>();
    }

    @Override
    public void insertFirst(E value) {
        data.addFirst(value);
    }

    @Override
    public void contains(E value) {
        data.indexOf(value);
    }

    @Override
    public void insertLast(E value) {
        data.addLast(value);
    }

    @Override
    public void removeFirst() {
        data.removeFirst();
    }

    @Override
    public E getFirst() {
        return data.getFirst();
    }

    @Override
    public void removeLast() {
        data.removeLast();
    }

    @Override
    public E getLast() {
        return data.getLast();
    }

    @Override
    public void remove(E value){
        data.removeKeyAll(value);
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
