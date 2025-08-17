class Twitter {

    Map<Integer, User> users;
    int currtime = 0;

    static class Post{
        int postId;
        int userId;
        int timeStamp;
        public Post(int tweetId, int userId, int timeStamp){
            this.postId = tweetId;
            this.userId = userId;
            this.timeStamp = timeStamp;
        }
    }

    PriorityQueue<Post> posts;

    public Twitter() {
        users = new HashMap<>();
        posts = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.timeStamp, a.timeStamp);
        });
    }



    static class User{
        int userId;
        List<Integer> Following = new ArrayList<>();
        List<Post>posts = new ArrayList<>();

        public User(int userID){
            this.userId = userId;
        }

        public void addPost(Post post){
            this.posts.add(post);
        }

        public void addFollowing(int userId){
            this.Following.add(Integer.valueOf(userId));
        }

        public void removeFollowing(int userId){
            this.Following.remove(Integer.valueOf(userId));
        }

    }
    
    public void postTweet(int userId, int tweetId) {

        currtime++;

        // if user does'nt exist, add new user:
        User curruser = users.containsKey(userId) ? users.get(userId) : null;

        if (curruser == null){
            curruser = new User(userId);
            users.put(userId, curruser);
        }

        // add new post:
        Post newpost = new Post(tweetId, userId, currtime);
        curruser.addPost(newpost);
        posts.offer(newpost);
        
    }
    
    public List<Integer> getNewsFeed(int userId) {

        if (!users.containsKey(userId)){
            users.put(userId, new User(userId));
        }

        List<Integer> Following = users.get(userId).Following;
        List<Integer> news = new ArrayList<>();
        User curr = users.get(userId);
        if (Following.size() == 0 && curr.posts.size() == 0) return news;

        List<Post> temp = new ArrayList<>();

        int i = 0;
        while(i < 10 && !posts.isEmpty()){
            Post post = posts.peek();
            int user = post.userId;
            int postId = post.postId;
            if (Following.contains(user) || user == userId){
                System.out.println(postId);
                news.add(postId);
                i++;
            }
            temp.add(posts.poll());
            System.out.println("size " + posts.size());
            
        }

        for (int j = 0; j < temp.size(); j++){
            posts.offer(temp.get(j));
        }

        temp.clear();

        return news;




    }
    
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)){
            users.put(followerId, new User(followerId));
        }

        if (!users.containsKey(followeeId)){
            users.put(followeeId, new User(followeeId));
        }

       User user1 = users.get(followerId);
       user1.addFollowing(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
       User user1 = users.get(followerId);
        user1.removeFollowing(followeeId);
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