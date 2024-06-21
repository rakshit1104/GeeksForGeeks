//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here
        float firstValue = 0;
        float secondValue= 0;
        
        String[] arr = str.split(",");
        
        for(int i = 0; i < arr.length; i++){
            
            String[] currentArr = arr[i].split("/");
            
            float value = (Float.parseFloat(currentArr[0].trim()) / Float.parseFloat(currentArr[1].trim()));
            if(i == 0){
                firstValue += value;
            }
            else{
                secondValue += value;
            }
        }
        if(firstValue == secondValue) return "equal";
        
        return firstValue > secondValue ? arr[0].trim() : arr[1].trim();
    }
}