class Solution {
    private List<String> res = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))return res;
        gen(digits, 0, new StringBuilder());
        return res;
    }

    private void gen(String digits, int i, StringBuilder sb){
        if(digits.length() == i){
            res.add(sb.toString());
            return;
        }

        for(char ch: digitToChar[digits.charAt(i) - '0'].toCharArray()){
                sb.append(ch);
                gen(digits, i+1, sb);
                sb.deleteCharAt(sb.length()-1);
        }
    }
}
