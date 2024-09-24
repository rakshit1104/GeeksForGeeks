//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends

class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) {
            return "-1";
        }
        
        Map<Character, Integer> pMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }
        
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int count = 0;
        
        Map<Character, Integer> windowMap = new HashMap<>();
        
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);
            
            if (pMap.containsKey(rightChar) && windowMap.get(rightChar).intValue() <= pMap.get(rightChar).intValue()) {
                count++;
            }
            
            while (count == p.length()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }
                
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                
                if (pMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < pMap.get(leftChar).intValue()) {
                    count--;
                }
                
                left++;
            }
            
            right++;
        }
        
        if (minLength == Integer.MAX_VALUE) {
            return "-1";
        }
        
        return s.substring(minStart, minStart + minLength);
    }
}