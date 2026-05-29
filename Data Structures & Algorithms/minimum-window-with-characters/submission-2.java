class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> fq = new HashMap<>();
        for (char ch : t.toCharArray()) {
            fq.put(ch, fq.getOrDefault(ch, 0) + 1);
        }

        int l = 0, mlen = s.length() + 1, mr = -1, ml = -1, r = 0;
        int zeroCount = fq.size();

        for (r = 0; r < s.length(); r++) {
            // grow the window
            if (fq.containsKey(s.charAt(r))) {
                char ch = s.charAt(r);
                int freq = fq.get(ch) - 1;
                fq.put(ch, freq);
                if (freq == 0) {
                    zeroCount--;
                }
            }

            // shrink window
            while (zeroCount == 0) {
                char ch = s.charAt(l);

                if (fq.containsKey(ch)) {
                    int freq = fq.get(ch) + 1;
                    fq.put(ch, freq);
                    if(freq == 1)zeroCount++;

                    if (r - l + 1 < mlen) {
                        mr = r + 1;
                        ml = l;
                        mlen = r - l + 1;
                    }
                }

                l++;
            }
        }

        return mr != -1 ? s.substring(ml, mr) : "";
    }
}
