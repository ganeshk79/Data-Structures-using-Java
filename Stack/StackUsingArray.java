import java.util.Scanner;

public class StackUsingArray {
    int[] stack;
    int top = 0, capacity;

    public StackUsingArray(int n) {
        capacity = n;
        stack = new int[n];
    }

    private int size() {
        return top;
    }

    private boolean empty() {
        return top <= 0;
    }

    public void push(Scanner sc) {
        if (size() != capacity) {
            System.out.print("Enter the Element to push :");
            int data = sc.nextInt();
            stack[top] = data;
            top++;
        } else {
            System.out.println("Stack is overflow.");
        }
    }

    public void pop() {
        if (empty()) {
            System.out.println("Stack is underflow.");
        } else {
            top--;
            System.out.println(stack[top] + " is popped.");
        }
    }

    public void display() {
        int temp = size();
        if (empty())
            System.out.println("Stack is Empty.");
        else {
            while (temp > 0) {
                temp--;
                System.out.print(stack[temp] + " ");
            }
            System.out.println();
        }
    }

    public void peek() {
        if (empty()) {
            System.out.println("Stack is Empty.");
        } else {
            System.out.println(stack[top - 1] + " is peek element.");
        }
    }

}

class Runner {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array :");
        int n = sc.nextInt();
        StackUsingArray ob = new StackUsingArray(n);
        while (true) {
            System.out.println("\n*** Menu ***");
            System.out.println("1.Push \n2.Pull \n3.Peek \n4.Display \n5.Exit");
            System.out.print("Enter your choose : ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    ob.push(sc);
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
                    break;
            }

        }
    }

}