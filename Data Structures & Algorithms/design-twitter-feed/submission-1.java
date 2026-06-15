public class Twitter {
    private int time;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        List<int[]> tweets = new ArrayList<>();
        followMap.computeIfAbsent(userId, set -> new HashSet<>()).add(userId);
        for (int followeeId : followMap.get(userId)) {
            if(tweetMap.get(followeeId)!=null){
                tweets.addAll(tweetMap.get(followeeId));
            }
        }
        
        if(tweets.size() > 0)pq.addAll(tweets);
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty() && res.size() < 10){
            res.add(pq.poll()[1]);
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            followMap.putIfAbsent(followerId, new HashSet<>());
            followMap.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        followMap.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}