class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int dirs[][] = new int[][] {{0,1}, {0,-1}, {-1,0}, {1, 0}};

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }

        int rounds = -1;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int cur[] = q.poll();

                for(int[] dir: dirs){
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1){
                        continue;
                    }

                    grid[r][c] = 2;
                    q.add(new int[]{r,c});
                }
            }

            rounds++;
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return rounds == -1 ? 0 : rounds;
    }
}


