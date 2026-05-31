class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int len = heights.length;
        int[] l = new int[len];
        int[] r = new int[len];

        for(int i=0; i<len; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            l[i] = st.isEmpty() ? 0 : st.peek()+1;
            st.push(i);
        }
        
        st.clear();
        for(int i=len-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            r[i] = st.isEmpty() ? len-1 : st.peek()-1;
            st.push(i);
        }

        int res = 0;
        for(int i=0; i<len; i++){
            int area = heights[i] * ((i - l[i]) + (r[i] - i) + 1);
            res = Math.max(area, res);
        }

        return res;
    }
}