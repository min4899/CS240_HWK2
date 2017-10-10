/**
   A fixed size array using circular array that implements QueueInterface.
   @author Minwoo Soh
*/
public final class CircularArray<T> implements QueueInterface<T>
{
  private static final int DEFAULT_CAPACITY = 10;
  private final T[] queue;
  private int front;
  private int back;
  private int count;

  /** Creates an empty array with fixed capacity of 10. */
  public CircularArray()
  {
    @SuppressWarnings("unchecked")
    T[] tempQueue = (T[])new Object[DEFAULT_CAPACITY]; // Unchecked cast
    queue = tempQueue;
    front = 0;
    back = 0;
    count = 0;
  } // end default contructor

  /** Adds a new entry to the back of this queue.
      @param newEntry  An object to be added. */
  public void enqueue(T newEntry)
  {
    if(isFull())
    {
      //Array is full
      System.out.println("Maximum number of entries already in queue. " +
                         "Cannot insert new entry.");
    }
    else
    {
      queue[back] = newEntry;
      back = (back + 1) % queue.length;
      count++;
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
        item = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        count--;
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
        item = queue[front];
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
    return count == 0;
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

    for(int i = 0; i < queue.length; i++)
    {
      result += queue[i] + " "; // Concat next list element.
    } // end for

    result += "]";
    return result;
  } // end toString

  /** Checks if the array is full or not.
      @return True if array is full. False if array is not full. */
  public boolean isFull()
  {
    boolean result = true;

    // Check if any value inside array is empty/null.
    for(int i = 0; i < queue.length; i++)
    {
      if(queue[i] == null)
      {
        // Array is not full.
        result = false;
      } // end if
    } // end for

    return result;
  } // end isFull
} // end of CircularArray
