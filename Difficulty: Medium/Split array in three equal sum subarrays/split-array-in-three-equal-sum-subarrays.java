//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to determine if array arr can be split into three equal sum sets.
    public List<Integer> findSplit(int[] arr) {
        // code here
        List<Integer> list=new ArrayList<>(2);
        list.add(-1);
        list.add(-1);
        int sum=0;
        
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        
        if(sum%3!=0){
            return list;
        } else{
            list.add(0,0);
            int part=sum/3;
            int temp=0;
            for(int i=0;i<arr.length;i++){
                temp+=arr[i];
                if(temp==part){
                  if(list.get(1)==-1)
                  list.add(1,i);
                  temp=0;
                } else if(temp>part){
                  list.add(0,-1);
                  list.add(1,-1);
                  return list;
                }
            }
        }
        return list;
    }
}