//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[]) {
        int n = a.length;
        
        // Case 1: Maximum sum using standard Kadane's algorithm
        int maxKadane = kadane(a);
        
        // Case 2: Maximum sum in circular configuration
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += a[i];
            a[i] = -a[i]; // Invert the array
        }
        
        int maxCircular = totalSum + kadane(a);
        
        // If all elements are negative, maxCircular will be 0
        if (maxCircular > 0) {
            return Math.max(maxKadane, maxCircular);
        } else {
            return maxKadane;
        }
    }
    
    // Kadane's algorithm to find maximum subarray sum
    static int kadane(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
}