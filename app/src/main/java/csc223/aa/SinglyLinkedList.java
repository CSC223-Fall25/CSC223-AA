package csc223.aa;

public class SinglyLinkedList implements LinkedList{
    public Node head;
    public int sz;

    public SinglyLinkedList(){
        // head node does not hold data
        this.head = new Node('0');  
        this.sz = 0;
    }

    @Override
    public void insert(char item){
        Node temp = new Node(item);

        // Traverse to the end
        Node current = this.head;
        while (current.next != null){
            current = current.next;  
        }
         // Append new node at the end
        current.next = temp;

        // Increase size
        sz++;  
    }

   @Override
    public int size(){
        return sz;
    }   

    @Override
    public void remove(char item){
        // Empty list, nothing to remove
        if (this.head == null){
            return;
        }
        
        //If the first actual node contains the item
        if (this.head.next.data == item){
            // Move head's next pointer
            this.head.next = this.head.next.next; 
            sz--;
            return;
        }
    
        //Search for the node before the one to remove
        Node current = this.head.next;
        while (current.next != null && current.next.data != item){
            current = current.next;
        }
    
        //If the item is found, remove the node
        if (current.next != null){
            current.next = current.next.next;
            // Skip the node
            sz--;
        }
    }

    @Override
    public char getFirst(){
        return head.next.data;
    }

    @Override
    public char getLast(){
        // Loop through to reach the last node
        Node current = this.head.next;  
        for (int i = 1; i < sz; i++) {  
            current = current.next;
        }

    return current.data;
    }

    @Override
    public char get(int index){
        // Loop thorugh to reach the index
        Node current = this.head.next; 
        for (int i = 1; i < index; i++){ 
            current = current.next;
        }
        return current.data;
    }

    @Override
    public boolean isEmpty(){
        return sz == 0;
    }

    @Override
    public void clear(){
        head.next = null;
        sz = 0;
    }

    @Override
    public boolean contains(char item){
        // Loop through all nodes and check data in each node
        Node current = this.head.next;  
        for (int i = 0; i < sz; i++){  
            if (current.data == item){
                return true;  
            }
            current = current.next;  
        }
        return false;
    }

    @Override
    public int indexOf(char item){
        // Loop through all nodes and check data in each node
        Node current = this.head.next;  
        for (int i = 0; i < sz; i++){ 
            if (current.data == item){
                return i;
            }
            current = current.next;
        }
        // Return -1 if the item is not found
        return -1;
    }

    @Override
    public int lastIndexOf(char item){
        // Loop through all nodes and check data in each node
        Node current = this.head.next; 
        // Default to -1 if the item is not found
        int lastIndex = -1;  
        for (int i = 0; i < sz; i++) {  
            if (current.data == item) {
                lastIndex = i; 
                }
            current = current.next;
        }   
        return lastIndex;
    }

    @Override
    public void reverse(){
        Node previous = null;  
        Node current = this.head.next; 
        Node nextNode; 
    
        //Loop through and changes pointers
        while (current != null) {
            // Save the next node
            nextNode = current.next;  
            // Reverse the current node's pointer
            current.next = previous;  
            // Move previous to the current node
            previous = current;  
            // Move to the next node
            current = nextNode;  
        }
    
        // Set the head's next to the last node
        this.head.next = previous;  
    }

    @Override
    public String toString(){ 
        // Return empty string for an empty list
        if (this.head.next == null) return ""; 

        String result = "";
        Node current = this.head.next;

        //Loop through and append data with -> inbetween
        while (current != null){
            result += current.data;  
            if (current.next != null){
                result += " -> "; 
            }
            current = current.next;
        }
        return result;
    }
}
