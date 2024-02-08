//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String s)
    {
        // code here
        char[] str = s.toCharArray();
        int start = 0, end;

        for (end = 0; end < str.length; end++) {
            if (str[end] == '.') {
                reverse(str, start, end - 1);
                start = end + 1;
            }
        }

        reverse(str, start, str.length - 1);
        reverse(str, 0, str.length - 1);

        return new String(str).trim();
    }
    
    static void reverse(char str[], int start, int end) {
        while (start <= end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}