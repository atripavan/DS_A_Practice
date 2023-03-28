import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

class HouseRobberDP {
    public static int rob(int[] nums) {
        int sum = 0;
        ArrayList<Integer> cpy = new ArrayList<>(nums.length); 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        HashSet<Integer> dups = new HashSet<>();
        for(int i=0; i<nums.length;i++){

            cpy.add(nums[i]);
            if(map.containsKey(nums[i]))
            	dups.add(nums[i]);
            map.put(nums[i], i);
            
        }

        Collections.sort(cpy, Collections.reverseOrder());
        HashSet<Integer> visited = new HashSet<>(nums.length);
        for(int i : cpy){
            
            if(visited.contains(map.get(i)+1) || 
               visited.contains(map.get(i)-1) )
               continue;
            else{
                sum = sum + i;
                System.out.println(i);
                visited.add(map.get(i));
            }

        }
        
        System.out.println("**Visited**");
        for(int j : visited)
        	System.out.println(j);
        System.out.println("****");

        return sum;
    }
    public static void main(String[] args) {
    	//1,70,250,3,120,140,90,220
		System.out.println(rob(new int[] {1,2,3,1}));
	}
}