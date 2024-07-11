public class CLL {
    public Node head;
    public Node tail;
    public int size;

    public CLL() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;  // Make it circular
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;  // Update tail.next to point to new head
        }
        size++;
    }

    public void insertAtIndex(int value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            insertFirst(value);
            return;
        }

        if (index == size) {
            insertLast(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(value, temp.next);
        temp.next = newNode;
        size++;
    }

    public void insertLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;  // Make it circular
        } else {
            tail.next = newNode;
            newNode.next = head;  // Maintain circular nature
            tail = newNode;
        }
        size++;
    }

    public Node get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        int val = head.value;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
        return val;
    }

    public int deleteLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        if (size == 1) {
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        secondLast.next = head;
        tail = secondLast;
        size--;
        return val;
    }

    public int deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            return deleteFirst();
        }

        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }


    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }
}
