class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int max = 0;
        for(int no: nums){
            int val = freq.getOrDefault(no, 0) + 1;
            max = Math.max(val , max);
            freq.put(no, val);
        }

        List<Integer>[] count = new ArrayList[max+1];

        for(int key: freq.keySet()){
            if(count[freq.get(key)] == null){
                count[freq.get(key)] = new ArrayList<>();
            }

            count[freq.get(key)].add(key);
        }

        int[] ans = new int[k];

        for(int i=max; i>0 && k > 0; i--){
            if(count[i] != null){
                for(int no: count[i]){
                    if(k == 0)break;
                    ans[--k] = no;
                }
            }
        }

        return ans;
    }
}
