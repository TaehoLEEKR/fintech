Troble Shooting 
---
개발 중 생기는 이슈 모음 작성

## CREATE ISSUE
* 1.계좌 생성시 정보는 입력되고 계좌번호가 save 될 때 만들어진 랜덤코드가 아닌 pk 로 수정되서 DB에 접속됨



## Solved Thinking Issue
* 계좌번호를 PK 로 두지말고 새로운 인조 pk 를 생성하여 만든뒤 계좌번호를 따로 관리 한다.
