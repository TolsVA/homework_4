package homework_4;

public class SinglyLinkedList<E> implements LinkedList<E> {

    protected int size = 0;
    protected Node<E> head;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(E data) {
        head = new Node<>(data, head);
        size++;
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Удалять нечего -> MyLinkedListDubl[ ] пуст.");
            return;
        }
        if (size == 1) {
            clear();
            return;
        } else {
            head = head.next;
        }
        size--;
    }

    public void clear() {
        head.data = null;
        head = null;
        size = 0;
    }

    @Override
    public E getFirst() {
        return head.data;
    }



    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;

        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.append("]").toString();
    }
}
