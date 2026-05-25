class Solution {
    public int maxArea(int[] heights) {
        int l=0, r = heights.length-1;

        int maxCap = 0;

        while(l < r){
            int cap = (r-l) * Math.min(heights[r], heights[l]);
            maxCap = Math.max(cap, maxCap);
            if(heights[r] < heights[l]){
                r--;
            }else{
                l++;
            }
        }

        return maxCap;
    }
}
