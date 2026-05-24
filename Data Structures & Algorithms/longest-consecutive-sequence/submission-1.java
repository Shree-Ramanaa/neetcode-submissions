class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums) { set.add(num); }
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            int current = nums[i];
            int count = 1;
            if(!set.contains(current - 1)) {
                while(set.contains(current + 1)) {
                    current++;
                    count++;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
