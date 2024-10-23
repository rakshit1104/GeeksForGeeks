//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
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

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        int jumps=0, curr=0, farthestIdx=0, i=0;
        while(i<arr.length){
            if(i>farthestIdx) return -1;
            farthestIdx=Math.max(farthestIdx, arr[i]+i);
            //assuming we are jumping to the farthest
            if(i==curr){
                curr=farthestIdx;
                jumps++;
                if(curr>=arr.length-1) break;//important
            }
            i++;
        }
        return jumps;
    }
}