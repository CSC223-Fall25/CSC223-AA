package csc223.aa;
public interface Queue{
    void enqueue(int item);
    int dequeue();
    int peek();
    boolean isEmpty();
    int size();
}
