import java.util.EmptyStackException;

/**
   A fixed size array that implements StackInterface.
   @author Minwoo Soh
*/
public final class FixedSizeArray<T> implements StackInterface<T>
{
  private static final int DEFAULT_CAPACITY = 10;
  private final T[] stack;
  private int numberOfEntries;

  /** Creates an empty array with fixed capacity of 10 */
  public FixedSizeArray()
  {
    @SuppressWarnings("unchecked")
    T[] tempStack = (T[])new Object[DEFAULT_CAPACITY]; // Unchecked cast
    stack = tempStack;
    numberOfEntries = 0;
  } // end default constructor

  /** Adds a new entry to the top of this stack.
      @param newEntry  An object to be added to the stack. */
  public void push(T newEntry)
  {
    if(numberOfEntries < DEFAULT_CAPACITY)
    {
      stack[numberOfEntries] = newEntry;
      numberOfEntries++;
    }
    else
    {
      //Array is full
      System.out.println("Maximum number of entries already stored. " +
                         "Cannot insert new entry.");
    } // end if
  } // end push

  /** Removes and returns this stack's top entry.
      @return  The object at the top of the stack.
      @throws  EmptyStackException if the stack is empty before the operation. */
  public T pop()
  {
    T item = null;

    if(isEmpty())
    {
      throw new EmptyStackException();
    }
    else
    {
      item = stack[numberOfEntries-1]; // Setting item inside temp
      stack[numberOfEntries-1] = null; // Removing item from array
      numberOfEntries--; // Decrement item in stack count
      return item;
    } // end if
  } // end pop

  /** Retrieves this stack's top entry.
      @return  The object at the top of the stack.
      @throws  EmptyStackException if the stack is empty. */
  public T peek()
  {
    T item = null;

    if(isEmpty())
    {
      throw new EmptyStackException();
    }
    else
    {
      item = stack[numberOfEntries-1];
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
} // end of FixedSizeArray
