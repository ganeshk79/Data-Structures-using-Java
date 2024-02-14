// Time Complexity: O(N log N)

import java.util.Scanner;

public class MergeSort {
     public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array : ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the elements :");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            merge(arr, 0, n - 1);
            System.out.println("---- After Sorting ----");
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }

    }

    private static void merge(int[] arr, int low, int high) {
        if (low<high) {
            int mid=(low+high)/2;
            merge(arr, low, mid);
            merge(arr, mid+1, high);
            mergeSort(arr,low,mid,high);
            
        }
}

    private static void mergeSort(int[] arr, int low, int mid, int high) {
        int i=low, k=low, j=mid+1;
        int[] barr = new int[high+1];
        while(i<=mid && j<=high)
        {
            if(arr[i]<arr[j])
            {
                barr[k]=arr[i];
                i++;
            }
            else
            {
                barr[k]=arr[j];
                j++;
            }
            k++;
        }
        if(j==high)
        {
            while(i<=mid)
            {
                barr[k]=arr[i];
                i++;k++;
            }
        }
        else if(i==mid);
        {
            while(j<=high)
            {
                barr[k]=arr[j];
                i++;j++;
            }
        }
        for(k=low;k<high;k++)
        {
            arr[k]=barr[k];
        }

    }
}
