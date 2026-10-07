import java.util.*;

class Twitter {
    private static int timestamp = 0;
    private Map<Integer, Set<Integer>> follows;
    private Map<Integer, List<Tweet>> userTweets;

    private static class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        follows = new HashMap<>();
        userTweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userTweets.putIfAbsent(userId, new ArrayList<>());
        userTweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        // Max-heap ordered by timestamp (most recent first)
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        Set<Integer> followees = follows.getOrDefault(userId, new HashSet<>());
        
        // Temporarily include the user themselves in the set of accounts to check
        Set<Integer> allUsers = new HashSet<>(followees);
        allUsers.add(userId);

        for (int followeeId : allUsers) {
            List<Tweet> tweets = userTweets.getOrDefault(followeeId, new ArrayList<>());
            // Retrieve only the last 10 tweets per user to optimize memory & speed
            int start = Math.max(0, tweets.size() - 10);
            for (int i = start; i < tweets.size(); i++) {
                maxHeap.offer(tweets.get(i));
            }
        }

        List<Integer> newsFeed = new ArrayList<>();
        while (!maxHeap.isEmpty() && newsFeed.size() < 10) {
            newsFeed.add(maxHeap.poll().id);
        }

        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}