import java.util.Scanner;

class LinearSearchRec {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array : ");
            int n = sc.nextInt();
            System.out.println("Enter the Elements:");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.print("Enter the Element to search : ");
            int key = sc.nextInt();
            int result = linearSearchRec(arr, key, n - 1);
            if(result!=-1)
                System.out.print("Element is found at "+result+" position");
            else
                System.out.print("Element is not found");

        }

    }

    private static int linearSearchRec(int[] arr, int key, int index) {
        if (arr[index] == key)
            return index;
        else if (index != 0)
            return linearSearchRec(arr, key, index - 1);
        else
            return -1;
    }
}