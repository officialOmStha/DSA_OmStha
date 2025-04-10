import java.util.Scanner;

// Node class
class StackNode {
    int data;
    StackNode next;

    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Stack class using Linked List
class LinkedStack {
    private StackNode top;

    // Push operation
    public void push(int data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
        System.out.println(data + " pushed to stack.");
    }

    // Pop operation
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow (empty).");
            return;
        }
        System.out.println(top.data + " popped from stack.");
        top = top.next;
    }

    // Peek operation
    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Top element is: " + top.data);
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements (top to bottom): ");
        StackNode temp = top;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

// Main class for menu-driven interaction
public class StackLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedStack stack = new LinkedStack();
        int choice, value;

        while (true) {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    value = sc.nextInt();
                    stack.push(value);
                    stack.display();
                    break;
                case 2:
                    stack.pop();
                    stack.display();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
