class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int st:stones){
            pq.add(st);
        }

        while(pq.size() > 1){
            int newWeight = pq.remove() - pq.remove();
            if(newWeight > 0){
                pq.add(newWeight);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}
