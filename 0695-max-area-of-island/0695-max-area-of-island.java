class Solution {
    private int dfs(int[][] grid,int row,int col,int R,int C){
        int sum = 0;
        grid[row][col] = 0;
        int[] rdiff = {-1,1,0,0};
        int[] cdiff = {0,0,-1,1};
        for(int i=0;i<4;i++){
            int ar = row+rdiff[i];
            int ac = col+cdiff[i];
            if(ar>=0 && ar<R && ac>=0 && ac<C && grid[ar][ac] != 0){
                sum += grid[ar][ac];
                sum += dfs(grid,ar,ac,R,C);
            }
        }
        return sum;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int maxSum = 0;
        for(int row=0;row<R;row++){
            for(int col=0;col<C;col++){
                if(grid[row][col] == 1){
                    int sum = grid[row][col];
                    sum += dfs(grid,row,col,R,C);
                    maxSum = Math.max(maxSum,sum);
                }
            }
        }
        return maxSum;
    }
}