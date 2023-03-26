package BinarySearch;

public class FirstAndLastOccurance {
    public static void main(String[] args) {
        int[]nums={1,2,4,6,6,6,6,6,6,8,11};
        int target = 6;
        firstAndLastOccurance(nums,target);
    }
    private static void firstAndLastOccurance(int[]nums,int target){
        int start=0;
        int first=-1, last=-1;
        int end= nums.length-1;
        while(start <=end)
        {
            int mid = start + (end-start)/2;
            if (target==nums[mid])
            {
                first=mid;
                end=mid-1;

            }
            else if (target < nums[mid])
                end= mid-1;
            else
                start = mid+1;
        }
        start=0;
        end= nums.length-1;
        while (start <= end)
        {
            int mid = start+(end-start)/2;
            if (target== nums[mid])
            {
                last=mid;
                start=mid+1;
            }
            else if (target< nums[mid])
                end= mid-1;
            else
                start = mid+1;
        }
        System.out.println("first "+first);
        System.out.println("last "+last);

    }
}
