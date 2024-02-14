//Interpolation Search - O(log(log n))

import java.util.Scanner;

public class InterpolationSearch {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array : ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.print("Enter the element to search :  ");
            int key = sc.nextInt();
            int result = interpolationSearch(arr, key, 0, n - 1);
            if (result != -1)
                System.out.print("Element is found at " + result + " position");
            else
                System.out.print("Element is not found");
        }
    }

    private static int interpolationSearch(int[] arr, int key, int low, int high) {
        int mid;
        if (key < arr[low] || key  > arr[high])
                return -1;
        while(low<=high)
        {        
            mid = low + ((high - low) / (arr[high] - arr[low])) * (key - arr[low]);
        
                if (arr[mid] == key)
                    return mid;
                else if (arr[mid] < key)
                    low = mid + 1;
                else
                    high = mid - 1;
        }
        return -1;
    }

}
