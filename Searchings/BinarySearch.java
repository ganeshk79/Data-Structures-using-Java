
/*Binary Search - O(log n) 
 given array must be sorted */

import java.util.Scanner;

class BinarySearch {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array : ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the Elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.print("Enter the eLement to search :");
            int key = sc.nextInt();
            int result = binarySearch(arr, key, 0, n-1);
            if (result != -1)
                System.out.print("Element is found at " + result + " position");
            else
                System.out.print("Element is not found");
        }
    }

    private static int binarySearch(int[] arr, int key, int low, int high) {
        if (key < arr[low] || key  > arr[high])
                return -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid]< key)
                low=mid+1;
            else if (arr[mid] > key)
                high = mid-1;
            else
                return mid;
        }
        return -1;
    }
}