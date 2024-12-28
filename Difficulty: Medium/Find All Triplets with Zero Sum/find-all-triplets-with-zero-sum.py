#{ 
 # Driver Code Starts
#Initial Template for Python 3

import math


# } Driver Code Ends
#User function Template for python3
class Solution:
    def findTriplets(self, arr):
        n = len(arr)
        l = []
        ind = {}

        for i in range(n):
            for j in range(i + 1, n):
                s = arr[i] + arr[j]
                if s not in ind:
                    ind[s] = []
                ind[s].append((i, j))

        v = set()
        for k in range(n):
            m = -arr[k]
            if m in ind:
                for i, j in ind[m]:
                    if i != k and j != k:
                        triplet = tuple(sorted([i, j, k]))
                        if triplet not in v:
                            v.add(triplet)
                            l.append(list(triplet))

        return l
        

#{ 
 # Driver Code Starts.

def main():
    T = int(input())
    while (T > 0):

        A = [int(x) for x in input().strip().split()]

        ob = Solution()
        res = ob.findTriplets(A)
        res = sorted(res)
        if len(res) == 0:
            print('[]')
        for i in range(len(res)):
            for j in range(len(res[i])):
                print(res[i][j], end=" ")
            print("")
        print('~')
        T -= 1


if __name__ == "__main__":
    main()

# } Driver Code Ends