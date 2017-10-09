public class Demo
{
  public static void main(String[] args)
  {
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
  }
}
