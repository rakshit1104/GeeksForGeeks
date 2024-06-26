//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    public static int first(int[] arr, int n, int k){
        int low = 0, high = n - 1;
        int ans = -1;

        while(low <= high) {
            int mid = (low+high)/2;

            if (arr[mid] == k) {
                ans = mid;
                high = mid - 1;
            } else if(arr[mid] < k){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int last(int[] arr, int n, int k){
        int low = 0, high = n - 1;
        int ans = -1;

        while(low <= high) {
            int mid = (low+high)/2;

            if (arr[mid] == k) {
                ans = mid;
                low = mid + 1;
            } else if(arr[mid] < k){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return ans;
    }
    
    ArrayList<Integer> find(int nums[], int n, int target)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int ans1 = first(nums, n, target);
        if (ans1 == -1) {
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        
        int ans2 = last(nums, n, target);
        ans.add(ans1);
        ans.add(ans2);
        return ans;
        
    }
}

//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends