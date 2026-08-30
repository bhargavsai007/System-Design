package org.lld.usecase;

import org.lld.usecase.entity.Answer;
import org.lld.usecase.entity.Question;
import org.lld.usecase.entity.Tag;
import org.lld.usecase.entity.User;
import org.lld.usecase.enums.VoteType;
import org.lld.usecase.util.SearchStrategy;
import org.lld.usecase.util.TagSearchStrategy;
import org.lld.usecase.util.UserSearchStrategy;

import java.util.List;
import java.util.Set;

public class StackoverflowDemo {

    public static void main(String[] args) {

        StackOverFlowService service = new StackOverFlowService();

        // 1. Create Users
        User Tuffy = service.createUser("Tuffy");
        User Blackie = service.createUser("Blackie");
        User Hawkie = service.createUser("Hawkie");

        // 2. Tuffy posts a question
        System.out.println("--- Tuffy posts a question ---");
        Tag javaTag = new Tag("java");
        Tag designPatternsTag = new Tag("design-patterns");
        Set<Tag> tags = Set.of(javaTag, designPatternsTag);
        Question question = service.postQuestion(Tuffy.getId(), "How to implement Observer Pattern?", "Details about Observer Pattern...", tags);
        printReputations(Tuffy, Blackie, Hawkie);

        // 3. Blackie and Hawkie post answers
        System.out.println("\n--- Blackie and Hawkie post answers ---");
        Answer BlackieAnswer = service.postAnswer(Blackie.getId(), question.getId(), "You can use the java.util.Observer interface.");
        Answer HawkieAnswer = service.postAnswer(Hawkie.getId(), question.getId(), "A better way is to create your own Observer interface.");
        printReputations(Tuffy, Blackie, Hawkie);

        // 4. Voting happens
        System.out.println("\n--- Voting Occurs ---");
        service.voteOnPost(Tuffy.getId(), question.getId(), VoteType.UPVOTE); // Tuffy upvotes her own question
        service.voteOnPost(Blackie.getId(), HawkieAnswer.getId(), VoteType.UPVOTE); // Blackie upvotes Hawkie's answer
        service.voteOnPost(Tuffy.getId(), BlackieAnswer.getId(), VoteType.DOWNVOTE); // Tuffy downvotes Blackie's answer
        printReputations(Tuffy, Blackie, Hawkie);

        // 5. Tuffy accepts Hawkie's answer
        System.out.println("\n--- Tuffy accepts Hawkie's answer ---");
        service.acceptAnswer(question.getId(), HawkieAnswer.getId());
        printReputations(Tuffy, Blackie, Hawkie);

        // 6. Search for questions
        System.out.println("\n--- (C) Combined Search: Questions by 'Tuffy' with tag 'java' ---");
        List<SearchStrategy> filtersC = List.of(
                new UserSearchStrategy(Tuffy),
                new TagSearchStrategy(javaTag)
        );
        List<Question> searchResults = service.searchQuestions(filtersC);
        searchResults.forEach(q -> System.out.println("  - Found: " + q.getTitle()));
    }

    private static void printReputations(User... users) {
        System.out.println("--- Current Reputations ---");
        for(User user : users) {
            System.out.printf("%s: %d\n", user.getName(), user.getReputation().get());
        }
    }
}
