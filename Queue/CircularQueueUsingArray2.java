import java.util.Scanner;

public class CircularQueueUsingArray2 {

    int rear = -1, front = 0;
    int capacity, size;
    int[] queue;
    boolean count=true;
    public CircularQueueUsingArray2(int n) {
        this.capacity = n;
        queue = new int[capacity];
    }

    public void enqueue(Scanner sc) {
        rear = (rear + 1) % capacity;
        System.out.print("Enter the Element: ");
        int data = sc.nextInt();
        queue[rear] = data;
        size++;
    }

    public void dequeue() {
        if(size==capacity)
                count=false;
        if (rear == -1 || (front == rear + 1 && count))
            System.out.println("Queue is underflow.");
        else {
            System.out.println(queue[front] + " is deleted.");
            front = (front + 1) % capacity;
            size--;
        }
    }

    public void display() {
        if (rear == -1 || front == rear + 1)
            System.out.println("Queue is underflow.");
        else {
            for (int i = 0; (i <size)&& i<capacity; i++)
                System.out.print(queue[(front + i) % capacity] + " ");
            System.out.println(); 
        }
    }

}

class CRunner2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array :");
        int n = sc.nextInt();
        CircularQueueUsingArray2 ob = new CircularQueueUsingArray2(n);
        while (true) {
            System.out.println("\n*** Menu ***");
            System.out.println("1.enqueue \n2.dequeue \n3.Display \n4.Exit");
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
                    System.exit(0);
                    break;
                default:
                    break;
            }

        }
    }
}
