import java.util.Scanner;

class Node {
    int data;
    Node prev;

    Node(int data) {
        this.data = data;
        this.prev = null;
    }
}

public class StackUsingLinkedList {
    Node top;

    public void push(int data) {
        Node newnode = new Node(data);
        if (top == null)
            top = newnode;
        else {
            newnode.prev = top;
            top = newnode;
        }

    }

    public void pop() {
        if (top == null)
            System.out.println("Stack is empty.");
        else {
            System.out.println(top.data + " is popped.");
            top = top.prev;
        }
    }

    public void peek() {
        if (top == null)
            System.out.println("Stack is empty.");
        else {
            System.out.println(top.data + " is peek element.");
        }
    }

    public void display() {
        if (top == null)
            System.out.println("Stack is empty.");
        else {
            Node temp = top;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.prev;
            }
        }
    }

}

class LRunner {

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            StackUsingLinkedList ob = new StackUsingLinkedList();
            while (true) {
                System.out.println("\n*** Menu ***");
                System.out.println("1.Push \n2.Pull \n3.Peek \n4.Display \n5.Exit");
                System.out.print("Enter your choose : ");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        System.out.print("Enter the Element to push :");
                        int data = sc.nextInt();
                        ob.push(data);
                        break;
                    case 2:
                        ob.pop();
                        break;
                    case 3:
                        ob.peek();
                        break;
                    case 4:
                        ob.display();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid!");
                        break;
                }

            }
        }
    }

}
