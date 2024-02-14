import java.util.Scanner;

public class QueueUsingArray {
    int rear = -1, front = -1;
    int capacity;
    int[] queue;

    public QueueUsingArray(int n) {
        this.capacity = n;
        queue = new int[capacity];
    }

    public void enqueue(Scanner sc) {
        if (rear == -1) {
            rear++;front++;
            System.out.print("Enter the Element: ");
            int data = sc.nextInt();
            queue[rear] = data;
        } else if ((rear + 1) == capacity) {
            System.out.println("Queue is overflow.");
        } else {
            rear++;
            System.out.print("Enter the Element: ");
            int data = sc.nextInt();
            queue[rear] = data;
        }
    }

    public void dequeue() {
        if (rear == -1 || front == rear + 1)
            System.out.println("Queue is underflow.");
        else {
            System.out.println(queue[front] + " is deleted.");
            front++;
        }
    }

    public void display() {
        if (rear == -1 || front == rear + 1)
            System.out.println("Queue is underflow.");
        else {
            for (int i = rear; i >= front; i--)
                System.out.print(queue[i] + " ");
        }
    }

    public void isEmpty() {
        if (rear == -1 || front == rear + 1)
            System.out.println("Queue is Empty.");
        else {
            System.out.println("Queue is  not Empty.");
        }
    }

}

class Runner {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array :");
        int n = sc.nextInt();
        QueueUsingArray ob = new QueueUsingArray(n);
        while (true) {
            System.out.println("\n*** Menu ***");
            System.out.println("1.enqueue \n2.dequeue \n3.Display \n4.isEmpty \n5.Exit");
            System.out.print("Enter your choose : ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    ob.enqueue(sc);
                    break;
                case 2:
                    ob.dequeue();
                    break;
                case 3:
                    ob.display();
                    break;
                case 4:
                    ob.isEmpty();
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