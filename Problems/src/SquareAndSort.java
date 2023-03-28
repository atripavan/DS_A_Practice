
public class SquareAndSort {
	public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i<nums.length;i++){
            int sq = nums[i]*nums[i];
            for(int j=0;j<=i;j++){
                if(res[j] > sq ){
                    pushArray(sq, j, res);
                    break;
                } else if(j==i) {
                	res[j] = sq;
                }
            }
        }
        return res;
    }

    void pushArray(int sq, int j, int[] arr){
        for(int i=j;i<arr.length;i++){
            int tmp = arr[i];
            arr[i] = sq;
            sq = tmp;
        }
    }

    
    public static void main(String[] args) {
		SquareAndSort obj = new SquareAndSort();
		int[] res =obj.sortedSquares(new int[] {-5,-1,0,3,4});
		for(int k : res)
			System.out.println(k);
	}
}
