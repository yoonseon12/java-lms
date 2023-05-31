package nextstep.qna.domain;

import nextstep.fixture.TestFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class QuestionRepositoryTest {

    @Autowired
    QuestionRepository questionRepository;

    @DisplayName("id 로 조회한다")
    @Test
    public void findByQuestionId() {
        //given
        Question q = TestFixture.BADAJIGI_QUESTION;
        questionRepository.save(q);
        //when
        Question save = questionRepository.findByQuestionId(new QuestionId(1L)).get();
        //then
        System.out.println(save);
    }

    @DisplayName("findAll")
    @Test
    public void findAll() {
        //given
        //when
        questionRepository.findAll();
        //then
    }

    @DisplayName("save")
    @Test
    public void save() {
        //given
        Question question = TestFixture.BADAJIGI_QUESTION;
        //when
        Question save = questionRepository.save(question);
        //then
        System.out.println(save.toString());
    }
}