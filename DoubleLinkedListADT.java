package HW4;

public interface DoubleLinkedListADT<T>  { 
    public void initializeList(); 
    public boolean isEmptyList(); 
    public T front(); 
    public T back(); 
    public int length(); 
    public void print(); 
    public void reversePrint(); 
    public boolean search(T searchItem); 
    public void insertNode(T insertItem); 
    public void deleteNode(T deleteItem); 
    public String toString(); 
    public String recursiveToString(); 
    public String backwardsString(); 
    public String recursiveBackwardsString(); 
    public boolean equals(Object o); 
    public void copy(DoubleLinkedList<T> otherList); 
    public void reversedCopy(DoubleLinkedList<T> otherList); 
}