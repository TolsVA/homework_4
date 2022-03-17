package homework_4;

public class Main {
    public static void main(String[] args) {

        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        testSinglyLinkedList(singlyLinkedList);

        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        testDoublyLinkedList(doublyLinkedList);

        testIterator(doublyLinkedList);

        testIterator2(doublyLinkedList);

        LinkedQueue<Integer> linkedQueue= new LinkedQueue<>();
        testLinkedQueue(linkedQueue);

    }

    private static <E> void testIterator2(DoublyLinkedList<E> doublyLinkedList) {
        System.out.println("testIterator2:");

        StringBuilder s = new StringBuilder("[");

        s.append(doublyLinkedList.getFirst());

        for (E val : doublyLinkedList) {
            s.append(", ").append(val);
        }
        System.out.println(s.append("]"));
    }

    private static <E> void testIterator(DoublyLinkedList<E> doublyLinkedList) {
        System.out.println("testIterator:");

        MyListIterator<E> iterator = doublyLinkedList.iterator();
        int c = 0;
        while (iterator.hasNext()) {
            iterator.next();
            E val = iterator.previous();
            if (val.equals(5)) {
                iterator.remove();
                c++;
            }
            iterator.next();
            if (!iterator.hasNext()) {
                iterator.previous();
                val = iterator.next();
                if (val.equals(5)){
                    iterator.remove();
                    c++;
                }
            }
            if (c >= 3) {
                break;
            }
        }
        doublyLinkedList.display();

        System.out.println(iterator);

        iterator.nextLast();

        System.out.println(iterator);

        System.out.print("Проход в обратную сторону - [" + iterator);
        iterator.previous();
        while (iterator.hasNext()) {
            System.out.print(", " + iterator);
            iterator.previous();
        }
        System.out.print("]");
        System.out.println();

        System.out.println(iterator);

        iterator.nextFirst();

        System.out.println(iterator);

        System.out.print("[" + iterator);
        iterator.forEachRemaining(val -> System.out.print(", " + iterator));
        System.out.print("]\n");

    }


    private static  void testLinkedQueue(LinkedQueue<Integer> linkedQueue) {
        System.out.println("testLinkedQueue:");
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                linkedQueue.insertFirst(i);
            } else {
                linkedQueue.insertLast(i);
            }
        }
        linkedQueue.contains(0);
        linkedQueue.display();

        System.out.println("size = " + linkedQueue.size());



        String s = " -> Удалён первый элемент - " + linkedQueue.getFirst() + " ";
        linkedQueue.removeFirst();
        System.out.println(linkedQueue + s + "\n");

        s = " -> Удалён последний элемент - " + linkedQueue.getLast() + " ";
        linkedQueue.removeLast();
        System.out.println(linkedQueue + s + "\n");

        linkedQueue.insertLast(5);
        linkedQueue.insertFirst(5);
        linkedQueue.display();

        int val = 5;
        linkedQueue.remove(val);
        System.out.print("Удалены элементы по ключу - " + val + " -> ");
        linkedQueue.display();

    }

    private static void testDoublyLinkedList(DoublyLinkedList<Integer> doublyLinkedList) {

        System.out.println("testDoublyLinkedList:");

        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                doublyLinkedList.addFirst(i);
            } else {
                doublyLinkedList.addLast(i);
            }
        }

        doublyLinkedList.display();
        String s = " -> Удалён первый элемент - " + doublyLinkedList.getFirst() + " ";
        doublyLinkedList.removeFirst();
        System.out.println(doublyLinkedList + s + "\n");

        s = " -> Удалён последний элемент - " + doublyLinkedList.getLast() + " ";
        doublyLinkedList.removeLast();
        System.out.println(doublyLinkedList + s + "\n");

        doublyLinkedList.addIndex(0, 5);
        doublyLinkedList.display();

        doublyLinkedList.addIndex(5, 5);
        doublyLinkedList.display();

        doublyLinkedList.setKeyAll(7, 5);
        doublyLinkedList.display();

        doublyLinkedList.addLast(5);
        doublyLinkedList.display();
        doublyLinkedList.indexOf(5);
    }


    private static void testSinglyLinkedList(SinglyLinkedList<Integer> singlyLinkedList) {
        System.out.println("testSinglyLinkedList:");
        for (int i = 0; i < 7; i++) {
            singlyLinkedList.addFirst(i);
        }
        singlyLinkedList.display();
        String s = " -> Удалён первый элемент - " + singlyLinkedList.getFirst() + " ";
        singlyLinkedList.removeFirst();
        System.out.println(singlyLinkedList + s);
        System.out.println();
    }

}
