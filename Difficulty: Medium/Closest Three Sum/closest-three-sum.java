//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().threeSumClosest(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{ 
    static int threeSumClosest(int[] array, int target)  
    { 
        Arrays.sort(array);
        int sum=array[0]+array[1]+array[array.length-1];
        for(int i=0;i<array.length-1;i++)
        {
            int left=i+1;
            int right=array.length-1;
            
            while(left<right)
            {
                int csum=array[i]+array[left]+array[right];
                
                if(Math.abs(csum-target)<Math.abs(sum-target))
                {
                sum=csum;
                }
                else if(Math.abs(csum-target)==Math.abs(sum-target) && csum>sum)
                      sum=csum;
                
                if(csum==target)
                return csum;
                
                else if(csum<target)
                left++;
                else
                right--;
            }
        }
        return sum;
    } 
}