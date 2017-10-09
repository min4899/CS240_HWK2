public class Demo
{
  public static void main(String[] args)
  {
    /*
    System.out.println("TESTING CIRCULAR ARRAY");
    CircularArray queue1 = new CircularArray();
    System.out.println("Created new queue 1 Circular Array");
    System.out.println("Adding items");
    queue1.enqueue('a');
    queue1.enqueue('b');
    queue1.enqueue('c');
    queue1.enqueue('d');
    queue1.enqueue('e');
    queue1.enqueue('f');
    queue1.enqueue('g');
    queue1.enqueue('h');
    queue1.enqueue('i');
    queue1.enqueue('j');
    System.out.println("Added 10 items");
    System.out.println(queue1.toString());

    System.out.println("Attempting to add 1 more");
    queue1.enqueue("extra");

    System.out.println("Deleting first 5 items");
    queue1.dequeue();
    queue1.dequeue();
    queue1.dequeue();
    queue1.dequeue();
    queue1.dequeue();
    System.out.println(queue1.toString());

    System.out.println("Adding 2 items");
    queue1.enqueue("hello");
    queue1.enqueue("there");
    System.out.println(queue1.toString());

    System.out.println(queue1.getFront());

    queue1.clear();
    System.out.println(queue1.toString());
    queue1.dequeue();
    */

    /*
    System.out.println("TESTING SINGLE LINKED DATA");
    SingleLinkedData queue2 = new SingleLinkedData();
    System.out.println("Created new queue 2 SingleLinkedData");

    System.out.println("Adding items");
    queue2.enqueue('a');
    queue2.enqueue('b');
    queue2.enqueue('c');
    queue2.enqueue('d');
    queue2.enqueue('e');
    System.out.println("Added 5 items");
    queue2.toArray();

    System.out.println(queue2.getFront());

    System.out.println("Removing first in queue: " + queue2.dequeue());
    System.out.println("New first item in list is: " +queue2.getFront());
    System.out.println("Removing first in queue: " + queue2.dequeue());
    System.out.println("New first item in list is: " +queue2.getFront());
    System.out.println("Removing first in queue: " + queue2.dequeue());
    System.out.println("New first item in list is: " +queue2.getFront());
    System.out.println("Removing first in queue: " + queue2.dequeue());
    System.out.println("New first item in list is: " +queue2.getFront());

    System.out.println("Clearing queue");
    queue2.clear();
    queue2.dequeue();

    queue2.enqueue("hello");
    queue2.enqueue("everyone");
    queue2.enqueue("lol");
    queue2.toArray();
    */

    System.out.println("TESING TWOPARTCIRCLAR QUEUE");
    TwoPartCircular queue3 = new TwoPartCircular();
    System.out.println("Created new queue 3 TwoPartCircular");

    System.out.println("Adding items");
    queue3.enqueue('a');
    queue3.enqueue('b');
    queue3.enqueue('c');
    queue3.enqueue('d');
    System.out.println("Added 4 items");
    System.out.println(queue3.toString());

    System.out.println("Deleting first 2 entries");
    System.out.println("Removed: " + queue3.dequeue());
    System.out.println("Removed: " + queue3.dequeue());
    System.out.println("First Entry: " + queue3.getFront());
    System.out.println(queue3.toString());

    System.out.println("Adding 8 more items");
    queue3.enqueue('e');
    queue3.enqueue('f');
    queue3.enqueue('g');
    queue3.enqueue('h');
    queue3.enqueue('i');
    queue3.enqueue('j');
    queue3.enqueue('k');
    queue3.enqueue('l');
    System.out.println(queue3.toString());

    System.out.println("Attempting to add 1 more");
    queue3.enqueue('m');

    System.out.println("Clearing queue");

    queue3.clear();
    System.out.println("First Entry: " + queue3.getFront());
    System.out.println(queue3.toString());

    System.out.println("Adding: hello, there, good, friend");
    queue3.enqueue("hello");
    queue3.enqueue("there");
    queue3.enqueue("good");
    queue3.enqueue("friend");
    System.out.println("First Entry: " + queue3.getFront());
    System.out.println(queue3.toString());

    System.out.println("Removed: " + queue3.dequeue());
    System.out.println("Adding: not");
    queue3.enqueue("not");
    System.out.println(queue3.toString());
  }
}
