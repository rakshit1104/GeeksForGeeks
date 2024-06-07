//{ Driver Code Starts
import java.util.*;

class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.findExtra(n, a, b));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Solution {
    public int findExtra(int n, int arr1[], int arr2[]) {
        // add code here.
        int len1 = arr1.length;
        int len2 = arr2.length;
        
        if(len1 > len2){
            for(int i = 0; i < len2; i++){
                if(arr1[i] == arr2[i]){
                    continue;
                } else if(i == len2){
                    return i+1;
                } else{
                    return i;
                }
            }
            
        } else{
            for(int i = 0; i < len1; i++){
                if(arr1[i] == arr2[i]){
                    continue;
                } else if(i == len1){
                    return i+1;
                } else{
                    return i;
                }
            }
        }
        return n-1;
    }
}