package org.lld.usecase.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.lld.usecase.enums.EventType;

@AllArgsConstructor
@Getter
public class Event {

    private final EventType eventType;
    private final User actor;
    private final Post targetPost;
}
