package homework_4;

public interface Queue<E> {

    void insertLast(E value);

    void insertFirst(E value);

    void contains(E value);

    void removeFirst();

    E getLast();

    E getFirst();

    void removeLast();

    void remove(E value);

    E peekFront();

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();

}
