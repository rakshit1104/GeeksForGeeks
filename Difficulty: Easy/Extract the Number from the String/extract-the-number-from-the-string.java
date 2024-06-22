//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        // code here
        String s[] = sentence.split(" ");
        long ans = Long.MIN_VALUE;
        
        for(int i = 0;i<s.length;i++){
            if(Character.isDigit(s[i].charAt(0))){
                String str = s[i];
                if(!str.contains("9")){
                    // System.out.println(str);
                    long temp = Long.parseLong(str);
                    ans = Math.max(ans,temp);
                }
            }
        }
        
        return (ans == Long.MIN_VALUE)?-1:ans;
    }
}