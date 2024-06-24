//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            long n = Long.parseLong(S[0]);
            long q = Long.parseLong(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.sumMatrix(n, q));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static long sumMatrix(long n, long q) {
        if (q > 2 * n) {
            return 0;
        }
        
        long count = 0;
        if (q <= n) {
            count = q - 1;
        } else {
            count = 2 * n - q + 1;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(sumMatrix(4, 7));
        System.out.println(sumMatrix(5, 4));
    }
}