import java.util.Scanner;

// Node class
class QueueNode {
    int data;
    QueueNode next;

    public QueueNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Queue class using Linked List
class LinkedQueue {
    private QueueNode front, rear;

    // Enqueue operation
    public void enqueue(int data) {
        QueueNode newNode = new QueueNode(data);
        if (rear == null) {
            front = rear = newNode;
            System.out.println(data + " enqueued to queue.");
            return;
        }
        rear.next = newNode;
        rear = newNode;
        System.out.println(data + " enqueued to queue.");
    }

    // Dequeue operation
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow (empty).");
            return;
        }
        System.out.println(front.data + " dequeued from queue.");
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    // Peek operation
    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Front element is: " + front.data);
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements (front to rear): ");
        QueueNode temp = front;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

// Main class for menu-driven interaction
public class QueueLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedQueue queue = new LinkedQueue();
        int choice, value;

        while (true) {
            System.out.println("\n--- Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    value = sc.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.peek();
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
