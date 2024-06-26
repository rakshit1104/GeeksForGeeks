//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int func(int[] arr, int mid){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += Math.ceil((double)(arr[i]) / (double)(mid));
        }
        return sum;
    }
    
    public static int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int low = 1, high = max;
        while(low <= high){
            int mid = (low+high)/2;

            if(func(nums, mid) <= threshold){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return low;
    }
}