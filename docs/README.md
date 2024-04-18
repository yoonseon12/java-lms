# 기능 목록

- [x] 무료 강의 수강 신청
- [x] 유료 강의 수강 신청
  - [x] 강의 최대 수강 인원을 초과한 경우 수강 신청 불가
  - [x] 결제 금액과 수강료가 일치하지 않는 경우 수강 신청 불가
- [x] 모집 중이 아닌 강의인 경우 수강 신청 불가
  - [x] 강의 진행 상태(준비중, 진행중, 종료)와 모집 상태(비모집중, 모집중)로 상태 값을 분리
- [x] 시작일이 지난 강의인 경우 수강 신청 불가
- [x] 커버 이미지
  - [x] 이미지 크기가 1MB를 초과하는 경우 업로드 불가
  - [x] 이미지 타입은 gif, jpg(jpeg 포함), png, svg만 허용
  - [x] 이미지의 width는 300픽셀, height는 200픽셀 이상이어야 하며, width와 height의 비율은 3:2여야 함
- [x] 강의 승인
  - [x] 선발된 인원은 모두 수강 신청
  - [x] 선발되지 않은 인원이 수강 신청한 경우 강사가 취소

# DB 설계

- [x] 도메인 모델 DB 테이블과 매핑

# 리팩토링

- [x] 추가한 도메인들에 대한 저장 로직을 각각의 Repository를 생성하여 처리
  - [x] Enrollment
  - [x] Session
- [x] 강사가 수강 신청 승인 혹은 취소를 할 때 강의를 생성한 강사가 하도록 변경
- [x] 추가된 비즈니스 로직들의 처리 결과가 DB에도 잘 반영이 되는지 확인