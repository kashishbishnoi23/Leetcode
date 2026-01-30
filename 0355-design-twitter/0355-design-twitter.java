class Twitter {

    static int time = 0;

    static class Post {
        int postId;
        int time;

        public Post(int postId, int time) {
            this.postId = postId;
            this.time = time;
        }
    }

    static class User {
        int userId;
        Set<User> followees;
        List<Post> posts;

        public User(int userId) {
            this.userId = userId;
            followees = new HashSet<>();
            posts = new ArrayList<>();
        }

        public void addPost(int tweetId) {
            posts.add(new Post(tweetId, time++));
        }

        public void follow(User user) {
            if (user != this) {
                followees.add(user);
            }
        }

        public void unfollow(User user) {
            followees.remove(user);
        }
    }

    HashMap<Integer, User> users;

    public Twitter() {
        users = new HashMap<>();
    }

    private User getUser(int userId) {
        users.putIfAbsent(userId, new User(userId));
        return users.get(userId);
    }

    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);
        user.addPost(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!users.containsKey(userId)) return result;

        PriorityQueue<Post> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time   
        );

        User user = users.get(userId);

        // user's own posts
        pq.addAll(user.posts);

        // followees posts
        for (User followee : user.followees) {
            pq.addAll(followee.posts);
        }

        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            result.add(pq.poll().postId);
            count++;
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        follower.follow(followee);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId) || !users.containsKey(followeeId)) return;
        users.get(followerId).unfollow(users.get(followeeId));
    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */