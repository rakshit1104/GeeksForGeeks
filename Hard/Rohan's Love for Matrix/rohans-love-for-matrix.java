//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.firstElement(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int mod = 1000000007;
    static int firstElement(int n) {
        // code here
        int dp[] = new int[n + 1];
        dp[0] = 0 ; dp[1] = 1;
        for(int i = 2; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
            
        return dp[n];
    }
}