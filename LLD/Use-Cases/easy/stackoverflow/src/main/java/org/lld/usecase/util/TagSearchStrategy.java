package org.lld.usecase.util;

import org.lld.usecase.entity.Question;
import org.lld.usecase.entity.Tag;

import java.util.List;

public class TagSearchStrategy implements SearchStrategy{

    private final Tag tag;

    public TagSearchStrategy(Tag tag) {
        this.tag = tag;
    }

    @Override
    public List<Question> filter(List<Question> questions) {

        return questions.stream()
                .filter(q-> q.getTags().stream().anyMatch(t-> t.getName().equalsIgnoreCase(tag.getName())))
                .toList();
    }
}
