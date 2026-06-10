class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int no : nums) {
            pq.add(no);
            if(pq.size() > k){
                pq.remove();
            }
        }
    }

    public int add(int no) {
        pq.add(no);
        if(pq.size() > k){
                pq.remove();
        }
        return pq.peek();
    }
}
