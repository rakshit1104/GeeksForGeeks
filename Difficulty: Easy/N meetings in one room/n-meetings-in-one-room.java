//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int maxMeetings(int n, int start[], int end[]) {
        if(n==0) return 0;
        int arr[][] = new int[n][2];
        
        for(int i=0 ; i<n ; i++){
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }
        
        int ans = 1;
        Arrays.sort(arr,(a, b) -> Integer.compare(a[1],b[1]));
        int sTime = start[0], eTime = arr[0][1];
        
        for(int i=1 ; i<n ; i++){
            if(eTime < arr[i][0]){
                ans++;
                eTime = arr[i][1];
            }
        }
        return ans;
        
    }
}