//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String str1, String str2) {
        // Code here
        int[][] dp = new int[str1.length()][str2.length()];
        for(int [] arr : dp)
            Arrays.fill(arr , -1);
       return solve(0,0,str1,str2,dp);
    }
    public int solve(int i, int j, String str1, String str2, int[][] dp){
        if(i == str1.length() && j == str2.length())
            return 0;
        if(i == str1.length())
            return str2.length() - j;
        if(j == str2.length())
            return str1.length() - i;
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(str1.charAt(i) == str2.charAt(j))
            dp[i][j] =  solve(i+1, j+1 , str1 , str2, dp);
        else
        dp[i][j] =  1 + Math.min(solve(i+1, j+1 , str1 , str2 , dp),Math.min(
            solve(i+1, j , str1 , str2, dp),solve(i, j+1 , str1 , str2,dp)));
        return dp[i][j];
    }
}