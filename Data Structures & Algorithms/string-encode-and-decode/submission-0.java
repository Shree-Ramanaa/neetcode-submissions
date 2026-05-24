class Solution {

    public String encode(List<String> strs) {
        StringBuilder st = new StringBuilder();
        for(String str : strs){
            st.append(str.length() + "#" + str);
        }

        return st.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> res = new ArrayList<>();

        while(i < str.length()){
            int j = i;
            while(str.charAt(i) != '#'){
                i++;
            }

            int len = Integer.parseInt(str.substring(j,i));
            res.add(str.substring(i+1, i+len+1));
            i = i+len+1;
        }

        return res;
    }
}
