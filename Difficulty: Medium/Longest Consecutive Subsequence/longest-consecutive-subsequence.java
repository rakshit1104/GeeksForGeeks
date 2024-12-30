//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] nums) {
        // code here
        int max=1;
        int c=1;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]==1){
                c++;
            }else if(nums[i]-nums[i-1]==0){
                
            }else{
                c=1;
            }
            max = Math.max(max,c);
        }
        return max;
    }
}