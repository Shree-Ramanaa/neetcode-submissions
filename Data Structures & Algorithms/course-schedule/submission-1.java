class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adjLst= new HashMap<>();

        for(int i=0; i<numCourses; i++){
            adjLst.put(i, new ArrayList<>());
        }

        for(int[] dependency: prerequisites){
            indegree[dependency[0]]++;
            adjLst.get(dependency[1]).add(dependency[0]);
        }


        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int finish = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int cur = q.poll();
                finish++;
                for (int nei : adjLst.get(cur)) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.add(nei);
                    }
                }
            }
        }

        return finish == numCourses;
    }

    /* we calculate indegree
       pic the ones with indegree zero (no dependency)
       while picking we remove its requirement on the dependent tasks
       we repeat this loop, if we picked all courses then it means courses
       are possible to finish 
    */
}
