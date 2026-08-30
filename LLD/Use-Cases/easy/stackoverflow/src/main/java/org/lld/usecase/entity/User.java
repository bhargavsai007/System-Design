package org.lld.usecase.entity;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

import static java.util.UUID.randomUUID;

@Getter
public class User {

    private final String id;
    private final String name;
    private final AtomicInteger reputation;

    public User(String name) {
        this.id = randomUUID().toString();
        this.name = name;
        this.reputation = new AtomicInteger(0);
    }

    public void updateReputation(int change){
        reputation.addAndGet(change);
    }

}
