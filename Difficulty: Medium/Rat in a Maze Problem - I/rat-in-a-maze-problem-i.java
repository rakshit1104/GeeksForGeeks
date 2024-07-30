//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends

class Solution {
    
    int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    String[] dirStr={"U","D","L","R"};
    
    void findPaths(int[][] mat,int n,int i,int j,StringBuilder str,ArrayList<String> res){
        
        if(i>=n || j>=n || i<0 || j<0 || mat[i][j]==0) return;
        
        if((i==n-1) && (j==n-1)){
            res.add(str.toString());
            return;
        }
        
        
        for(int k=0;k<4;k++){
            int ii=dir[k][0];
            int jj=dir[k][1];
            
            str.append(dirStr[k]);
            mat[i][j]=0;
            findPaths(mat,n,i+ii,j+jj,str,res);
            mat[i][j]=1;
            str.deleteCharAt(str.length()-1);
        }
    }
    
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        
        ArrayList<String> res=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        
        findPaths(mat,mat.length,0,0,str,res);
        
        return res;
    }
}