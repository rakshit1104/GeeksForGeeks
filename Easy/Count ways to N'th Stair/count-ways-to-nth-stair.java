//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking total number of stairs
            int n = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method of class countWays()
            // of class DynamicProgramming
            System.out.println(obj.countWays(n));
        }
    }
}

// } Driver Code Ends

class Solution
{
    //Function to count number of ways to reach the nth stair 
    //when order does not matter.
    Long countWays(int m)
    {
        // your code here
        
        long dp[] = new long[m+2];
        
        dp[0] = 0;
        dp[1] = 1;
        int k = 2;
        for(int i = 2 ; i<=m ; i=i+2){
            
            dp[i] = k;
            dp[i+1] = k;
            k++;
            
        }
        
        return dp[m];
    }    
}