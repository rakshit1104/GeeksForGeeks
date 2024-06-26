//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int min(int[] arr){
        int ans = Integer.MAX_VALUE;
        int n = arr.length;
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, arr[i]);
        }
        return ans;
    }

    public static int max(int[] arr){
        int ans = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, arr[i]);
        }
        return ans;
    }

    public static int func(int[] arr, int m, int k, int mid){
        int count = 0;
        int bouq = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= mid){
                count++;
            } else{
                bouq = bouq + (count/k);
                count = 0;
            }
        }
        bouq = bouq + (count/k);
        return bouq;
    }
    
    public static int solve(int m, int k, int[] bloomDay) {
        long val = (long) m * k;
        if (val > bloomDay.length) return -1;
        
        int low = min(bloomDay);
        int high = max(bloomDay);

        while(low <= high){
            int mid = (low+high)/2;
            if(func(bloomDay, m, k, mid) >= m){
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return low;
    }
}