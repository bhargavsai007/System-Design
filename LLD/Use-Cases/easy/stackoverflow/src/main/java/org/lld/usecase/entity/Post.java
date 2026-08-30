package org.lld.usecase.entity;

import org.lld.usecase.enums.EventType;
import org.lld.usecase.enums.VoteType;
import org.lld.usecase.util.PostObserver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Post extends Content {

    private final AtomicInteger voteCount;
    private final Map<String, VoteType> voters;
    private final List<Comment> comments;
    private final List<PostObserver> observers;


    public Post(String id, String body, User author) {
        super(id, body, author);
        voteCount = new AtomicInteger(0);
        voters = new ConcurrentHashMap<>();
        comments = new CopyOnWriteArrayList<>();
        observers = new CopyOnWriteArrayList<>();
    }

    public void addObserver(PostObserver observer) {
        observers.add(observer);
    }

    protected void notifyObservers(Event event){
        for (PostObserver observer : observers) {
            observer.onPostEvent(event);
        }
    }

    public synchronized  void vote(User user, VoteType voteType){

        String userId = user.getId();

        if(voters.get(userId) == voteType){
            // User has already voted in the same way, do nothing
            return;
        }

        int scoreChange = 0;

        if(voters.containsKey(userId)){

            scoreChange = (voteType == VoteType.UPVOTE ? 2 : -2); // Change from upvote to downvote or vice versa
        }
        else{
            scoreChange = (voteType == VoteType.UPVOTE ? 1 : -1); // New vote
        }

        voters.put(userId, voteType);
        voteCount.addAndGet(scoreChange);

        EventType eventType = null;

        if(this instanceof Question){

            eventType = (voteType == VoteType.UPVOTE) ? EventType.UPVOTE_QUESTION : EventType.DOWNVOTE_QUESTION;
        }
        else{
            eventType = (voteType == VoteType.UPVOTE) ? EventType.UPVOTE_ANSWER : EventType.DOWNVOTE_ANSWER;
        }

        notifyObservers(new Event(eventType, user, this));
    }
}
