package BinarySearch;

/**
 * Given a sorted array arr[] of size N, some elements of array are moved to either of the adjacent positions, i.e., arr[i] may be present
 * at arr[i+1] or arr[i-1] i.e. arr[i] can only be swapped with either arr[i+1] or arr[i-1]. The task is to search for an element in
 * this array.
 */
public class AlmostSortedArray {
    public static void main(String[] args) {
        int[]arr = {10, 3, 40, 20, 50, 80, 70};
        int target = 40;
        int n = arr.length;
        int ans = binarySearch(arr,0,n-1,target);
        System.out.println(ans);
    }

    static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at
            // one of the middle 3 positions
            if (arr[mid] == x)
                return mid;
            if (mid > l && arr[mid - 1] == x)
                return (mid - 1);
            if (mid < r && arr[mid + 1] == x)
                return (mid + 1);

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 2, x); // this time check on mid-2 cz mid-1 is already checked

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 2, r, x); // this time check on mid+2 cz mid+1 is already checked
        }
        return -1;
    }
}
