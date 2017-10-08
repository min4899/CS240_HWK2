import java.util.EmptyStackException;
import java.util.Arrays;

/**
   A vector array that implements StackInterface.
   @author Minwoo Soh
*/
public final class Vector<T> implements StackInterface<T>
{
  private static final int DEFAULT_CAPACITY = 5;
  private static final int MAX_CAPACITY = 10000; // To make sure memory doesn't run out.
  private T[] vector;
  private int numberOfEntries;
  private boolean initialized = false;

  /** Creates an empty vector array with the default capacity of 5 */
  public Vector()
  {
    this(DEFAULT_CAPACITY);
  } // end default constructor

  /** Creates an empty vector array with the a given capacity.
	    @param desiredCapacity  The integer capacity desired. */
  public Vector(int desiredCapacity)
  {
    if (desiredCapacity <= MAX_CAPACITY)
    {
       @SuppressWarnings("unchecked")
       T[] tempVector = (T[])new Object[desiredCapacity]; // Unchecked cast
       vector = tempVector;
       numberOfEntries = 0;
       initialized = true;
    }
    else
    {
       throw new IllegalStateException("Cannot create a vector that exceeds " +
                                       "maximum capacity of 10000.");
    } // end if
  } // end contructor

  /** Adds a new entry to the top of this stack.
      @param newEntry  An object to be added to the stack. */
  public void push(T newEntry)
  {
    checkInitialization();
    if(numberOfEntries == vector.length)
    {
      // Vectory array is full.
      increaseCapacity(); // Increases size of vector array before adding.
      vector[numberOfEntries] = newEntry;
      numberOfEntries++;
    }
    else
    {
      // Vector array is not full.
      vector[numberOfEntries] = newEntry;
      numberOfEntries++;
    } // end if
  } // end push

  /** Removes and returns this stack's top entry.
      @return  The object at the top of the stack.
      @throws  EmptyStackException if the stack is empty before the operation. */
  public T pop()
  {
    checkInitialization();

    T item = null;

    if(isEmpty())
    {
      throw new EmptyStackException();
    }
    else
    {
      item = vector[numberOfEntries-1]; // Setting item inside temp.
      vector[numberOfEntries-1] = null; // Removing item from array.
      numberOfEntries--; // Decrement item in stack count.
      return item;
    } // end if
  } // end pop

  /** Retrieves this stack's top entry.
      @return  The object at the top of the stack.
      @throws  EmptyStackException if the stack is empty. */
  public T peek()
  {
    checkInitialization();

    T item = null;

    if(isEmpty())
    {
      throw new EmptyStackException();
    }
    else
    {
      item = vector[numberOfEntries-1];
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

  /** Checks if vector array capacity is too large.
      @param capacity  Capacity number that will be checked.
      @throws  IllegalStateException if the capacity excceds maximum capacity. */
  public void checkCapacity(int capacity)
  {
    if(capacity > MAX_CAPACITY)
    {
      throw new IllegalStateException("Cannot create a vector stack that exceeds" +
                                      "maximum size of " + MAX_CAPACITY);
    }
  } // end checkCapacity

  /** Increases the size of vector array by 1. */
  public void increaseCapacity()
  {
    checkInitialization();
    int newLength = vector.length + 1;
    checkCapacity(newLength);
    vector = Arrays.copyOf(vector, newLength);
  } // end increaseCapacity

  /** Checks if the Vector object is initialized.
      @throws  SecurityException if the object is not initialized. */
  private void checkInitialization()
  {
     if (!initialized)
        throw new SecurityException("Vector object is not initialized properly.");
  } // end checkInitialization
} // end of Vector
