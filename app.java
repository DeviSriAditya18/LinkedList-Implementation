public class app {
    public static void main(String[] args) {
    
        // Linked List Implementation
        System.out.println("Linked List Implementation");
        LL l = new LL();
        l.insertLast(1);
        l.insertLast(2);
        l.insertLast(3);
        l.insertFirst(4);
        l.insertAtIndex(5,3);
        l.display();
        System.out.println();
        System.out.println("Deleted Value:"+l.deleteFirst());
        l.display();
        System.out.println();
        System.out.println("Deleted Value:"+l.deleteLast());
        l.display();
        System.out.println();
        System.out.println("Deleted Value:"+l.deleteAtIndex(2));
        l.display(); 
        System.out.println();
        System.out.println();
    
        // Doubly Linked List Implementation
        System.out.println("Doubly Linked List Implementation");
        DLL dl = new DLL();
        dl.insertFirst(1);
        dl.insertFirst(2);
        dl.insertFirst(3);
        dl.insertFirst(4);
        dl.insertLast(5);
        dl.insertAtIndex(6,2);
        dl.display();
        System.out.println();
        System.out.println("Deleted Value:"+dl.deleteFirst());
        System.out.println("Deleted Value:"+dl.deleteLast());
        System.out.println("Deleted Value:"+dl.deleteAtIndex(2));
        dl.display();
        System.out.println();

        // Cyclic Linked List Implementation
        System.out.println("Cyclic Linked List Implementation");
        CLL cl=new CLL();
        cl.insertFirst(1);
        cl.insertFirst(2);
        cl.insertFirst(3);
        cl.insertFirst(4);
        cl.insertLast(5);
        cl.insertAtIndex(6,2);
        cl.display();
        System.out.println();
        System.out.println("Deleted Value:"+cl.deleteFirst());
        System.out.println("Deleted Value:"+cl.deleteLast());
        System.out.println("Deleted Value:"+cl.deleteAtIndex(2));
        cl.display();
    }
}
