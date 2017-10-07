public class Demo
{
  public static void main(String[] args)
  {
    FixedSizeArray stack1 = new FixedSizeArray();
    System.out.println("Created stack 1 FixedArray");

    System.out.println("adding items");
    stack1.push('a');
    stack1.push('b');
    stack1.push('c');
    stack1.push('d');
    stack1.push('e');
    stack1.push('f');
    stack1.push('g');
    stack1.push('h');
    stack1.push('i');
    stack1.push('j');
    System.out.println("added 10 items");

    System.out.println("attemping to add more than 10");
    stack1.push('k');

    System.out.println(stack1.peek());
    stack1.pop();
    System.out.println(stack1.peek());

    stack1.clear();
    //System.out.println(stack1.peek());

    stack1.pop();
  }
}
