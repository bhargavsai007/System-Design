package org.lld.usecase.entity;

import lombok.Getter;
import org.lld.usecase.enums.EventType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.UUID.randomUUID;

@Getter
public class Question extends Post{

    private final String title;
    private final Set<Tag> tags;
    private final List<Answer> answers;
    private Answer acceptedAnswer;

    public Question(String title, String body, User author, Set<Tag> tags) {
        super(randomUUID().toString(), body, author);
        this.title = title;
        this.tags = tags;
        this.answers = new ArrayList<>();
        this.acceptedAnswer = null;
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public synchronized void acceptAnswer(Answer answer){

        if(acceptedAnswer==null && !answer.getAuthor().getId().equals(this.getAuthor().getId())){
            answer.setAccepted(true);
            acceptedAnswer = answer;
            notifyObservers(new Event(EventType.ACCEPT_ANSWER, answer.getAuthor(), answer));
        }
    }
}
