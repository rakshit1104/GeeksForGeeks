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
            String ans = obj.preToPost(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String preToPost(String str) {
        // code here
        Stack<String> stack = new Stack<>();
        int n= str.length();
        
        for(int i=n-1; i>=0; i--) {
            char c = str.charAt(i);
            if(!Character.isLetterOrDigit(c)) {
                String v1 = stack.pop();
                String v2 = stack.pop();
                String temp = v1+v2+c;
                stack.push(temp);
            }else stack.push(Character.toString(c));    //character is operand
        }
        return stack.pop();
    }
}
