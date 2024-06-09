//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int nums[], int n)
    {
        // your code here
        int cnt = 0;
        int ele = 0;

        for(int i = 0; i < nums.length; i++){
            if(cnt == 0){
                cnt++;
                ele = nums[i];
            } else if(ele == nums[i]){
                cnt++;
            } else{
                cnt--;
            }
        }

        int cnt1 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == ele){
                cnt1++;
            }
        }
        if(cnt1 > n/2){
            return ele;
        }
        return -1;
    }
}