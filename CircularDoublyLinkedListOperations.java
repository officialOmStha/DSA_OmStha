import java.util.Scanner;

class CDNode {
    int data;
    CDNode prev, next;

    public CDNode(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

class CircularDoublyLinkedList {
    CDNode head = null;

    // Insert at beginning
    public void insertAtBeginning(int data) {
        CDNode newNode = new CDNode(data);
        if (head == null) {
            newNode.next = newNode.prev = newNode;
            head = newNode;
            return;
        }
        CDNode last = head.prev;
        newNode.next = head;
        newNode.prev = last;
        head.prev = newNode;
        last.next = newNode;
        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data) {
        CDNode newNode = new CDNode(data);
        if (head == null) {
            newNode.next = newNode.prev = newNode;
            head = newNode;
            return;
        }
        CDNode last = head.prev;
        newNode.next = head;
        newNode.prev = last;
        last.next = newNode;
        head.prev = newNode;
    }

    // Insert at position
    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Position must be >= 1.");
            return;
        }
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        CDNode temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
            if (temp == head) {
                System.out.println("Position out of bounds.");
                return;
            }
        }
        CDNode newNode = new CDNode(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Delete from beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        CDNode last = head.prev;
        head = head.next;
        head.prev = last;
        last.next = head;
    }

    // Delete from end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        CDNode last = head.prev;
        CDNode secondLast = last.prev;
        secondLast.next = head;
        head.prev = secondLast;
    }

    // Delete at position
    public void deleteAtPosition(int position) {
        if (head == null || position < 1) {
            System.out.println("Invalid position or list is empty.");
            return;
        }
        if (position == 1) {
            deleteFromBeginning();
            return;
        }
        CDNode temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
            if (temp == head) {
                System.out.println("Position out of bounds.");
                return;
            }
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        CDNode temp = head;
        System.out.print("Forward: ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }

    // Display backward
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        CDNode temp = head.prev;
        System.out.print("Backward: ");
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp.next != head);
        System.out.println("(head)");
    }

    // Search for element
    public void search(int key) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        CDNode temp = head;
        int pos = 1;
        do {
            if (temp.data == key) {
                System.out.println(key + " found at position " + pos);
                return;
            }
            temp = temp.next;
            pos++;
        } while (temp != head);
        System.out.println(key + " not found in the list.");
    }
}

public class CircularDoublyLinkedListOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        int choice, data, position;

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete at Position");
            System.out.println("7. Display Forward");
            System.out.println("8. Display Backward");
            System.out.println("9. Search Element");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertAtBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 3:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    System.out.print("Enter position: ");
                    position = sc.nextInt();
                    list.insertAtPosition(data, position);
                    break;
                case 4:
                    list.deleteFromBeginning();
                    break;
                case 5:
                    list.deleteFromEnd();
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    position = sc.nextInt();
                    list.deleteAtPosition(position);
                    break;
                case 7:
                    list.displayForward();
                    break;
                case 8:
                    list.displayBackward();
                    break;
                case 9:
                    System.out.print("Enter element to search: ");
                    data = sc.nextInt();
                    list.search(data);
                    break;
                case 10:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
