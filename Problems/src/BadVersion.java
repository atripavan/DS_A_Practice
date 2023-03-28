/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class BadVersion {
    public int firstBadVersion(int n) {
        return findBadVersion(1,n);
    }

    public int findBadVersion(int s, int l){

        if(s==1 && l==1)
            return 1;

        int mid = (s+l)/2;


        
        if(isBadVersion(mid)){
            if(mid == 1)
                return 1;
            if(!isBadVersion(mid-1))
                return mid;
            else
                return findBadVersion(s, mid-1);
        }else{
            if(isBadVersion(mid+1))
                return mid+1;
            else
                return findBadVersion(mid+1, l);
        }
    }
    
    boolean isBadVersion(int i) {
    	return  i==4 ? true : false;
    }
}