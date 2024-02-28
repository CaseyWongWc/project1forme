package project1forme;

public class Node2<T> 
{

    T data;
    Node<T> next;

    public Node2(T dataPortion) 
    {
        this(dataPortion, null);
    }

    public Node2(T dataPortion, Node<T> nextNode) 
    {
        data = dataPortion;
        next = nextNode;
    }
}