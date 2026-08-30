package org.lld.usecase.util;

import org.lld.usecase.entity.Question;

import java.util.List;

public interface SearchStrategy {

    List<Question> filter(List<Question> questions);
}
