package csc223.aa;

public class ArrayQueue implements Queue{
    private int[] list = new int[10];
    private int size = 0;

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.peek());
        System.out.println(queue.size());

        System.out.println(queue.dequeue());
        System.out.println(queue.size());

        System.out.println(queue.dequeue());
        System.out.println(queue.size());

        System.out.println(queue.dequeue());
        System.out.println(queue.size());

        System.out.println(queue.isEmpty());
    }

    @Override
    public void enqueue(int item){
        // Check if the array is full, if full then make new array with bigger capacity
        // if not, just add element

        if (size == list.length){
            int[] newList = new int[list.length + 10];
            System.arraycopy(list, 0, newList, 0, list.length);
            list = newList;
        }
    
        // Add item and increase size
        list[size] = item;
        size++;
    }

    @Override
    public int dequeue(){
        // if empty return a unique number
        if (size == 0) {
            return Integer.MAX_VALUE;
        }
        // save front number and shit values down
        int tempFront = list[0]; 
        for (int i = 1; i < size; i++) {
            list[i - 1] = list[i];
        }
        size--; 
        return tempFront;
    }

    @Override
    public int peek(){
        if (size == 0){
            return Integer.MAX_VALUE;
        }
        //return first number
        return list[0];
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int size(){
        return size;
    }
}
