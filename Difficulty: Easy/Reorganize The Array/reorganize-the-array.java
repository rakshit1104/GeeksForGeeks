//{ Driver Code Starts
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// } Driver Code Ends
class Solution {
    public List<Integer> rearrange(List<Integer> arr) {
        int count = 0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==-1 || arr.get(i)==i)continue;
            
            int ind = arr.get(i);
            arr.set(i,-1);
            while(ind!=-1 && count<arr.size()){
                int temp = arr.get(ind);
                arr.set(ind,ind);
                ind = temp;
                count++;
            }
        }
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)!=i && arr.get(i)!=-1){
                arr.set(i,-1);
            }
        }
        return arr;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Solution solution = new Solution();

        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("\\s+");
            List<Integer> arr = new ArrayList<>();
            for (String s : inputArr) {
                arr.add(Integer.parseInt(s));
            }

            List<Integer> ans = solution.rearrange(arr);

            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
// } Driver Code Ends