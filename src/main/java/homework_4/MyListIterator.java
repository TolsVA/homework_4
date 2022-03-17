package homework_4;

import java.util.ListIterator;

public interface MyListIterator<E> extends ListIterator<E> {

    public E nextFirst();

    public E nextLast();

}
