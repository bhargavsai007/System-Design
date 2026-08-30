package org.lld.usecase.entity;

import lombok.Getter;
import lombok.Setter;

import static java.util.UUID.randomUUID;

@Setter
@Getter
public class Answer extends Post{

    private boolean isAccepted;

    public Answer(String body, User author) {
        super(randomUUID().toString(), body, author);
    }
}
