//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            
            int mat1[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat1[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int mat2[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat2[i][j] = Integer.parseInt(input[j]);
                }
            }
            
        
            
            Solution ob = new Solution();
            System.out.println(ob.countPairs(mat1,mat2,n,x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countPairs(int matrix1[][], int matrix2[][], int N, int x) {
        
        int output = 0;
        
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                int target = x - matrix1[i][j];
                
                if (target < 0)
                    continue;
                
                if (binarySearchMatrix(matrix2, N, target))
                    output ++;
            }
        }
        
        return output;
    }
    
    private boolean binarySearchMatrix(int[][] matrix, int N, int target) {
        
        int top = 0, bottom = N - 1;
        int leftIndex = 0, rightIndex = N - 1;
        
        while (top <= bottom)
        {
            int mid = (top + bottom) / 2;
            
            if (matrix[mid][leftIndex] <= target && target <= matrix[mid][rightIndex])
            {
                while (leftIndex <= rightIndex)
                {
                    int Mid = (leftIndex + rightIndex) / 2;
                
                    if (matrix[mid][Mid] == target)
                        return true;
                
                    else if (matrix[mid][Mid] < target)
                        leftIndex = Mid + 1;
                
                    else
                        rightIndex = Mid - 1;
                }
                
                return false;
            }
            
            else if (matrix[mid][leftIndex] <= target)
                top = mid + 1;
            
            else 
                bottom = mid - 1;
        }
        
        return false;
    }
}