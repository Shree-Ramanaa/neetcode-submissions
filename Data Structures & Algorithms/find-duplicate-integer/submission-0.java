class Solution {
    public int findDuplicate(int[] nums) {
        for(int no:nums){
            int pno = no < 0 ? no * -1 : no;
            if(nums[pno] < 0){
                return pno;
            }

            nums[pno] *= -1;
        }

        return -1;
    }
}
