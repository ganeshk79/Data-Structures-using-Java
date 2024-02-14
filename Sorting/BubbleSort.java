// BubbleSort - O(n2)

import java.util.Scanner;

public class BubbleSort {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array : ");
            int n = sc.nextInt();
            int arr[] = new int[n];
            System.out.println("Enter the Elements :");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            bubbleSort(arr);
            System.out.println("---- After Sorting ----");
            for (int i : arr) {
                System.out.print(i + " ");
            }

        }

    }

    private static void bubbleSort(int[] arr) {
         int n=arr.length;
         for(int i=0;i<n-1;i++)
         {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j+1]<arr[j])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
         }
    }

}