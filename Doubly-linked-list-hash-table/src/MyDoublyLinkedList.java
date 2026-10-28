public class MyDoublyLinkedList {

    // Inner Node class representing each element
    private static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyDoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // Add element to the end
    public void add(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Insert at a specific index
    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        if (index == 0) {
            Node newNode = new Node(value);
            if (isEmpty()) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
            return;
        }

        if (index == size) {
            add(value);
            return;
        }

        Node current = getNodeAt(index);
        Node newNode = new Node(value);

        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    // Remove element at index
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node target = getNodeAt(index);
        int removedValue = target.data;

        if (size == 1) {
            head = tail = null;
        } else if (target == head) {
            head = head.next;
            head.prev = null;
        } else if (target == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }

        size--;
        return removedValue;
    }

    // Get value at index
    public int get(int index) {
        return getNodeAt(index).data;
    }

    // Set value at index
    public void set(int index, int value) {
        getNodeAt(index).data = value;
    }

    // Search for a value, returns index or -1
    public int search(int value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int value) {
        return search(value) != -1;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void displayForward() {
        System.out.print("[");
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }

    public void displayBackward() {
        System.out.print("[");
        Node current = tail;
        while (current != null) {
            System.out.print(current.data);
            if (current.prev != null) {
                System.out.print(", ");
            }
            current = current.prev;
        }
        System.out.println("]");
    }

    // Helper method to traverse to index (searches from head or tail depending on index)
    private Node getNodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}