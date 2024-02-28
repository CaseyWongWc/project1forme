package project1forme;

public class Node<T>
{
    private T data;
    private Node<T> next;

  public Node(T data) 
    {
        this.data = data;
        next = null;
    }

    public T getData() 
    {
        return data;
    }

    public void setData(T firstNode) 
    {
        firstNode = this.data;
    }

    public Node<T> getNext() 
    {
        return next;
    }

    public void setNext(Node<T> next) 
    {
        this.next = next;
    }


   
    
}
