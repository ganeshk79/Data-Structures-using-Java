import java.util.Scanner;
class BinarySearchRec
{
    public static void main(String args[])
    {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the size of the array : ");
            int n = sc.nextInt();
            int[] arr =new int[n];
            System.out.println("Enter the Elements:");
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            System.out.print("Enter the Element to search : ");
            int key = sc.nextInt();
            int result = binarySearchRec(arr,key,0,n-1);
            if(result!=-1)
                System.out.print("Element is found at "+ result +" position.");
            else
                System.out.print("Element is not found");
        }    

    }
    private static int binarySearchRec(int[] arr, int key,int low ,int high)
    {
        int mid=(low+high)/2;
        if(low>high)
            return -1;
        else if(arr[mid]==key)
            return mid;
        else if(arr[mid]>key)
            return binarySearchRec(arr,key,low,mid-1);
        else 
            return binarySearchRec(arr,key,mid+1,high);

    }
}