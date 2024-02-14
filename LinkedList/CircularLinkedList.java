import java.util.Scanner;

class CNode {
    int data;
    CNode next;

    public CNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    CNode head;

    public void insert(Scanner sc) {
        System.out.print("Enter the element to insert : ");
        int data = sc.nextInt();
        CNode newnode = new CNode(data);
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

    private void insertAtposition(CNode newnode, int pos) {
        if (pos == 0)
            insertAtBeginning(newnode);
        else {
            CNode temp = head;
            for (int i = 0; i < pos - 1; i++)
                temp = temp.next;
            newnode.next = temp.next;
            temp.next = newnode;
        }
    }

    private void insertAtEnd(CNode newnode) {
        if (head == null) {
            head = newnode;
            head.next = head;
        } else {
            CNode temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newnode;
            newnode.next = head;
        }

    }

    private void insertAtBeginning(CNode newnode) {
        if (head == null) {
            head = newnode;
            head.next = head;
        } else {
            CNode temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newnode;
            newnode.next = head;
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
        CNode temp = head;
        while (temp.next.next != head)
            temp = temp.next;
        System.out.println(temp.next.data + "is deleted.");
        temp.next.next = null;
        temp.next = head;

    }

    private void deleteAtPosition(int pos) {
        if (pos == 0)
            deleteAtBeginning();
        else {
            CNode temp = head;
            for (int i = 0; i < pos - 1; i++)
                temp = temp.next;
            System.out.println(temp.next.data + "is deleted.");
            temp.next = temp.next.next;
        }

    }

    private void deleteAtBeginning() {
        CNode temp = head;
        System.out.println(head.data + " is deleted.");
        while (temp.next != head)
            temp = temp.next;
        temp.next = head.next;
        head.next = null;
        head = temp.next;
    }

    public void display() {
        CNode temp = head;
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

}

class CRunner {
    public static void main(String args[]) {
        CircularLinkedList ob = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n**** Menu ****");
            System.out.println("1.insert \n2.delete \n3.display \n4.exit");
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choose");
                    break;
            }
        }
    }
}
