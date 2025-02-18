package csc223.aa;

public class SortedLinkedList extends DoublyLinkedList{

    public SortedLinkedList(){
        super();
    }

    @Override
    public void insert(char item) {
        Node newNode = new Node(item);
        Node current = super.head.next;

        if (current == super.tail) {
            super.head.next = newNode;
            newNode.prev = super.head;
            newNode.next = super.tail;
            super.tail.prev = newNode;
            super.sz++;
            return;
        }

        if (item < current.data) {
            newNode.next = current;
            current.prev = newNode;
            super.head.next = newNode;
            newNode.prev = super.head;
            super.sz++;
            return;
        }

        while (current != super.tail && current.data <= item) {
            current = current.next;
        }

        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;

        super.sz++;
    }


    @Override
    public void remove(char item){
        Node current = this.head;

        while (current != null && current.data != item){
            current = current.next;
        }

        if (current != null){
            if (current.prev != null){
                current.prev.next = current.next;  
            }

            if (current.next != null){
                current.next.prev = current.prev;  
            }

            if (current == this.head){
                this.head = current.next;  
            }
            super.sz--;  
        }
    }

    @Override
    public char getFirst(){
        return (super.getFirst());
    }

    @Override
    public char getLast(){
        return(super.getLast());
    }

    @Override
    public char get(int index){
        return(super.get(index));
    }

    @Override
    public int size(){
        return super.sz;
    }

    @Override
    public boolean isEmpty(){
        return(super.isEmpty());
    }

    @Override
    public void clear(){
        super.clear();  
    }

    @Override
    public boolean contains(char item){
        return(super.contains(item));
    }

    @Override
    public int indexOf(char item){
        return(super.indexOf(item));
    }

    @Override
    public int lastIndexOf(char item){
        return(super.lastIndexOf(item));
    }

    @Override
    public void reverse(){
        System.out.println("Cannot reverse sorted list");
    }

    @Override
    public String toString(){
        return(super.toString());
    }
}
