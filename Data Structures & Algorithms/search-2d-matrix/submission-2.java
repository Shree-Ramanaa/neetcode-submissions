class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length-1, c=matrix[0].length;
        if(matrix[0][0] > target || matrix[r][c-1] < target){
            return false;
        }
        
        int row = bsearchr(matrix, target);
        if(row == -1)return false;
        int ele = bsearchc(matrix, target, row);

        return ele != -1;
    }

    private int bsearchr(int[][] matrix, int target){
        int l=0;
        int r = matrix.length -1;
        while(l < r){
            int mid = l + (r - l)/2;
            if(matrix[mid][0] == target){
                return mid;
            }

            if(matrix[mid][0] > target){
                r = mid - 1;
            } else if(matrix[mid][matrix[0].length-1] < target) {
                l = mid + 1;
            } else{
                return mid;
            }
        }

        return r;
    }

    private int bsearchc(int[][] matrix, int target, int row){
        int l=0;
        int h = matrix[0].length -1;
        while(l < h){
            int mid = l + (h - l)/2;
            if(matrix[row][mid] == target){
                return mid;
            }

            if(matrix[row][mid] > target){
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return matrix[row][h] == target ? target : -1;
    }
}
