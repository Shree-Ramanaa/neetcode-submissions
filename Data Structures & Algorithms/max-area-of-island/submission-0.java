class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] != 0){
                    count = Math.max(count, dfs(i,j,grid));
                    
                }
            }
        }

        return count;
    }

    private int dfs(int i, int j, int[][] grid){
        if(i<0 || j<0 || j>=grid[0].length || i>= grid.length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;
        return dfs(i-1, j, grid) +
        dfs(i+1, j, grid) +
        dfs(i, j - 1, grid) + 
        dfs(i, j + 1, grid) + 1;
    }
}
