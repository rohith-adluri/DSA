package BinarySearch;

public class FirstOneInBinarySortedArray {
    public static void main(String[] args) {
        int[]a={0,0,0,0,0,0,1,1,1,1,1,1,1};
        int n = a.length;
        System.out.println(firstIndex(a,n));
    }
    static int firstIndex(int a[], int n)
    {
        int start =0;
        int end= n-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if (a[mid]==1)
            {
                if (a[mid-1]==1)
                {
                    end=mid-1;
                }
                else
                    return mid;
            }
            else {
                start=mid+1;
            }
        } // close of while loop
        return -1;
    }
}
