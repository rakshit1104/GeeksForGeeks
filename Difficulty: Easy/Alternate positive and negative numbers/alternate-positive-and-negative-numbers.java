//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for(int i:arr){
            if(i>=0){
                positive.add(i);
            }
            else{
                negative.add(i);
            }
        }
        int l1 = positive.size();
        int l2 = negative.size();
        int mini = Math.min(l1,l2);
        int n1=0,n2=0;
        for(int i=0;i<(2*mini);i++){
            if(i%2==0){
                arr.set(i,positive.get(n1));
                n1++;
            }
            else{
                arr.set(i,negative.get(n2));
                n2++;
            }
        }
        if(l1==mini){
            for(int i=(2*mini);i<(l1+l2);i++){
                arr.set(i,negative.get(n2));
                n2++;
            }
        }
        else{
            for(int i=(2*mini);i<(l1+l2);i++){
                arr.set(i,positive.get(n1));
                n1++;
            }
        }
        
    }
}