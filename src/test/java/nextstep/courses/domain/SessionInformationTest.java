package nextstep.courses.domain;

import nextstep.courses.domain.session.Period;
import nextstep.courses.domain.session.SessionInformation;
import nextstep.courses.exception.CanNotApplyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static nextstep.courses.domain.session.SessionStatus.*;
import static nextstep.courses.domain.session.SessionType.*;
import static org.assertj.core.api.Assertions.*;

class SessionInformationTest {

    @DisplayName("모집 중이 아닐 때 수강신청할 경우 예외가 발생한다.")
    @Test
    void should_be_being_recruited_when_applying_for_session() {
        Period period = new Period(LocalDateTime.now(),
                                   LocalDateTime.now().plusHours(1));
        SessionInformation information = new SessionInformation(PREPARING, FREE, period);

        assertThatThrownBy(information::validateApply)
                .isInstanceOf(CanNotApplyException.class);
    }
}