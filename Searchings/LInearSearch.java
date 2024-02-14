// Linear Search - O(n)

import java.util.Scanner;

class LInearSearch
{
    public  static void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array: ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the elements:");
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            System.out.print("Enter the key :  ");
            int key=sc.nextInt();
            int result =LinearSearch(arr,key);
            if(result!=-1)
                System.out.println("Element is found at "+result+" position");
            else
                System.out.println("Element is not found");    
        }
        

    }

    private static int LinearSearch(int[] arr, int key) {
        int n=arr.length;
        if (key < arr[0] || key  > arr[n])
                return -1;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==key)
                return i;
        }
        return -1;
    }
    
}
