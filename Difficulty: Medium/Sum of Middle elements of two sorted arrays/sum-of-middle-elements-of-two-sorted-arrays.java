//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends

class Solution {
    public int SumofMiddleElements(int[] nums1, int[] nums2) {
        // code here
        return getKthPosition(nums1, nums2, (nums1.length + nums2.length) / 2) + getKthPosition(nums1, nums2, ((nums1.length + nums2.length) / 2) - 1);
    }
    
    private int getKthPosition(int[] nums1, int[] nums2, int position) {
        int left = Math.min(nums1[0], nums2[0]);
        int right = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = countLessThan(nums1, mid) + countLessThan(nums2, mid);
            if (count <= position) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    private int countLessThan(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;
        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < value) {
                answer = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends