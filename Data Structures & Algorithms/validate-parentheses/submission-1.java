class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> eq = Map.of(')', '(', ']', '[', '}', '{');
        Stack<Character> parens = new Stack<>();

        for (char curr :  s.toCharArray()) {
            if (!eq.containsKey(curr)) {
                parens.push(curr);
            } else {
                if (parens.isEmpty() || parens.pop() != eq.get(curr)) {
                    return false;
                }
            }
        }

        return parens.empty();
    }
}
