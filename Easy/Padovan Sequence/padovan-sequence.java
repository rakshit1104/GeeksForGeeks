//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends

class Solution
{
    int mod = 1000000000+7;
    public int padovanSequence(int n){
      int[] arr = new int[n + 3]; 
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
     
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 2]%mod + arr[i - 3]%mod)%mod;
        }
     
    return arr[n];
  }
}