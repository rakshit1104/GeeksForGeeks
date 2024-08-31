//{ Driver Code Starts
import java.util.*;

public class GFG {
    // Function to check if v2 is a subsequence of v1
    public static boolean isSubSequence(int[] v1, int[] v2) {
        int m = v2.length;
        int n = v1.length;
        int j = 0; // For index of v2

        // Traverse v1 and v2
        for (int i = 0; i < n && j < m; i++) {
            if (v1[i] == v2[j]) {
                j++;
            }
        }
        return j == m;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int n = arr.length;
            Solution obj = new Solution();
            List<Integer> res = obj.find3Numbers(arr);
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            } else {
                int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
                if (resArray.length == 0) {
                    System.out.println(0);
                } else if (resArray[0] < resArray[1] && resArray[1] < resArray[2] &&
                           isSubSequence(arr, resArray)) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
            }
        }
        sc.close();
    }
}

// } Driver Code Ends

class Solution {
    public List<Integer> find3Numbers(int[] arr) {
        // code here
        int len=arr.length;
        int[] tempL=new int[len];
        Arrays.fill(tempL, -1);
        Stack<Integer> stack=new Stack<>();
        
        int[] tempR=new int[len];
        Arrays.fill(tempR, -1);
        
        for(int i=0; i<len; i++){
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                tempL[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        stack.clear();
        
        for(int i=len-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) {stack.pop();}
            
            if(!stack.isEmpty()) {
                tempR[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        
        for (int i = 0; i < len; i++) {
            if (tempL[i] != -1 && tempR[i] != -1) {
                List<Integer> result = new ArrayList<>();
                result.add(tempL[i]);
                result.add(arr[i]);
                result.add(tempR[i]);
                return result;
            }
        }
        
        return new ArrayList<>();
    }
}