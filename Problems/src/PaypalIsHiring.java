import java.util.ArrayList;
import java.util.List;

class PaypalIsHiring {
	
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 4));
	}
	
    public static String convert(String s, int numRows) {
        List<List<Character>> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean dcr = false;
        for(int i=0,j=0; i<s.length() && j<numRows;i++){
            // for(int j=0;j<numRows;j++){
                List<Character> il;
                if(list.size()-1>=j){
                    il = list.get(j);
                } else {
                    il = new ArrayList<>();   
                    list.add(il);
                }
                il.add(s.charAt(i));
            // }
            if(dcr)
            	j--;
            else
            	j++;
            if(j==numRows) {
                j=j-2;
                dcr = true;
            } else if(j==0) {
            	dcr = false;
            }
            	
            
            if(i == s.length())
                break;  
        }
        list.stream().forEach(lc -> lc.forEach(cc->sb.append(cc)));
        return sb.toString();
    }
}