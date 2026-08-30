package org.lld.usecase.util;

import org.lld.usecase.entity.Question;
import org.lld.usecase.entity.User;

import java.util.List;

public class UserSearchStrategy implements SearchStrategy{

    private final User user;

    public UserSearchStrategy(User user) {
        this.user = user;
    }

    @Override
    public List<Question> filter(List<Question> questions) {
        return questions.stream()
                .filter(q -> q.getAuthor().getId().equals(user.getId()))
                .toList();
    }
}
