//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean sameFreq(String s) {
        // code here
        int[] hash = new int[26];
        int minFreq = s.length();
        boolean flag = false;
        
        for(char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        for(int i=0; i<26; i++) {
            if(hash[i] == 0) continue;
            minFreq = Math.min(minFreq, hash[i]);
        }
        
        for(int i=0; i<26; i++) {
            if(hash[i] == 0 || hash[i] == minFreq) continue;
            if(flag || hash[i]-minFreq > 1) return false;
            flag = true;
        }
        
        return true;
    }
}