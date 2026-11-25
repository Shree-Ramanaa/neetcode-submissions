class Solution {
    int []mem;
    public int numDecodings(String s) {
        mem = new int[s.length()];
        Arrays.fill(mem,-1);
        return countWays(s,0);
    }


    private int countWays(String s, int i){
        if(i == s.length()) return 1;
        if(mem[i] != -1)return mem[i];
        if(s.charAt(i) == '0')return mem[i] = 0;
        int oneDig = countWays(s,i+1);
        int st = s.charAt(i)-'0';
        int twoDig = 0;
        if(st<3 && i+1<s.length() && (st==1 || s.charAt(i+1)-'0' < 7)){
          twoDig = countWays(s,i+2);
        }
        return mem[i] = oneDig + twoDig;
    }
}