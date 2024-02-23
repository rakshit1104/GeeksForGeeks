//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine().trim());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxProfit(int n, int[] price) {
        // code here
        if(n<=1){
            return 0;
        }
        int profit_first[] = new int[n+1];
        int profit_sec[] = new int[n+1];
        
        int first_min = price[0];
        for(int i=1;i<n;i++){
            first_min = Math.min(first_min,price[i]);
            profit_first[i] = Math.max(profit_first[i-1],price[i]-first_min);
        }
        
        int sec_max = price[n-1];
        for(int i=n-2;i>=0;i--){
            sec_max = Math.max(price[i],sec_max);
            profit_sec[i] = Math.max(profit_sec[i+1],sec_max-price[i]);
        }
        
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,profit_first[i]+profit_sec[i]);
        }
        return ans;
    }
}