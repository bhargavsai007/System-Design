package org.lld.usecase.util;

import org.lld.usecase.entity.Question;

import java.util.List;

public class KeywordSearchStrategy implements SearchStrategy{

    private final String keyword;

    public KeywordSearchStrategy(String keyword) {
        this.keyword = keyword.toLowerCase();
    }

    @Override
    public List<Question> filter(List<Question> questions) {
        return questions.stream()
                .filter(q -> q.getTitle().toLowerCase().contains(keyword) || q.getBody().toLowerCase().contains(keyword))
                .toList();
    }

}
