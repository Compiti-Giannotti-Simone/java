package it.giannotti;

public class Main {
    public static void main(String[] args) {
        LinkedStack<Integer> stack1 = new LinkedStack<>();
        ResizableStack<Integer> stack2 = new ResizableStack<>();
        LinkedQueue<Integer> queue1 = new LinkedQueue<>();
        ResizableQueue<Integer> queue2 = new ResizableQueue<>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        System.out.println("\n");
        System.out.println(stack1.toString());
        System.out.println(stack1.peek());
        stack1.pop();
        System.out.println(stack1.toString());

        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        System.out.println("\n");
        System.out.println(stack2.toString());
        System.out.println(stack2.peek());
        stack2.pop();
        System.out.println(stack2.toString());

        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        queue1.enqueue(4);
        System.out.println("\n");
        System.out.println(queue1.toString());
        System.out.println(queue1.peek());
        queue1.dequeue();
        System.out.println(queue1.toString());

        queue2.enqueue(1);
        queue2.enqueue(2);
        queue2.enqueue(3);
        queue2.enqueue(4);
        System.out.println("\n");
        System.out.println(queue2.toString());
        System.out.println(queue2.peek());
        queue2.dequeue();
        System.out.println(queue2.toString());
    }
}