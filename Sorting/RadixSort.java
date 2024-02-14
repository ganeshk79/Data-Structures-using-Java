//time complexity of O(d * (n + b)),
// where d is the number of digits, n is the number of elements
//and b is the base of the number system being used.

import java.util.Scanner;

public class RadixSort {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array :");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the Elements :");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            radixSort(arr, n);
            System.out.println("--- After Sorting ---");
            for (int i : arr)
                System.out.print(i + " ");
        }

    }

    private static void radixSort(int[] arr, int n) {
        int bucket[][] = new int[10][10];
        int bc[] = new int[10];
        int i, j, k;
        int rem, div = 1;
        int l = large(arr, n);
        int nopass = noOfDigits(l);
        System.out.println("\nlargest value is "+ l);
        System.out.println("no of pass :"+ nopass);
        for ( int pass = 0; pass < nopass; pass++) {
            for (i = 0; i < 10; i++) {
                bc[i] = 0;
            }
            for (i = 0; i < n; i++) {
                rem = (arr[i] / div) % 10;
                bucket[rem][bc[rem]] = arr[i];
                bc[rem] = bc[rem] + 1;
            }
            i = 0;
            for (k = 0; k < 10; k++) {
                for (j = 0; j < bc[k]; j++) {
                    arr[i] = bucket[k][j];
                    i++;
                }
            }
            div = div * 10;
        }

    }

    private static int noOfDigits(int l) {
        int digit = 0;
        while (l > 0) {
            l /= 10;
            digit++;
        }

        return digit;
    }

    private static int large(int[] arr, int n) {
        int large = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > large)
                large = arr[i];
        }
        return large;
    }
}
