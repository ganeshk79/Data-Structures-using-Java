// TIme Complexity - O(n2)

import java.util.Scanner;

public class InsertionSort {

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array :");
            int n = sc.nextInt();
            int arr[] = new int[n];
            System.out.println("Enter the Elemnets:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            insertionSort(arr, n);
            System.out.println("Sorted array is");
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }
    }

    private static void insertionSort(int[] arr, int n) {
        for (int i = 1; i <n; i++) {
            int j = i - 1;
            int shift = arr[i];
            while ((j >= 0) && shift < arr[j])  {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = shift;
        }
    }

}
