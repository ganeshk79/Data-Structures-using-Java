
import java.util.Scanner;
//Fibonnaic search - O(log n)



public class FibonacciSearch {
    public static void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array : ");
            int n =sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.nextInt();
            System.out.print("Enter the element to search : ");
            int key = sc.nextInt();
            int result=fibonacciSearch(arr,key,n);  
            if(result!=-1)
                System.out.print("Element is found at "+result+" position");
            else
                System.out.print("Element is not found");      
        }


    }
    public static int min(int x, int y) 
    { 
        return (x <= y) ? x : y; 
    } 
  
   
    public static int fibonacciSearch(int arr[], int x, 
                                         int n) 
    { 
        /* Initialize fibonacci numbers */
        int fibMMm2 = 0; // (m-2)'th Fibonacci No. 
        int fibMMm1 = 1; // (m-1)'th Fibonacci No. 
        int fibM = fibMMm2 + fibMMm1; // m'th Fibonacci 
  
        while (fibM < n) { 
            fibMMm2 = fibMMm1; 
            fibMMm1 = fibM; 
            fibM = fibMMm2 + fibMMm1; 
        } 
  
     
        int offset = -1; 
  

        while (fibM > 1) { 
            int i = min(offset + fibMMm2, n - 1); 
  
            if (arr[i] < x) { 
                fibM = fibMMm1; 
                fibMMm1 = fibMMm2; 
                fibMMm2 = fibM - fibMMm1; 
                offset = i; 
            } 
  
            
            else if (arr[i] > x) { 
                fibM = fibMMm2; 
                fibMMm1 = fibMMm1 - fibMMm2; 
                fibMMm2 = fibM - fibMMm1; 
            } 
  
            /* element found. return index */
            else
                return i; 
        } 
  
        /* comparing the last element with x */
        if (fibMMm1 == 1 && arr[n-1] == x) 
            return n-1; 
  
        /*element not found. return -1 */
        return -1; 
    } 
  
}
