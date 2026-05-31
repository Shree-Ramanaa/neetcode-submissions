class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0, sum=0;
        for(int p:piles){
            max = Math.max(max,p);
            sum+=p;
        }

        if(h == piles.length)return max;
        int hi = max, lo = Math.max(sum/h,1);
        int ans = hi;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            long hours = 0;
            for(int i:piles){
                hours += (i%mid==0)?i/mid:(i/mid)+1;;
            }

            if(hours > h){
                lo = mid + 1;
            } else if(mid < ans){
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }
}
