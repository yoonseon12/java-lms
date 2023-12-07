package nextstep.courses.domain;

import java.math.BigDecimal;
import nextstep.users.domain.NsUser;

public class PaidLecture implements Lecture {
  private final LectureType lectureType = LectureType.PAID;
  private final Long id;
  private final String title;
  private final CoverImage coverImage;
  private final LectureStatus lectureStatus;
  private final RegistrationPeriod registrationPeriod;
  private final BigDecimal price;
  private final Integer limitStudentCount;
  private final Students students = Students.defaultOf();; // 강의 기본정보와는 다름


  public PaidLecture(Long id, String title, CoverImage coverImage, LectureStatus lectureStatus,
      RegistrationPeriod registrationPeriod, BigDecimal price, Integer limitStudentCount) {
    this.id = id;
    this.title = title;
    this.coverImage = coverImage;
    this.lectureStatus = lectureStatus;
    this.registrationPeriod = registrationPeriod;
    this.price = price;
    this.limitStudentCount = limitStudentCount;
  }

  @Override
  public boolean isFree() {
    return LectureType.FREE.equals(this.lectureType);
  }

  @Override
  public boolean recruiting() {
    return LectureStatus.RECRUITING.equals(this.lectureStatus);
  }

  @Override
  public void enrollment(NsUser nsUser) {
    if (!recruiting()) {
      throw new IllegalArgumentException("모집중이지 않습니다.");
    }
    nsUser.hasPayment(price);
    students.addWithLimitCount(nsUser, limitStudentCount);
  }

  @Override
  public Lecture start() {
    return new PaidLecture(this.id,this.title,this.coverImage,LectureStatus.RECRUITING, this.registrationPeriod,this.price,this.limitStudentCount);
  }

  @Override
  public Integer numberOfStudent() {
    return students.size();
  }

}
