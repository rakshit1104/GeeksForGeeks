//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Write your code here
        int n = str.length();
        int number=0,count=0;
        
        for(int i=0; i<n; i++){
            if(number ==0 && str.charAt(i)=='0' && i<n-1 && str.charAt(i+1)!='.')
            {
                return false;
            }
            if(str.charAt(i) == '.' && str.charAt(i+1) == '.'){
                return false;
            }else if(str.charAt(i) == '.'){
                if(number < 0 || number > 255){
                    return false;
                }
                count++;
                number = 0;
            }else{
                int num = ((int)str.charAt(i)-48);
                number = number*10 + num;
            }
        }
        if(number < 0 || number > 255 || count!=3){
            return false;
        }
        return true;
    }
}