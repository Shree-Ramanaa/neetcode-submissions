class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '}' || ch == ')' || ch == ']') {
                if (st.isEmpty())
                    return false;

                char pk = st.peek();
                if ((ch == '}' && pk != '{') || (ch == ')' && pk != '(')
                    || (ch == ']' && pk != '[')) {
                    return false;
                }

                st.pop();
                continue;
            }

            st.push(ch);
        }

        return st.isEmpty();
    }
}
