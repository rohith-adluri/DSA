package BinarySearch;

public class CeilAndFloorOfElement {
    public static void main(String[] args) {
        int[]nums={1,5,7,19,22,83};
        int ceilKey = 18;
        int floorKey = 22;

        System.out.println(findCeil(nums,ceilKey));
        System.out.println(findFloor(nums,floorKey));
    }
    static int findCeil(int[]nums,int x){
        int start=0;
        int end=nums.length-1;
        int res=-1;
        while (start<=end){
            int mid= start+(end-start)/2;
            if(nums[mid]>=x)
            {
                res=nums[mid];
                end= mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return res;
    }
    static int findFloor(int[]nums,int x){
        int start=0;
        int end=nums.length-1;
        int res=-1;
        while (start<=end){
            int mid= start+(end-start)/2;
            if(nums[mid]<=x)
            {
                res=nums[mid];
                start=mid+1;
            }
            else
            {
                end= mid-1;
            }
        }
        return res;
    }
}
