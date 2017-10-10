/**
   A twp part circular linekd data queue that implements QueueInterface.
   @author Minwoo Soh
*/
public final class TwoPartCircular<T> implements QueueInterface<T>
{
  private static final int MAX_CAPACITY = 10;
  private Node free; // Last empty node in the queue.
  private Node back; // Last node in the queue with an item inside it.
  private int numberOfNodes; // Keeps track of amount of nodes made.
  private int numberOfEntries;

  /** Creates a TwoPartCircular queue with 1 empty node. */
  public TwoPartCircular()
  {
    free = new Node(null, null);
    free.next = free; // Empty node that points to itself.
    back = free;
    numberOfNodes = 0;
    numberOfEntries = 0;
  } // end default constructor

  /** Adds a new entry to the back of this queue.
      @param newEntry  An object to be added. */
  public void enqueue(T newEntry)
  {
    if(numberOfEntries >= 10)
    {
      System.out.println("Maximum amount in queue. Cannot add more entries.");
    }
    else if(numberOfNodes == 0)
    {
      // Creating the first node.
      free.data = newEntry;
      Node newNode = new Node(null, free.next); // Create new node.
      free.next = newNode; // Connects new node to chain.
      free = free.next; // Set last empty node as free.
      numberOfNodes++;
      numberOfEntries++;
    }
    else if(numberOfNodes < 10 && back.next == free)
    {
      // Less than maximum amount of nodes.
      free.data = newEntry;
      Node newNode = new Node(null, free.next); // Create new node.
      free.next = newNode; // Connects new node to chain.
      free = free.next; // Set last empty node as free.
      back = back.next; // Set last entry as back.
      numberOfNodes++;
      numberOfEntries++;
    }
    else
    {
      // When maximum amount of nodes are already created or an empty node is available.
      back.next.data = newEntry;
      back = back.next;
      numberOfEntries++;
    } // end if
  } // end enqueue

  /** Removes and returns the entry at the front of this queue.
      @return  The object at the front of the queue.
      @throws  EmptyQueueException if the queue is empty before the operation. */
  public T dequeue()
  {
    T item = null;

    try
    {
      if(isEmpty())
      {
        throw new EmptyQueueException();
      }
      else
      {
        item = free.next.data; // Set return.
        free.next.data = null; // Data of first entry is set to null.
        free = free.next;
        numberOfEntries--;
      } // end if
    } // end try
    catch(EmptyQueueException e)
    {
      System.out.println("Exception thrown: " + e);
    } // end catch

    return item;
  } // end dequeue

  /**  Retrieves the entry at the front of this queue.
      @return  The object at the front of the queue.
      @throws  EmptyQueueException if the queue is empty. */
  public T getFront()
  {
    T item = null;

    try
    {
      if(isEmpty())
      {
        throw new EmptyQueueException();
      }
      else
      {
        item = free.next.data; // Set return.
      } // end if
    } // end try
    catch(EmptyQueueException e)
    {
      System.out.println("Exception thrown: " + e);
    } // end catch

    return item;
  } // end getFront

  /** Detects whether this queue is empty.
      @return  True if the queue is empty, or false otherwise. */
  public boolean isEmpty()
  {
    return numberOfEntries == 0;
  } // end isEmpty

  /** Removes all entries from this queue. */
  public void clear()
  {
    while(!isEmpty())
    {
      dequeue();
    } // end while
  } // end clear

  /** Returns all entries in an organized string.
      @return String of all entries. */
  public String toString()
  {
    String result = "[";

    Node current = new Node(null, null);
    current = free.next;
    for(int i = 0; i < numberOfNodes; i++)
    {
      result += current.data + " "; // Concat next list element.
      current = current.next;
    } // end for

    result += "]";
    return result;
  } // end toString

  /** Private inner class Node */
  private class Node
  {
    private T data;
    private Node next; // Link to next node.
    /** Creates a node that points to null.
        @param dataPortion  The data that will be stored in the node. */
    private Node(T dataPortion)
    {
      this(dataPortion, null);
    } // end constructor

    /** Creates a node that points to another node.
        @param dataPortion  The data that will be stored in the node.
        @param nextNode  The next node that will be referenced. */
    private Node(T dataPortion, Node nextNode)
    {
      data = dataPortion;
      next = nextNode;
    } // end constructor
  } // end of Node
}
