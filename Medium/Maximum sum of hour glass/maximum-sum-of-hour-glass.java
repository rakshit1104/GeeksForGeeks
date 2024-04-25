//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int Mat[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    Mat[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.findMaxSum(N, M, Mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMaxSum(int n, int m, int mat[][]) {
        // code here
        if(n < 3 || m < 3){
            return -1;
        }
        int[][] arr = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1] + mat[i-1][j-1] - arr[i-1][j-1];
            }
        }
        int maxsum = -1;
        for(int i = 3; i < n + 1; i++){
            for(int j = 3; j < m + 1; j++){
                int sum = arr[i][j] - arr[i][j-3] - arr[i-3][j] + arr[i-3][j-3] - mat[i-2][j-1] - mat[i-2][j-3];
                maxsum = Math.max(maxsum, sum);
            }
        }
        return maxsum;
    }
};