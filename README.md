# 💻 fintech 프로젝트

사용자들이 계좌관리(계좌 입금,인출,송금 ...) 시스템을 사용 할 수있는 서비스 이다.

# 🛠️ 기술 스택
* Java jdk 11
* Spring boot 2.6.3, gradle
* Mysql , JWT , Lombok , Swagger , Docker
* IntelliJ Ultimate

---
* ## 공통
  - [ ] 회원가입
      + 사용자는 회원가입을 통해 서비스를 사용 할 수 있다.
  - [ ] 이메일 인증
      + 사용자는 이메일 인증을 통해 로그인 / 로그아웃 등 인증을 통해 사용한다.
  - [ ] 로그인/로그아웃
      + ID / PW 이메일 인증이 모두 일치하면 서비스에 로그인 한다.
      
* ## 계좌

  - [ ] 계좌 검색
      + 사용자가 가지고 있는 소유 계좌 검색이 가능해야한다.
  - [ ] 계좌 생성
      + 사용자는 한 은행에 계좌를 최대 3개 생성 할 수 있게한다.
  - [ ] 계좌 삭제
      + 사용자는 계좌 삭제시 이메일에 삭제 요청 인증 을 보내 확인 후 삭제가 가능하게 한다.
  - [ ] 계좌 인출
      + 사용자가 계좌에서 금액을 인출이 가능해야한다
      + 소유금액이 0원 이하 or 소유금액보다 많은 금액을 인출시 (잔액부족) 경고 출력
  - [ ] 계좌 입금
      + 사용자가 소유하고 있는 계좌에 입금이 가능해야함
      + 사용자의 정보와 계좌정보가 맞아야 입금이 가능해야함
      
* ## 송금

  - [ ] 계좌 송금
      + 사용자가 수취인 계좌에 송금할수 있어야함
      + 수취인 계좌 송금시 송금자가 0원이하 or 소유 금액 보다 많은 금액 송금시 (잔액부족) 경고 출력
  - [ ] 계좌 송금 이력조회
      + 송금시 ( 송금 계좌번호 , 수취인 이름 , 송금 금액 , 송금 날짜 ) 이력 생성 필요
  
* ## 추가 기능 구현

  - [ ] 예약 송금 기능
      + 해당 되는 예약 날짜에 송금 되어야 함
      + 오늘로부터 과거로는 송금 불가능
      + 예약 날 잔액이 부족시 송금 취소 및 경고 출력
  - [ ] 송금 시 메모
      + 송금시 어떤 목적으로 송금하는지 메모 작성
  - [ ] 이번 달 쓴 금액 조회
      + 월 사용 금액 축적
      + 매 월 1 일마다 축적 내용 초기화
    
    
ERD
![image](https://user-images.githubusercontent.com/80689135/236788047-a2b66905-1df7-48b4-b106-53ce2e87eb41.png)


## [TrobleShooting.md](https://github.com/TaehoLEEKR/fintech/blob/main/TrobleShooting.md)

  
  
