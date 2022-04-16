# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 요구사항
1. 1~9 사이의 서로다른 수로 이루어진 3자리 숫자를 맞추는 게임
2. 같은 자리에 숫자가 있으면 스트라이크
3. 다른 자리에 숫자가 있으면 볼
4. 같은 숫자가 없으면 낫싱
5. 세자리 숫자와 숫자의 위치를 모두 맞추면 성공이며, 해당회자의 게임이 종료된다.
6. 종료된 이후에는 게임을 새로 시작하거나, 완전히 종료할 수 있다.

## 설계
1. 게임 서비스와 도메인, 뷰 로 구분
2. 게임 서비스
   1. 메인 게임 서비스 : 전체 시스템을 운영
3. 도메인
   1. 플레이어
      1. 세 자리 수
         1. 1차 안 : Map으로 구성 (key: 숫자 , value: index)
            - 비효율적 구성
         2. 2차 안 : LinkedHashSet으로 구성
            - 장점 : 순서O, 중복X 보장
            - Index가 없어 비교시 2depth 요구조건 위반
         3, 3차 안 : List로 구성
            - contains로 중복 검사
   2. 난수발생기
   3. 예외
   4. 게임
      1. 플레이어간의 스트라이크, 볼, 낫싱 계산
4. 뷰
   1. 입력기: 플레이어로부터 세자리수를 입력받음
   2. 분석기: 입력받은 String을 원하는 DTO로 Parsing
## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
