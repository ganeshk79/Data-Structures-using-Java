import java.util.Scanner;

class DNode {
    int data;
    DNode next, prev;

    public DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}

public class DoubleLinkedList {
    DNode head;
    DNode tail;

    public void insert(Scanner sc) {
        System.out.print("Enter the Element to insert : ");
        int data = sc.nextInt();
        DNode newnode = new DNode(data);
        if (head == null) {
            head = newnode;
            tail = head;
        } else {
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

    private void insertAtposition(int pos, DNode newnode) {
        if (pos == 0)
            insertAtBeginning(newnode);
        else {
            DNode temp = head;
            for (int i = 0; i < pos - 1; i++)
                temp = temp.next;
            if (temp.next!= null) {
                newnode.next = temp.next;
                newnode.prev = temp;
                temp.next = newnode;
                newnode.next.prev = newnode;
            } else
                insertAtEnd(newnode);
        }

    }

    private void insertAtEnd(DNode newnode) {
        newnode.prev = tail;
        tail.next = newnode;
        tail = newnode;
    }

    private void insertAtBeginning(DNode newnode) {
        head.prev = newnode;
        newnode.next = head;
        head = newnode;
    }

    public void delete(Scanner sc) {
        if (head == null) {
            System.out.println("List is Empty ");
        } else if (head.next == null)
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

    private void deleteAtPosition(int pos) {
        if (pos == 0)
            deleteAtBeginning();
        else {
            DNode temp = head;
            for (int i = 0; i < pos - 1; i++)
                temp = temp.next;
            System.out.println(temp.next.data + " is deleted.");
            temp.next = temp.next.next;
            if (temp.next != null)
            {
                temp.next.prev = temp;
            }
            else
                tail=temp;
        }
    }

    private void deleteAtEnd() {
        System.out.println(tail.data + " is deleted.");
        tail = tail.prev;
        tail.next = null;
    }

    private void deleteAtBeginning() {
        System.out.println(head.data + " is deleted.");
        head = head.next;
        head.prev = null;
    }

    public void display() {
        DNode temp = head;
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

    public void rdisplay() {
        DNode temp = tail;
        if (temp == null)
            System.out.println("List is Empty ");
        else {
            System.out.println("Displaying the list ");
            while (temp.prev != null) {
                System.out.print(temp.data + "<-");
                temp = temp.prev;
            }
            System.out.println(temp.data + ".");
        }

    }

}

class DRunner {
    public static void main(String args[]) {
        DoubleLinkedList ob = new DoubleLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n********MENU********");
            System.out.println("1.insert \n2.delete \n3.display \n4.Reversedisplay \n5.exit ");
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
                    ob.rdisplay();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid  choose!");
                    break;
            }
        }

    }
}
