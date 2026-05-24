class Solution {
    public int[] twoSum(int[] nums, int target) {
         Map<Integer, Integer> st = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (st.get(target - nums[i]) != null) {
                return new int[] { st.get(target - nums[i]), i };
            }
            st.put(nums[i], i);
        }

        return new int[] {};
    }
}
