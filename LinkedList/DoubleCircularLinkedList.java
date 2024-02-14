import java.util.Scanner;

class DCNode {
    int data;
    DCNode next, prev;

    public DCNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoubleCircularLinkedList {
    DCNode head;

    public void insert(Scanner sc) {
        System.out.print("Enter the element to insert : ");
        int data = sc.nextInt();
        DCNode newnode = new DCNode(data);
        if (head == null)
            insertAtBeginning(newnode);
        else {
            System.out.println("--- Position to insert ---");
            System.out.println("1.At begining \n2.At the end \n3.At specific Position ");
            System.out.print("Enter your choose : ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    insertAtBeginning(newnode);
                    break;
                case 2:
                    insertAtEnd(newnode);
                    break;
                case 3:
                    System.out.print("Enter the position : ");
                    int pos = sc.nextInt();
                    insertAtposition(newnode, pos);
                    break;
                default:
                    System.out.println("Invalid Choose");
                    break;
            }
        }

    }

    private void insertAtposition(DCNode newnode, int pos) {
        if (pos == 0)
            insertAtBeginning(newnode);
        else {
            DCNode temp = head;
            for (int i = 0; i < pos - 1; i++)
                temp = temp.next;
            newnode.prev = temp;
            newnode.next = temp.next;
            temp.next.prev = newnode;
            temp.next = newnode;
        }
    }

    private void insertAtEnd(DCNode newnode) {
        if (head == null) {
            head = newnode;
            head.next = head;
        } else {
            DCNode temp = head.prev;
            temp.next = newnode;
            newnode.prev = temp;
            newnode.next = head;
            head.prev = newnode;

        }

    }

    private void insertAtBeginning(DCNode newnode) {
        if (head == null) {
            head = newnode;
            head.next = head;
            head.prev = head;
        } else {
            DCNode temp = head.prev;
            temp.next = newnode;
            head.prev = newnode;
            newnode.next = head;
            newnode.prev = temp;
            head = newnode;
        }

    }

    public void delete(Scanner sc) {
        if (head == null)
            System.out.println("List is Empty");
        else if (head.next == head)
            deleteAtBeginning();
        else {
            System.out.println("--- Position to delete ---");
            System.out.println("1.At begining \n2.At the end \n3.At specific Position ");
            System.out.print("Enter your choose : ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    deleteAtBeginning();
                    break;
                case 2:
                    deleteAtEnd();
                    break;
                case 3:
                    System.out.print("Enter the position : ");
                    int pos = sc.nextInt();
                    deleteAtPosition(pos);
                    break;
                default:
                    System.out.println("Invalid Choose");
                    break;
            }
        }

    }

    private void deleteAtEnd() {
        DCNode temp = head.prev;
        System.out.println(temp.data + " is deleted.");
        head.prev = temp.prev;
        temp.prev.next = head;
        temp.next = null;
        temp.prev = null;
    }

    private void deleteAtPosition(int pos) {
        if (pos == 0)
            deleteAtBeginning();
        else {
            DCNode temp = head;
            for (int i = 0; i < pos - 1; i++)
                temp = temp.next;
            System.out.println(temp.next.data + " is deleted.");
            temp.next = temp.next.next;
            temp.next.prev = temp;
        }

    }

    private void deleteAtBeginning() {
        DCNode temp = head.prev;
        System.out.println(head.data + " is deleted.");
        temp.next = head.next;
        head.next = null;
        head.prev = null;
        head = temp.next;
        head.prev = temp;
    }

    public void display() {
        DCNode temp = head;
        if (head == null)
            System.out.println("List is Empty.");
        else {
            while (temp.next != head) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println(temp.data + ".");
        }
    }

    public void rdisplay() {
        if (head == null)
            System.out.println("List is Empty.");
        else {
            DCNode temp = head.prev;
            while (temp.prev != head.prev) {
                System.out.print(temp.data + "->");
                temp = temp.prev;
            }
            System.out.println(temp.data + ".");
        }
    }
}

class DCRunner {
    public static void main(String args[]) {
        DoubleCircularLinkedList ob = new DoubleCircularLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n**** Menu ****");
            System.out.println("1.insert \n2.delete \n3.display \n4.rdisplay \n5.exit");
            System.out.print("Enter the choose :");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    ob.insert(sc);
                    break;
                case 2:
                    ob.delete(sc);
                    break;
                case 3:
                    ob.display();
                    break;
                case 4:
                    ob.rdisplay();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choose");
                    break;
            }
        }
    }
}
