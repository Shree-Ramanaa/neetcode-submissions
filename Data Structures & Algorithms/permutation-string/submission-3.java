class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] ltrs = new int[26];
        Arrays.fill(ltrs, -1);

        for (char ch : s1.toCharArray()) {
            if (ltrs[ch - 'a'] == -1) {
                ltrs[ch - 'a'] = 0;
            }

            ltrs[ch - 'a']++;
        }

        int l = 0, r = 0;
        for (r = 0; r < s2.length(); r++) {
            if (r - l == s1.length()) {
                return true;
            }

            if (ltrs[s2.charAt(r) - 'a'] == -1) {
                while (l < r) {
                    ltrs[s2.charAt(l++) - 'a']++;
                }
                l = r + 1;
                continue;
            }

            if (ltrs[s2.charAt(r) - 'a'] == 0) {
                while (ltrs[s2.charAt(r) - 'a'] == 0) {
                    ltrs[s2.charAt(l++) - 'a']++;
                }
            }

            ltrs[s2.charAt(r) - 'a']--;
        }

        return r - l == s1.length();
    }
}
