package org.lld.usecase.entity;

import java.time.LocalDateTime;

import static java.util.UUID.randomUUID;

public class Comment extends Content{

    public Comment(String body, User author) {
        super(randomUUID().toString(), body, author);
    }
}
