import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

}

public class SingleLinkedList {
    Node head;

    public void insertAtBeginning(Node newnode) {
        Node temp = head;
        if (temp == null)
            head = newnode;
        else {
            newnode.next = head;
            head = newnode;
        }
    }

    public void insertAtEnd(Node newnode) {
        Node temp = head;
        if (temp == null)
            head = newnode;
        else {
            while (temp.next != null)
                temp = temp.next;
            temp.next = newnode;
        }
    }

    public void insertAtposition(int pos, Node newnode) {
        Node temp = head;
        if (pos == 0)
            insertAtBeginning(newnode);
        else {
            for (int i = 0; i < pos - 1; i++) {
                temp = temp.next;
            }
            newnode.next = temp.next;
            temp.next = newnode;
        }
    }

    public void deleteAtBeginning() {
        System.out.println(head.data+" is deleted.");
        head = head.next;
    }

    public void deleteAtEnd() {
        Node temp = head;
        while (temp.next.next != null)
            temp = temp.next;
        System.out.println(temp.next.data+"is deleted.");    
        temp.next = temp.next.next;
    }

    public void deleteAtPosition(int pos) {
        if (pos == 0)
            deleteAtBeginning();
        else {
            Node temp = head;
            for (int i = 0; i < pos - 1; i++)
                temp = temp.next;
            System.out.println(temp.next.data+"is deleted.");        
            temp.next = temp.next.next;
        }

    }

    public void insert(Scanner sc) {
        System.out.print("Enter the Element to insert : ");
        int data = sc.nextInt();
        Node newnode = new Node(data);
        if (head == null)
            head = newnode;
        else {
            System.out.println("\n-- Positions to insert --");
            System.out.println("1.At beginning \n2.At the End \n3.At Specific position");
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
                    System.out.print("Enter the position :");
                    int pos = sc.nextInt();
                    insertAtposition(pos, newnode);
                    break;
                default:
                    System.out.println("Invalid choose!");
                    break;
            }
        }
    }

    public void delete(Scanner sc) {
        if (head == null) {
            System.out.println("List is Empty ");
        } 
        else if(head.next==null)
            deleteAtBeginning();
        else {
            System.out.println("\n-- Position to delete --");
            System.out.println("1.At beginning \n2.At the End \n3.At Specific position ");
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
                    System.out.print("Enter the position :");
                    int pos = sc.nextInt();
                    deleteAtPosition(pos);
                    break;
                default:
                    System.out.println("Invalid Choose!");
                    break;
            }
        }
    }

    public void display() {
        Node temp = head;
        if (temp == null) {
            System.out.println("List is Empty ");
        } else {
            System.out.println("Displaying the list ");
            while (temp.next != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println(temp.data + ".");
        }
    }
}

class Runner {
    public static void main(String args[]) {
        SingleLinkedList ob = new SingleLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n********MENU********");
            System.out.println("1.insert \n2.delete \n3.display \n4.exit ");
            System.out.print("Choose a number : ");
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid  choose!");
                    break;
            }
        }
    }
}
