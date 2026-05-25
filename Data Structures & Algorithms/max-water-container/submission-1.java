class Solution {
    public int maxArea(int[] heights) {
        int l=0, r = heights.length-1;

        int maxArea = 0;

        while(l < r){
            int h = Math.min(heights[l],heights[r]);
            int w = r -   l;
            maxArea = Math.max(maxArea,h*w);
            while( l < r && heights[l] <= h)
                l++;
            while( l < r && heights[r] <= h)
                r--;
        }

        return maxArea;
    }
}
