//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int n, int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                st.push(arr[i]);
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(arr[i])) {
                    st.pop();
                }
                
                if (!st.isEmpty() && st.peek() == Math.abs(arr[i])) {
                    st.pop();
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(arr[i]);
                }
            }
        }

        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}
