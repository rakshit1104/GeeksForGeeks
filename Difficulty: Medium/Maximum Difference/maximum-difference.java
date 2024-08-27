//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMaxDiff(int[] arr) {
        // code here
        int n = arr.length;
        int[] ls = new int[n];
        int[] rs = new int[n];
        Stack<Integer> s  = new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]) s.pop();
            ls[i] = s.isEmpty() ? 0 : arr[s.peek()];
            s.push(i);
        }
        s.clear();
        for(int i=n-1;i>=0;i--){
            while (!s.isEmpty() && arr[s.peek()]>=arr[i]) {
                s.pop();
            }
            rs[i] = s.isEmpty() ? 0 : arr[s.peek()];
            s.push(i);
        }
        int maxDiff  = -1;
        for(int i=0;i<n;i++){
            int diff = Math.abs(ls[i]-rs[i]);
            maxDiff  = Math.max(maxDiff,diff);
        }
        return maxDiff;
    }
}
