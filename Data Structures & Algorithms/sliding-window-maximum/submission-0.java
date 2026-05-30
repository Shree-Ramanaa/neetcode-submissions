class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<Integer>();

        for(int i=0; i<k; i++){
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }

            q.addLast(i);
        }

        int[] res = new int[nums.length - k + 1];
        res[0] = nums[q.peekFirst()];
        
        
        for(int l=0, r=k; r<nums.length; r++,l++){
            while(!q.isEmpty() && nums[q.peekLast()] < nums[r]){
                q.pollLast();
            }

            q.addLast(r);

            if(q.peekFirst() == l){
                q.pollFirst();
            }

            res[l+1] = nums[q.peekFirst()];
        }

        return res;
    }
}
