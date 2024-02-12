//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long substrCount (String S, int K) {
        // your code here
        return calcCount(S, K) - calcCount(S, K - 1);
    }
    
    static long calcCount(String s, int k) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int[] charFreq = new int[26];
        int dist_count = 0;
        long ans = 0;

        while (j < n) {
            charFreq[s.charAt(j) - 'a']++;

            if (charFreq[s.charAt(j) - 'a'] == 1) {
                dist_count++;
            }

            while (dist_count > k) {
                charFreq[s.charAt(i) - 'a']--;

                if (charFreq[s.charAt(i) - 'a'] == 0) {
                    dist_count--;
                }

                i++;
            }

            ans += (j - i + 1);
            
            j++;
        }

        return ans;
    }
}