import java.util.Arrays;

public class BinarySearch {

	public static int search(int[] nums, int target) {
        return binSearch(0, nums.length-1, target, nums);
    }

    public static int binSearch(int start, int last, int target, int[] nums){
        
        if(last>=nums.length)
            return -1;

        if(start > last)
            return -1;
        
        int mid=(start+last)/2;

        if(target == nums[mid])
            return mid;

        if(target < nums[mid])
            return binSearch(start, mid-1, target, nums);

        if(target > nums[mid])
            return binSearch(mid+1, last, target, nums);

        return -1;
    }

    public static void main(String[] args) {
		int[] arr = {-1,0,5};
		int res = search(arr, 5);
		System.out.println("At location:"+res);
	}
}
