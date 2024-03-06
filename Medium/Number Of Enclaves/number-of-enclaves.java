//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int count = 0;
        borders(grid);
        for (int i = 1; i < grid.length - 1; i++)
        {
            for (int j = 1; j < grid[0].length - 1; j++)
            {
                if (grid[i][j] == 1)
                    count += isIsland(new int[]{i,j}, grid);
            }
        }
        return count;
    }
    
    public int isIsland(int []ij, int[][] grid)
    {
        int count = 1;
        boolean yes = true;
        int [][]moves = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        LinkedList<int[]> island = new LinkedList<>();
        island.add(ij);
        grid[ij[0]][ij[1]] = 2;
        int []cur;
        while (island.size() > 0)
        {
            cur = island.getFirst();
            island.removeFirst();
            for (int [] m: moves)
            {
                int tmp = grid[cur[0] + m[0]][cur[1] + m[1]];
                if (tmp == -1) yes = false;
                else if (tmp == 1) {
                    island.add(new int[]{cur[0] + m[0], cur[1] + m[1]});
                    count++;
                    grid[cur[0] + m[0]][cur[1] + m[1]] = 2;
                }
            }
        }
        if (yes) return count;
        return 0;
    }
    public void borders(int[][] grid)
    {
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) grid[0][i] = -1;
            else grid[0][i] = -2;
            if (grid[grid.length - 1][i] == 1) grid[grid.length - 1][i] = -1;
            else grid[grid.length - 1][i] = -2;
        }
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) grid[i][0] = -1;
            else grid[i][0] = -2;
            if (grid[i][grid[0].length - 1] == 1) grid[i][grid[0].length - 1] = -1;
            else grid[i][grid[0].length - 1] = -2;
        }
    }
}