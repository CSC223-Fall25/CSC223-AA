package csc223.aa;

public class DoublyLinkedList extends SinglyLinkedList{
    public Node tail;
    
    DoublyLinkedList(){
        super();  
        this.tail = new Node('\0'); 
        super.head = new Node('\0');

        super.head.next = this.tail;
        this.tail.prev = super.head;
    }
    
    @Override
    public void insert(char item){
        Node newNode = new Node(item);

        if (super.head.next == this.tail){
            super.head.next = newNode;
            newNode.prev = super.head;
        } 

        else{ 
            this.tail.prev.next = newNode;
            newNode.prev = this.tail.prev;
        }

        newNode.next = this.tail;
        this.tail.prev = newNode;

        super.sz++;
    }

    @Override
    public void remove(char item){
        super.remove(item);
    }    

    @Override
    public char getFirst(){
        return(super.getFirst());
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
        Node current = super.head.next; 
        Node temp = null;

        while (current != null && current != this.tail){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev; 
        }

        if (current != null){
            this.head.next = current; 
        }

        if (this.tail != null && this.tail.prev != null){
            this.tail.prev.next = null; 
            this.tail.prev = current; 
        }
    }

    @Override
    public String toString(){ 
        if (this.head.next == null || this.head.next == this.tail) return "";
    
        String result = "";
        Node current = this.head.next;
    
        // Append first node's data
        result += current.data;
        
        // Traverse the list using a for loop
        for (current = current.next; current != null && current != this.tail; current = current.next) {
            result += " -> " + current.data;
        }
    
        return result;
    }
}
