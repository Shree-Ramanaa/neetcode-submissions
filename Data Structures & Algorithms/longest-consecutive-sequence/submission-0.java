class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> nos = new HashSet<>();
        int ls = 0;
        for(int no:nums)nos.add(no);

        for(int no: nums){
            int suc = no+1;
            int slen = 1;
            while(nos.contains(suc)){
                nos.remove(suc++);
                slen++;
            }

            int pred = no - 1;
            while(nos.contains(pred)){
                nos.remove(pred--);
                slen++;
            }

            ls = slen > ls ? slen : ls;
        }

        return ls;
    }
}
