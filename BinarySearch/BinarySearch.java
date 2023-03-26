package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[]nums={1,4,6,7,8,10,14};
        int target = 4;
        System.out.println(binarySearch(nums,target));
    }
    static int binarySearch(int[]nums, int target) {
        int start= 0;
        int end= nums.length-1;
        while (start <= end)
        {
            int mid = start + (end-start)/2;
            if (target==nums[mid])
                return mid;
            else if (target<nums[mid])
                end= mid-1;
            else
                start= mid+1;
        }
        return -1;

    }
}
