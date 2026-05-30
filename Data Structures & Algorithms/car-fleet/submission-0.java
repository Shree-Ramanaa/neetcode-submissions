class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        double[][] pr = new double[len][2];

        for(int i=0; i<len; i++){
            pr[i] = new double[]{position[i], ((double)(target - position[i]))/speed[i]}; 
        }

        Arrays.sort(pr, (a,b) -> Double.compare(b[0],a[0]));
        int fleets = 0;
        double curMax = 0.0;

        for(int i=0; i<len; i++){
            if(pr[i][1] > curMax){
                fleets++;
                curMax = pr[i][1];
            }
        }

        return fleets;
    }
}
