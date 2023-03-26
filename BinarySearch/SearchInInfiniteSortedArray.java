package BinarySearch;

public class SearchInInfiniteSortedArray {
    public static void main(String[] args) {
        int[]arr={1,2,4,5,6,8,9,10,12,14,15,18};
        int key = 5;
        System.out.println(findPos(arr,key));
    }

    static int findPos(int arr[], int key) {
        int l = 0, h = 1;
        int val = arr[0];

        while (val < key) {
            l = h;
            h = 2 * h;
            val = arr[h];
        }
        return binarySearch(arr, l, h, key);
    }
    static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
}
