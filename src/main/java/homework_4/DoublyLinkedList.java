package homework_4;

import java.util.function.Consumer;

public class DoublyLinkedList<E> extends SinglyLinkedList<E> implements LinkedListDoubly<E>, Iterable<E>{

    private Node<E> tail;

    @Override
    public void addFirst(E data) {
        Node<E> first = head;
        if (isEmpty()) {
            super.addFirst(data);
            tail = head;
        } else {
            super.addFirst(data);
            head.prev = tail;
            tail.next = head;
            first.prev = head;
        }
    }

    @Override
    public void removeFirst() {
        super.removeFirst();
        head.prev = tail;
        tail.next = head;
    }

    public void clear() {
        super.clear();
        tail = null;
    }

    @Override
    public void addLast(E data) {
        Node<E> last = tail;
        tail = new Node<>(data, head, tail);
        if (isEmpty()) {
            head = tail;
        } else {
            last.next = tail;
            head.prev = tail;
        }
        size++;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Удалять нечего -> MyLinkedListDubl[ ] пуст.");
            return;
        }
        if (head == tail) {
            clear();
            return;
        } else {
            tail = tail.prev;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public E getLast() {
        return  tail.data;
    }

    @Override
    public String toString() {
        Node<E> node = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        if (!isEmpty()) {
            while (node != tail) {
                sb.append(node.data).append(" <-> ");
                node = node.next;
            }
            sb.append(node.data);
        }
        sb.append(" ] - DoublyLinkedList содержит ").append(size).append(" элементов.\n");

        return sb.toString();
    }

    public void addIndex(int index, E data) {
        if (index <= 0) {
            addFirst(data);
            return;
        }
        if (index >= size) {
            addLast(data);
            return;
        }
        Node<E> find = head;
        int c = 0;
        while (c != index) {
            find = find.next;
            c++;
        }

        Node<E> node = new Node<>(data, find, find.prev);

        find.prev.next = node;
        find.prev = node;

        size++;
    }

    public void removeIndex(int index) {
        if (isEmpty()) {
            System.out.println("Удалять нечего -> MyLinkedListDubl[ ] пуст.");
            return;
        }
        if (index <= 0) {
            if (index < 0) {
                System.out.println("Индекс не может быть отрицательным удалён элемент с индексом -> 0");
            }
            removeFirst();
            return;
        }
        if (index >= size - 1) {
            if (index > size - 1) {
                System.out.println("Максимальный индекс для вашего myLinkedListDubl -> " + (size - 1) +
                        ".\nУдалён элемент с индексом -> " + (size - 1));
            }
            removeLast();
            return;
        }

        Node<E> find = head;
        int c = 0;
        while (c != index) {
            find = find.next;
            c++;
        }

        find.next.prev = find.prev;
        find.prev.next = find.next;

        size--;
    }

    public void setIndex(int index, E _data) {
        Node<E> find = head;
        int c = 0;
        if (index >= c && index < size - 1) {
            while (c != index) {
                find = find.next;
                c++;
            }
        } else if (index >= size - 1) {
            find = tail;
        }
        find.data = _data;
    }

    public E getIndex(int index) {
        Node<E> find = head;
        int c = 0;
        if (index >= c && index < size) {
            while (c != index) {
                find = find.next;
                c++;
            }
        } else if (index >= size) {
            System.out.println("Максимальный индекс для вашего myLinkedListDubl -> " + (size - 1));
            find = tail;
        } else {
            System.out.println("Индекс не может быть отрицательным присвоен индекс -> 0");
        }

        assert find != null;
        return find.data;
    }

    public void indexOf(E key) {
        Node<E> find = head;
        SinglyLinkedList<Integer> myLinkedList = new SinglyLinkedList<>();
        int index = 0;
        while (find != tail) {
            while (!find.data.equals(key)) {
                find = find.next;
                index++;
                if (find == tail) {
                    if (find.data.equals(key)) {
                        myLinkedList.addFirst(index);
                    }
                    System.out.println("Количество совпадений значения - " + key + " -> " + myLinkedList.size() +
                            " по следующим индексам " + myLinkedList);
                    return;
                }
            }
            myLinkedList.addFirst(index);
            find = find.next;
            index++;
            if (find == tail) {
                if (find.data.equals(key)) {
                    myLinkedList.addFirst(index);
                }
                System.out.println("Количество совпадений значения - ( " + key + " ) -> " + myLinkedList.size() +
                        " по следующим индексам" + myLinkedList);
            }
        }
    }

    public void setKeyAll(E key, E key1) {
        Node<E> find = head;
        while (find != tail) {
            while (!find.data.equals(key)) {
                find = find.next;
                if (find == tail) {
                    if (find.data.equals(key)) {
                        find.data = key1;
                    }
                    return;
                }
            }
            find.data = key1;
            find = find.next;

            if (find == tail) {
                if (find.data.equals(key)) {
                    find.data = key1;
                }
            }
        }
    }

    public void removeKeyAll(E key) {
        Node<E> find = head;
        if (head == tail) {
            if (find.data.equals(key)) {
                removeLast();
            }
            return;
        }
        while (true) {
            while (!find.data.equals(key)) {
                find = find.next;
                if (find == tail) {
                    if (find.data.equals(key)) {
                        removeLast();
                    }
                    return;
                }
            }

            if (find == head) {
                removeFirst();
            } else {
                find.prev.next = find.next;
                find.next.prev = find.prev;
                size--;
            }

            find = find.next;

            if (find == tail) {
                if (find.data.equals(key)) {
                    removeLast();
                }
                return;
            }
        }
    }

    @Override
    public MyListIterator<E> iterator() {
        return new MyListIterator<>() {

            Node<E> node = head;
            int index = 0;

            @Override
            public void nextFirst() {
                node = head;
            }

            @Override
            public void nextLast() {
                node = tail;
            }

            @Override
            public boolean hasNext() {
                return node != tail;
            }

            @Override
            public E next() {
                node = node.next;
                index++;
                if (index == size) {
                    index = 0;
                }
                return node.data;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public E previous() {
                node = node.prev;
                index--;
                if (index < 0) {
                    index = size - 1;
                }
                return node.data;
            }

            @Override
            public int nextIndex() {
                index++;
                if (index == size) {
                    index = 0;
                }
                return index;
            }

            @Override
            public int previousIndex() {
                int ind = index - 1;
                if (ind < 0) {
                    ind = size - 1;
                }
                return ind;
            }

            @Override
            public void remove() {
                removeIndex(index);
                index--;
                if (index < 0) {
                    index = size - 1;
                }
            }

            @Override
            public void set(E data) {
                setIndex(index, data);
            }

            @Override
            public void add(E data) {
                addIndex(index, data);
                index++;
                if (index == size) {
                    index = 0;
                }
            }

            @Override
            public String toString() {
                return String.valueOf(node.data);
            }

            @Override
            public void forEachRemaining(Consumer<? super E> action) {
                MyListIterator.super.forEachRemaining(action);
            }
        };
    }
}
