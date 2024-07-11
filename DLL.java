public class DLL {
    public Node head;
    public Node tail;
    public int size;

    public DLL() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public class Node {
        public int value;
        public Node next;
        public Node prev;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev=null;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev=prev;
        }
    }

    public void insertFirst(int value){
        Node newNode=new Node(value);
        newNode.next=head;
        newNode.prev=null;
        if(head!=null) head.prev=newNode;
        else tail=newNode;
        head=newNode;
        size++;
    }

    public void insertAtIndex(int value,int index){
        Node temp=head;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if(index==0){
            insertFirst(value);
            return;
        } 
        if(index==size){
            insertLast(value);
            return;
        }
        for(int i=1;i<index;i++) temp=temp.next;
        Node newNode=new Node(value,temp.next,temp.prev);
        temp.next=newNode;
        newNode.next=temp.next.next;
        newNode.prev=temp;
        temp.next.next.prev=newNode;
        size++;
    }

    public void insertLast(int value) {
        Node newNode = new Node(value);
        newNode.next=null;
        newNode.prev=tail;
        if(tail!=null) tail.next=newNode;
        else head=newNode;
        tail=newNode;
        size++;
    }

    public Node get(int index){
        Node node=head;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }

    public int deleteFirst() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        int val = head.value;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;  // If the list is now empty
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

        int val = tail.value;
        tail = tail.prev;
        tail.next = null;
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

        Node node = get(index);
        int val = node.value;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return val;
    }

    public void display(){
        Node temp=head;
        Node last=null;
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            last=temp;
            temp=temp.next;
        }
        System.out.println("END");
        System.out.print("Print in Reverse: ");
        while(last!=null){
            System.out.print(last.value+" -> ");
            last=last.prev;
        }
        System.out.println("START");
    }

}
