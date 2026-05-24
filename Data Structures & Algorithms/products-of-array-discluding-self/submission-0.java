class Solution {
    public int[] productExceptSelf(int[] nums) {
        int p = 1;
        int len = nums.length;
        int[] l = new int[len];
        int[] r = new int[len];
        l[0] = nums[0];
        r[len-1] = nums[len-1];
        for(int i=1, j=len-2; i<len; i++,j--){
            l[i] = nums[i] * l[i-1];
            r[j] = nums[j] * r[j+1];
        }

        int[] res = new int[len];
        res[0] = r[1];
        res[len-1] = l[len-2];
        for(int i=1; i<len-1; i++){
            res[i] = r[i+1] * l[i-1];
        }

        return res;
    }
}