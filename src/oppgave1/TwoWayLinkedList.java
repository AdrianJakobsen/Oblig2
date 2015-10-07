package oppgave1;

import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class TwoWayLinkedList<E> extends AbstractSequentialList<E> {
    private Node<E> head, tail;

    private int size;

    public TwoWayLinkedList() {

        size = 0;
    }

    public TwoWayLinkedList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            addLast(objects[i]);
        }
    }

    public E getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head.previous = newNode; // set the previous to the second element
        head = newNode; // head points to the new node
        size++; // Increase list size
        if (tail == null) // the new node is the only node in list
            tail = head;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e); // Create a new for element e

        if (tail == null) {
            head = tail = newNode; // The new node with the last node
            tail.next = newNode; // Link the new is the only node in list
            tail.previous = head;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode; // tail now points to the last node
            tail.next = tail;
        }

        size++; // Increase size
    }


    @Override
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).previous = current;
            (current.next).next = temp;
            ((current.next).next).previous = current.next;
            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;

            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }

            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }
        }

        return result.toString();
    }

    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }


    @Override
    public E get(int index) {

        Node<E> current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }


    @Override
    public E set(int index, E e) {
        if (index <= size) {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            current.element = e;
        }
        return null;
    }

    @Override
    public java.util.Iterator<E> iterator() {

        return new LinkedListIterator();
    }

    @Override
    public int size() {

        return size;
    }


    @Override
    public ListIterator<E> listIterator(int index) {

        return null;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("Index: " + index + ", Size: " + size);
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E element) {
            this.element = element;
        }
    }

    private class LinkedListIterator<E> implements java.util.ListIterator<E> {
        private Node<E> current = (Node<E>) head; // Current index
        int index = 0;

        public LinkedListIterator() {
        }

        public LinkedListIterator(int index) {
            if (index < 0 || index > size)
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
                        + size);
            for (int nextIndex = 0; nextIndex < index; nextIndex++)
                current = current.next;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        public void remove() {
            System.out.println("Not implemented");
        }

        public void add(E e) {
            System.out.println("Not implemented");
        }

        public boolean hasPrevious() {
            return current != head;
        }

        public int nextIndex() {
            System.out.println("Not implemented");
            return 0;
        }

        public E previous() {
            E e = current.element;
            current = current.previous;
            return e;
        }

        public int previousIndex() {
            System.out.println("Not implemented");
            return 0;
        }

        @Override
        public void set(E e) {
            current.element = e; // TODO Auto-generated method stub
        }
    }

}