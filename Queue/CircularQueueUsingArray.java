
import java.util.Scanner;

public class CircularQueueUsingArray {

    int rear = -1, front =-1 ;
    int capacity;
    int[] queue;
    boolean count=true;
    public CircularQueueUsingArray(int n) {
        this.capacity = n;
        queue = new int[this.capacity];
    }

    public void enqueue(Scanner sc) {
        if((rear==capacity-1 && front==0) || rear+1==front){
            System.out.println("Queue is full .");
            return;
        }
        if(front==-1){
            front++;
            rear++;
        }
        else{
            if(capacity-1==rear)
                rear=0;
            else
                rear++;
        }
        System.out.print("Enter the Element: ");
        int data = sc.nextInt();
        queue[rear] = data;
        
    }

    public void dequeue() {
        if(front==-1){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(queue[front] + " is deleted.");
        if(front== capacity-1 && rear<front )
            front=0;
        else if(rear==front){
            rear=-1;
            front=-1;
        } 
        else
            front++;   
    }

    public void display() {
        if (rear == -1)
            System.out.println("Queue is underflow.");
        else {
            if(front<=rear){
                for(int i=front;i<=rear;i++)
                System.out.print(queue[i] + " ");
            }
            else{
                for (int i = front; i<capacity; i++)
                    System.out.print(queue[i] + " ");
                for(int i=0;i<=rear;i++)
                    System.out.print(queue[i]+""); 
            }
            
        }
    }

}

class CRunner {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array :");
        int n = sc.nextInt();
        CircularQueueUsingArray ob = new CircularQueueUsingArray(n);
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
                    System.out.println("Invalid!");
                    break;
            }

        }
    }
}
