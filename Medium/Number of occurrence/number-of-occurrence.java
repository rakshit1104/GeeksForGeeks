//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int first(int[] arr, int n, int k){
        int low = 0, high = n - 1;
        int ans = -1;

        while(low <= high) {
            int mid = (low+high)/2;

            if (arr[mid] == k) {
                ans = mid;
                high = mid - 1;
            } else if(arr[mid] < k){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int last(int[] arr, int n, int k){
        int low = 0, high = n - 1;
        int ans = -1;

        while(low <= high) {
            int mid = (low+high)/2;

            if (arr[mid] == k) {
                ans = mid;
                low = mid + 1;
            } else if(arr[mid] < k){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return ans;
    }
    
    int count(int[] nums, int n, int target) {
        // code here
        int ans1 = first(nums, n, target);
        if (ans1 == -1) {
            return 0;
        }
        int ans2 = last(nums, n, target);
        return (ans2 - ans1 + 1);
    }
}