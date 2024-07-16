//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            char ch = sc.next().charAt(0);
            int count = sc.nextInt();
            Solution ob = new Solution();
            String result = ob.printString(s, ch, count);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


class Solution {
    public String printString(String s, char ch, int count) {
        // code here
        int n = s.length();
        int counted = 0;
        int i = -1;
        
        for(i = 0; i<n; i++){
            if(counted == count) break;
            if(s.charAt(i) == ch){
                counted++;
            }
        }
        if((counted == 0) || (i+1 > n)) return "";
        return s.substring(i,n);
    }
}