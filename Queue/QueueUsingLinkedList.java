import java.util.Scanner;

class Node{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}

public class QueueUsingLinkedList {
Node front=null;
Node rear=null;

    public void enqueue(int ele) {
        Node newnode =new Node(ele);
        if(rear==null){
            rear=front=newnode;
        }else{
            rear.next=newnode;
            rear=newnode;
        }
      
    }

    public void dequeue() {
        if(front==null)
            System.out.println("Queue is underflow.");
        else{
            System.out.println(front.data+" is deleted.");
            front=front.next;
        }    
    }

    public void display() {
        if(front==null)
            System.out.println("Queue is underflow.");
        else{
            Node temp;
            for(temp=front;temp.next!=null;temp=temp.next)
                System.out.print(temp.data+"->");
            System.out.print(temp.data+".");    
        }
    }
    
}
class LRunner{
    public static void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in)) {
            QueueUsingLinkedList ob =new QueueUsingLinkedList();
            while(true){
            System.out.println("\n***Menu***");
            System.out.println("1.Enqueue \n2.Dequeue \n3.Display \n4.exit");
            System.out.print("Enter your choose:");
            int ch=sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter the number:");
                    int ele=sc.nextInt();
                    ob.enqueue(ele);
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
                    System.out.println("Invalid! ");
                    break;
            }
            }
        }
    }
}
