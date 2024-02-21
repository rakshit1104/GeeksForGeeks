//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method*/

class Solution
{
    int subsequenceCount(String S, String T)
    {
	// Your code here
	int n=S.length();
       int m=T.length();
       int dp[][]=new int[n][m];
       int total=0;
       for(int i=n-1;i>=0;i--){
           if(S.charAt(i)==T.charAt(m-1)){
               total=(total+1)%(1000000007);
           }
           dp[i][m-1]=total;
       }
       for(int j=m-2;j>=0;j--){
           total=0;
           for(int i=n-1;i>=0;i--){
               if(S.charAt(i)==T.charAt(j) && i+1<n){
                   total=(total+dp[i+1][j+1])%(1000000007);
               }
               dp[i][j]=total;
           }
       }
       return dp[0][0];
    }
}