package nextstep.qna.domain;

import nextstep.qna.CannotDeleteException;
import nextstep.users.domain.NsUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Answers {

    private List<Answer> answers;

    public Answers() {
        this.answers = new ArrayList<>();
    }

    public Answers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<DeleteHistory> delete(NsUser loginUser) throws CannotDeleteException {
        for (Answer answer : answers) {
            validateAnswerOwner(loginUser, answer);
        }

        return answers.stream()
                .map(Answer::delete)
                .collect(Collectors.toList());
    }

    private void validateAnswerOwner(NsUser loginUser, Answer answer) throws CannotDeleteException {
        if (!answer.isOwner(loginUser)) {
            throw new CannotDeleteException("다른 사람이 쓴 답변이 있어 삭제할 수 없습니다.");
        }
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }
}
