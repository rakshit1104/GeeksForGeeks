//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution {
    static String postToInfix(String exp) {
       Stack<String> st = new Stack<>();
        int len = exp.length();
        for (int i = 0; i < len; i++) {
            char ch = exp.charAt(i);
            
            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } else {
                String A = st.pop();
                String B = st.pop();
                String combined = "(" + B + ch + A + ")";
                st.push(combined);
            }
        }
        return st.pop();
    }
}