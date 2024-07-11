public class LL {
    public Node head;
    public Node tail;
    public int size;

    public LL() {
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

    public void insertFirst(int value){
        Node newNode=new Node(value);
        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            newNode.next=head;
            head=newNode;
            size++;
        }
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
        Node newNode=new Node(value,temp.next);
        temp.next=newNode;
        size++;
    }

    public void insertLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public Node get(int index){
        Node node=head;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }

    public int deleteFirst(){
        int val=head.value;
        head=head.next;
        if(head==null) tail=null;
        size--;
        return val;
    }

    public int deleteLast(){
        if(size<=1) return deleteFirst();
        Node secondLast=get(size-2);
        int val=tail.value;
        tail=secondLast;
        tail.next=null;
        size--;
        return val;

    }

    public int deleteAtIndex(int index){
        if(index==0){
           return deleteFirst();
        } 
        if(index==size-1){
            return deleteLast();
        }
        Node prev=get(index-1);
        int val=prev.next.value;
        prev.next=prev.next.next;
        size--;
        return val;
    }

    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp=temp.next;
        }
        System.out.print("END");
    }
}
