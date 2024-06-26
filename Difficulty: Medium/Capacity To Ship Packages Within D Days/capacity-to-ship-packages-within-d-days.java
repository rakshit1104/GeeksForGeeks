//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];

            int D = Integer.parseInt(read.readLine());

            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr, N, D));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int func(int[] weights, int capacity){
        int days = 1, load = 0;
        for(int i = 0; i < weights.length; i++){
            if(weights[i] + load > capacity){
                days += 1;
                load = weights[i];
            } else{
                load += weights[i];
            }
        }
        return days;
    }
    
    static int leastWeightCapacity(int[] weights, int n, int days) {
        // code here
        int low = 0, high = 0;
        for(int i = 0; i  < weights.length; i++){
            low = Math.max(low, weights[i]);
            high = high + weights[i];
        }

        while(low <= high){
            int mid = (low+high)/2;
            if(func(weights, mid) <= days){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return low;
    }
};