//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String st[] = read.readLine().trim().split("\\s+");
            int n = st.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[(int)i] = Integer.parseInt(st[(int)i]);

            System.out.println(new Solution().maxStep(arr));
        }
    }
}

// } Driver Code Ends



class Solution {
    public int maxStep(int arr[]) {
        // Your code here
        int count =0 ;
        int n = arr.length;
        int max = 0;
        
        for(int i= 1 ; i < n ; i++) {
            if(arr[i]>arr[i-1])
            {
                max++;
            }
            else{
                max = 0;
            }
            count = Math.max(count ,max);
        }
    return count;
    }
}