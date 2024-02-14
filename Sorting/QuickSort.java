// Time Complexity: O(N log N)

import java.util.Scanner;

public class QuickSort {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array : ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the elements :");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            quickSort(arr, 0, n - 1);
            System.out.println("---- After Sorting ----");
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }

    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int k = partition(arr, low, high);
            quickSort(arr, low, k - 1);
            quickSort(arr, k + 1, high);
        }
    }

    private static int partition(int[] arr, int p, int q) {
        int i = p - 1, temp;
        int pivot = arr[q];
        for (int j = p; j < q; j++) {
            if (arr[j] < pivot) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i + 1];
        arr[i + 1] = arr[q];
        arr[q] = temp;
        return i + 1;
    }
}
