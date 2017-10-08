import java.util.EmptyStackException;

/**
   A linked data stack that implements StackInterface.
   @author Minwoo Soh
*/
public final class LinkedData<T> implements StackInterface<T>
{
  private Node previousNode;
  private int numberOfEntries;

  /** Creates an empty LinkedData object with an empty first node. */
  public LinkedData()
  {
    previousNode = null;
    numberOfEntries = 0;
  } // end default constructor

  /** Adds a new entry to the top of this stack.
      @param newEntry  An object to be added to the stack. */
  public void push(T newEntry)
  {
    Node newNode = new Node(newEntry); // Save newEntry as data into new node.
    newNode.prev = previousNode; // Make new node reference.
    previousNode = newNode; // New node is at end of stack.
    numberOfEntries++;
  } // end push

  /** Removes and returns this stack's top entry.
      @return  The object at the top of the stack.
      @throws  EmptyStackException if the stack is empty before the operation. */
  public T pop()
  {
    if(isEmpty())
    {
      throw new EmptyStackException();
    }
    else
    {
      T item = previousNode.data; // Sets item inside temp.
      previousNode = previousNode.prev; // Sets end node as previous node.
      numberOfEntries--;
      return item;
    } // end if
  } // end pop

  /** Retrieves this stack's top entry.
      @return  The object at the top of the stack.
      @throws  EmptyStackException if the stack is empty. */
  public T peek()
  {
    if(isEmpty())
    {
      throw new EmptyStackException();
    }
    else
    {
      T item = previousNode.data;
      return item;
    } // end if
  } // end peek

  /** Detects whether this stack is empty.
      @return  True if the stack is empty. */
  public boolean isEmpty()
  {
    return numberOfEntries == 0;
  } // end isEmpty

  /** Removes all entries from this stack. */
  public void clear()
  {
    while(!isEmpty())
    {
      pop();
    } // end while
  } // end clear

  public T[] toArray()
  {
    @SuppressWarnings("unchecked")
    T[] result = (T[])new Object[numberOfEntries];
    int index = 0;
    Node currentNode = previousNode;
    while((index < numberOfEntries) && (currentNode != null))
    {
      result[index] = currentNode.data;
      index++;
      currentNode = currentNode.prev;
    } // end while

    System.out.println("The added items are:");
    for(int i = 0; i < result.length; i++)
    {
      System.out.println("  " + result[i]);
    }
    return result;
  } // end toArray

  /** Private inner class Node */
  private class Node
  {
    private T data;
    private Node prev; // Link to previous node.
    /** Creates a node that points to null.
        @param dataPortion  The data that will be stored in the node. */
    private Node(T dataPortion)
    {
      this(dataPortion, null);
    } // end constructor

    /** Creates a node that points to another node.
        @param dataPortion  The data that will be stored in the node.
        @param nextNode  The next node that will be referenced. */
    private Node(T dataPortion, Node prevNode)
    {
      data = dataPortion;
      prev = prevNode;
    } // end constructor
  } // end of Node
} // end of LinkedData
