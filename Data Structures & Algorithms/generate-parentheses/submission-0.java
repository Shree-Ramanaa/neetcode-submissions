class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        bt(0,0,n,new StringBuilder());
        return res;
    }

    public void bt(int l, int r, int n, StringBuilder sb){
        if(l == r && r == n){
            res.add(sb.toString());
            return;
        }

        if(l < n){
            sb.append("(");
            bt(l+1, r, n, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(r < n && l > r){
            sb.append(")");
            bt(l, r+1, n, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        return;
    }
}
