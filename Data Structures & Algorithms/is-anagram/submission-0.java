class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] hash = new int[26];

        for(char ch : s.toCharArray()){
            hash[ch - 97]++;
        }

        for(char ch : t.toCharArray()){
            hash[ch - 97]--;
        }

        for(int i: hash){
            if(i != 0)return false;
        }

        return true;
    }
}
