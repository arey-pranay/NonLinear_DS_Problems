import java.util.*;

class Twitter {

    // Store the following relationships
    private HashMap<Integer, HashSet<Integer>> userFollowing;    
    // Store all tweets along with their userId
    private List<Tweet> allTweets; 

    // A helper class to store tweetId, userId, and the time order of the tweet
    private class Tweet {
        int userId;
        int tweetId;
        int timestamp;  // Timestamp to preserve the order of the tweets

        Tweet(int userId, int tweetId, int timestamp) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }

    private int timestamp;

    public Twitter() {
        this.userFollowing = new HashMap<>();
        this.allTweets = new ArrayList<>();
        this.timestamp = 0;
    }
    
    // Post a tweet
    public void postTweet(int userId, int tweetId) {
        // Increment the timestamp to maintain the order of the tweets
        allTweets.add(new Tweet(userId, tweetId, timestamp++));
    }
    
    // Get the news feed for a user (including the ones they follow)
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        
        // Collect all the users that should be considered for the news feed (the user + the ones they follow)
        HashSet<Integer> usersToConsider = new HashSet<>();
        usersToConsider.add(userId);
        usersToConsider.addAll(userFollowing.getOrDefault(userId, new HashSet<>()));
        
        // PriorityQueue to store the tweets based on their timestamps (most recent first)
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);

        // Add all relevant tweets to the priority queue
        for (Tweet tweet : allTweets) {
            if (usersToConsider.contains(tweet.userId)) {
                pq.offer(tweet);  // Add tweet to the queue
            }
        }

        // Extract the top 10 most recent tweets from the priority queue
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            result.add(pq.poll().tweetId);  // Add tweetId of the most recent tweet
            count++;
        }
        
        return result;
    }
    
    // Follow a user
    public void follow(int followerId, int followeeId) {
        userFollowing.putIfAbsent(followerId, new HashSet<>());
        userFollowing.get(followerId).add(followeeId);
    }
    
    // Unfollow a user
    public void unfollow(int followerId, int followeeId) {
        if (userFollowing.containsKey(followerId)) {
            userFollowing.get(followerId).remove(followeeId);
        }
    }
}
