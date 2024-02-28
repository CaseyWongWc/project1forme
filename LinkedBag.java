package project1forme;
//import java.util.Arrays;


public final class LinkedBag<T> implements BagInterface<T>
{
  private Node <T> firstNode;
  private int numberOfEntries;


  public LinkedBag()
  {
    firstNode = null;
    numberOfEntries = 0;
  }

  public int getCurrentSize()
  {
    return numberOfEntries;
  }

  public boolean isEmpty()
  {
   if (numberOfEntries ==0)
    {
        return true;
    }
     else
     {
        return false;
     }
  }
   /** 
     * @return int
     * The methods below get the current size and adds new entries to the bagArray.
     * The remove array function does the opposite and removes an entry by subtracting
     * from the index. Frequecy returns the number of times a certain object has appeared
     * while getindex returns an entry's location.
     */
  @Override
  public boolean add(T newEntry) 
  {
      Node<T> newNode = new Node<>(newEntry); // Create a new node with the new entry
      newNode.setNext(firstNode);
      firstNode = newNode;
      numberOfEntries++;
      return true;
  }


@Override
public T remove() 
{
    T result = null;
    if (firstNode != null) 
    {
        result = firstNode.getData();
        firstNode = firstNode.getNext(); // Remove the first node from the chain
        numberOfEntries--;
    }
    return result;
}

@Override
public boolean remove(T anEntry) 
{
 boolean result = false;
 Node <T> nodeNumber = getRefrenceTo(anEntry);

  if (nodeNumber != null)
  {
    nodeNumber.setData(firstNode.getData());
    firstNode = firstNode.getNext();
    numberOfEntries--;
    result = true;
  }
  return result;
}

private Node <T> getRefrenceTo(T anEntry)
{
    boolean found =false;
    Node <T> currentNode = firstNode;
    while (!found && (currentNode != null))
      {
        if (anEntry.equals(currentNode.getData()))
        {
          found = true;
        }
        else
        {
          currentNode = currentNode.getNext();
        }
      }
    return currentNode;
}


@Override
public void clear() 
{
    while (firstNode != null) 
    {
        Node<T> temp = firstNode;
        firstNode = firstNode.getNext(); // Remove the first node
        temp.setData(null); // Help with garbage collection
        temp.setNext(null);
    }
    numberOfEntries = 0;
}


@Override
public int getFrequencyOf(T anEntry) 
{
    int frequency = 0; 
    Node<T> currentNode = firstNode;

    while (currentNode != null) 
    {
        if (currentNode.getData().equals(anEntry)) 
        {
            frequency++;
        }
        currentNode = currentNode.getNext();
    }
    return frequency;
}

@Override
public boolean contains(T anEntry) 
{
    boolean result = false;
    Node <T> currentNode = firstNode;
    while (currentNode != null) 
    {
        if (currentNode.getData() == anEntry)
        {
            result = true;
        }
        currentNode = currentNode.getNext();
    }
    return result;
}


/** 
 * @return T[]
 * Converts the string to an array.
 */
@Override
public T[] toArray() 
{
    @SuppressWarnings("unchecked")
    T[] result = (T[]) new Object[numberOfEntries];

    int index =0;
    Node <T> currentNode = firstNode;
    while ((index < numberOfEntries) && (currentNode != null))
    {
        result[index] = currentNode.getData();
        index++;
        currentNode = currentNode.getNext();
    }
    return result;
}


/** 
 * @param anotherBag
 * @return BagInterface<T>
 * The union, difference, and intersection perform the same way they did
 * in their individual form. The union combines the arrays while the difference
 * removes duplicates from the chosen array. Intersection locates the first identical
 * entry in an array and returns the entry.
 */
@Override
public BagInterface<T> union(BagInterface<T> anotherBag) 
{
    LinkedBag<T> unionBag = new LinkedBag<>();

    Node<T> currentNode = firstNode;
    while (currentNode != null)
    {
     unionBag.add(currentNode.getData()); 
     currentNode = currentNode.getNext();   
    }

    T[] anotherBagArray = anotherBag.toArray(); // Use toArray() to access elements of anotherBag
    for (T item : anotherBagArray) 
    {
        unionBag.add(item);
    }
    return unionBag;
}

@Override
public BagInterface<T> intersection(BagInterface<T> anotherBag) 
{
    LinkedBag<T> intersectionBag = new LinkedBag<>(); //create the return bag
    T[] temp = this.toArray();
    for (T item: temp)
    {
        if (anotherBag.contains(item) && !intersectionBag.contains(item))
        {
            intersectionBag.add(item);
        }
    } 
    return intersectionBag;
}


@Override
public BagInterface<T> difference(BagInterface<T> anotherBag) {
    LinkedBag <T> diffBag = new LinkedBag<>();
    Node<T> currentNode = firstNode;
    //T item = currentNode.getData();

    while (currentNode != null)
    {

        diffBag.add(currentNode.getData()); 
        currentNode = currentNode.getNext();  
    }


    T [] temp = anotherBag.toArray();
    for (T item : temp)
    {
        if (diffBag.contains(item) && anotherBag.contains(item))
        {
            diffBag.remove(item);
        }
    }

    return diffBag;
}
}