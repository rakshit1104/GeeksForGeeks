//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                String temp[] = br.readLine().trim().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                String x = temp[1];
                arr[i][1] = Integer.parseInt(x);
            }
            Solution obj = new Solution();
            boolean ans = obj.canAttend(arr);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends

class Solution {
    static boolean canAttend(int[][] arr) {
        // Your code here
        Srt st = new Srt();
        st.araySort(arr);
        int count = 0;
        for(int i = 0; i<arr.length-1; i++){
           if(arr[i][1] > arr[i+1][0]) return false;
        }
        return true;
        
    }
}
class Srt {
   void araySort(int aray[][]) {
      Comparator<int[]> comp = new Comparator<int[]>() {
         public int compare(int[] val1, int[] val2) {
            if(val1[0] > val2[0]) {
               return 1;
            } else {
               return -1;
            }
         }
      };
      Arrays.sort(aray, comp);
   }
}