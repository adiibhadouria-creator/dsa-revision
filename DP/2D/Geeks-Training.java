/*

 * Time complexity: O(12N)
 * Space complexity: O(N) +O( Nx 4). ---O(Nx4)
 */

class Solution {
    int func(int day,int last,int[][]matrix,int[][] dp){
        if(day==0){
            int maxi = 0;
            for(int i=0;i<3;i++){
                if(i!=last){
                    maxi = Math.max(maxi,matrix[day][i]);
                }
            }
            return maxi;
        }
        if(dp[day][last] != -1) return dp[day][last];
        int maxi = 0;
        for(int i=0;i<3;i++){
            if(i!=last){
                int points = matrix[day][i] +  func(day-1,i,matrix,dp);
                maxi = Math.max(points,maxi);
            }
        }
        return dp[day][last]=maxi;
    }
    public int maximumPoints(int mat[][]) {
        // code here
         int n = mat.length;
        int[][] dp = new int[n][4];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return func(n-1,3,mat,dp);
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------
Tabulation + space optimised
 int[] prev = new int[4];
        //fill base cases , update day zero
        int a = matrix[0][0] , b = matrix[0][1] , c= matrix[0][2];
        prev[0] = Math.max(b,c);
        prev[1] = Math.max(a,c);
        prev[2] = Math.max(a,b);
        prev[3] = Math.max(a,Math.max(b,c));

        for(int day=1;day<n;day++){
            int[] curr = new int[4];
            for(int last = 0;last<4;last++){
                curr[last] = 0;
                for(int task = 0;task<3;task++){
                    if(task!=last){
                        int points = matrix[day][task] + prev[task];
                        curr[last] = Math.max(curr[last],points);
                    }
                }
            }
            prev = curr;
        }
        return prev[3];
