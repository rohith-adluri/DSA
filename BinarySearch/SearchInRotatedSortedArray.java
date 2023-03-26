package BinarySearch;

/***
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 */

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[]nums = {4,5,6,7,0,1,2};
        int target = 7;
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        System.out.println(obj.search(nums,target));
    }
    int search(int[]nums, int target) {
        int s = nums.length;

        if(s==1) { // corner case
            if(nums[0]==target)
                return 0;
            return -1;
        }

        if(nums[0]<nums[s-1])  //case when nums is already sorted.
            return bs(nums,0,s-1,target);

        int pivot = -1;

        int l=0,h=s-1;

        while(l<=h) {  //Finding pivot element
            int m = l+(h-l)/2;
            if(nums[m]<nums[(m+1)%s] && nums[m]<nums[(m-1+s)%s]) {
                pivot = m;
                break;
            }
            else if(nums[m]>=nums[0] && nums[m]>=nums[s-1])
                l = (m+1)%s;

            else
                h = (m-1+s)%s;

        }
        if(target >= nums[pivot] && target <= nums[s-1])
            return bs(nums,pivot,s-1,target);

        return bs(nums,0,pivot-1,target);

    }
    int bs(int[] nums,int l,int h,int target) { //Binary Search Function
        while(l<=h) {
            int m = l+(h-l)/2;
            if(nums[m]==target)
                return m;
            else if(target > nums[m])
                l = m+1;
            else
                h = m-1;
        }
        return -1;
    }
}
