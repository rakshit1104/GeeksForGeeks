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
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        int len = pre_exp.length();
        Stack<String> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            if (!Character.isLetterOrDigit(pre_exp.charAt(i))) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String pu = "(" + operand1 + pre_exp.charAt(i) + operand2 + ")";
                stack.push(pu);
            }
            else{
                stack.push(String.valueOf(pre_exp.charAt(i)));
            }
        }
        String ans = stack.pop();
        return ans;
    }
}