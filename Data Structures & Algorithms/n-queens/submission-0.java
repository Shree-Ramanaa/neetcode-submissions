class Solution {
    List<List<String>> res;
    int[][] visitedArr; // 1 means attacked/occupied, 0 means free
    int size;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        visitedArr = new int[n][n];
        size = n;
        solveNQueens(0, new ArrayList<>()); // Start from row 0 up to n-1
        return res;
    }

    private void solveNQueens(int row, List<String> cur) {
        // Base case: All rows filled successfully
        if (row == size) {
            res.add(new ArrayList<>(cur)); // Creates a deep copy of the configuration list
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < size; col++) {
            if (visitedArr[row][col] == 0) {
                
                // 1. Place Queen and mark attacked paths
                markVisited(row, col, 1);
                
                // 2. Dynamically build row string based on size 'n'
                StringBuilder str = new StringBuilder();
                for (int k = 0; k < size; k++) {
                    str.append(k == col ? 'Q' : '.');
                }
                cur.add(str.toString()); // Strings are immutable; safe to add directly

                // 3. Move to next row
                solveNQueens(row + 1, cur);

                // 4. Backtrack: Remove row and unmark attacked paths
                cur.remove(cur.size() - 1);
                markVisited(row, col, 0);
            }
        }
    }

    // Helper to mark/unmark column and both diagonals downward
    private void markVisited(int row, int col, int val) {
        // Mark column straight down
        for (int r = row; r < size; r++) {
            visitedArr[r][col] += (val == 1 ? 1 : -1); 
        }

        // Mark diagonal down-right
        int r = row, c = col;
        while (r < size && c < size) {
            visitedArr[r++][c++] += (val == 1 ? 1 : -1);
        }

        // Mark diagonal down-left
        r = row; c = col;
        while (r < size && c >= 0) {
            visitedArr[r++][c--] += (val == 1 ? 1 : -1);
        }
    }
}
