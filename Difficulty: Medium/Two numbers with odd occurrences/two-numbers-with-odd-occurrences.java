//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int Arr[], int N)
    {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        
        for(int i = 0; i<N; i++){
            map.put(Arr[i], map.getOrDefault(Arr[i],0)+1);
        }
        
        int i = 0;
        for(Map.Entry<Integer, Integer> ele:map.entrySet()){
            if(ele.getValue()%2 != 0){
                result[i] = ele.getKey();
                i++;
                if(i>=2) break;
            }
        }
        
        if(result[0] < result[1]){
            int temp = result[0];
            result[0] = result[1];
            result[1] = temp;
        }
        
        return result;
    }
}