package leetcode.algorithms;

import org.junit.Test;

public class ZipZagConversion {
	
	@Test
	public void test(){
		System.out.println(convert("PAYPALISHIRING", 3));
		System.out.println(convert("SOMETHING", 2));
		System.out.println(convert("", 1));
		System.out.println(convert("AB", 1));
	}
	
    public String convert(String s, int numRows) {
    	
        if(numRows==1){
            return s;
        }
        
    	String [] result = new String [numRows];
    	for(int row = 0; row<numRows; row++){
    		result[row] = "";
    	}
    	
    	boolean goingDown = true;
    	for(int i=0, row=0; i<s.length(); i++){

    		if(goingDown){
    			result[row] += String.valueOf(s.charAt(i));
    			row++;
    			if(row==numRows-1){
    				goingDown=false;
    			}
    		}else{
    			result[row] += String.valueOf(s.charAt(i));
    			row--;
    			if(row==0){
    				goingDown=true;
    			}
    		}
    	}
    	
    	String v = "";
    	for(int row = 0; row<numRows; row++){
    		v+=result[row];
    	}    	
		return v;
        
    }

}
