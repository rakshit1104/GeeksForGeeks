//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public void dfs(int row,int col,char grid[][],int visitArray[][]){
       // visitArray[row][col]=1;
        int m=grid.length;
        int n=grid[0].length;

        // checcking the all base cases
        if(row<0 || row>=m ||col<0 || col>=n ||grid[row][col]=='0' || visitArray[row][col]==1){
        return;
        
    }
    visitArray[row][col]=1;
    
    // rotating 8 consecutive sites of one node
            for(int delRow=-1;delRow<=1;delRow++){
                for(int delCol=-1;delCol<=1;delCol++){
                    int newRow=row+delRow;
                    int newCol=col+delCol;
                    dfs(newRow,newCol,grid,visitArray); 
                      
        }
    }
}  
    
    public int numIslands(char[][] grid) {
        // Code here
      
        int row=grid.length;
        int col=grid[0].length;
        int visitArray[][]=new int[row][col];
        //visitArray[row][col]=0;
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
             if(grid[i][j]=='1'&& visitArray[i][j]==0)
                 {
                     count++;
                     dfs(i,j,grid,visitArray);
                 }
            }
        }
        return count;
    }
}