// SelectionSort - O(n2)

import java.util.Scanner;

public class SelectionSort {
    
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array :");
            int n = sc.nextInt();
            int arr[] = new int[n];
            System.out.println("Enter the Elemnets:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            selectionSort(arr, n);
            System.out.println("Sorted array is");
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }
    }

    private static void selectionSort(int[] arr, int n) {
        for(int i=0;i<n-1;i++)
        {
            int min=i;
            for(int j=i+1;j<n;j++)
            {
                if(arr[j]<arr[min])
                    min=j;
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }

    }
}
