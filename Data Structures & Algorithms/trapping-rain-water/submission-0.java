class Solution {
    public int trap(int[] h) {
        Stack<Integer> st = new Stack<>();
        int res = 0;

        for(int i=0; i<h.length; i++){
            while(!st.isEmpty() && h[i] > h[st.peek()]){
                int bottom = h[st.pop()];

                if(!st.isEmpty()){
                    int rightWall = h[i];
                    int leftWall = h[st.peek()];
                    int he = Math.min(rightWall, leftWall) - bottom;
                    int w = i - st.peek() - 1;
                    res += he * w;
                }
            }

            st.push(i);
        }

        return res;
    }
}
