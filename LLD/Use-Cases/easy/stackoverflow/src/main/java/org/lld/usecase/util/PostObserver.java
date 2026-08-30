package org.lld.usecase.util;

import org.lld.usecase.entity.Event;

public interface PostObserver {

    void onPostEvent(Event event);
}
