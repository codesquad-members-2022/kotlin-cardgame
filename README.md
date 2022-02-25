# kotlin-cardgame

## 요구사항 파악

- [x] 캐릭터 리소스 vector asset 이용하기
- [x] 닉네임 입력을 위해 EditText 추가 및 제한 조건 설정
  - [x] 입력값은 반드시 필요
  - [x] 닉네임은 최대 5글자까지
  - [x] 공백 및 특수문자 제외
  - [x] 숫자만 포함하면 안되고, 적어도 알파벳 한글자는 포함하기
- [x] 캐릭터는 4가지 버튼이 필요하며 반드시 하나를 선택해야 한다.
  - [x] 버튼의 상태를 표시할 방법을 결정하기
  - [x] 선택한 캐릭터는 버튼 하단에 큰 사이즈로 보여주기
- [x] 다음 버튼 클릭시 캐릭터 정보 넘겨주기
  - [x] 넘긴 정보 출력하기
- [x] 두번째 액티비티에서 도움말 버튼 클릭시 인터넷 연결
- [x] Fragment로 화면 구성하기
- [x] bottom navigation 컴포넌트와 함께 화면 이동 구현하기
- [ ] jetpack navigation을 적용해보기
- [x] 카드 데이터를 추상화해서 클래스로 구현하고 확장하기
  - [x] 속성으로 과일 4개(apple, oragne, cherry, grape) 중 하나, 숫자 1-10 중 하나 가지기
  - [x] 모양이나 숫자도 데이터 구조로 표현하기(class, enum, sealed class로 가능)
  - [x] 카드 정보 출력을 위한 문자열 반환 함수 만들기
  - [x] 문자열에서 1은 A, 10은 X로 표시하기
- [x] 카드 덱 구현하기
  - [x] 카드 덱의 총 개수를 반환하는 count()
  - [x] 카드를 섞어주는 shuffle()
  - [x] 카드 하나를 반환하고 삭제하는 removeOne()
  - [x] 카드를 초기화시키고 섞는 reset()
- [x] 카드 게임 카드모드(2, 3, 4) 버전 만들기
  - [x] 카드 게임 유저 인터페이스 구현하기
    - [x] 토글 버튼으로 2카드, 3카드, 4카드 버전
    - [x] Player 3명의 카드를 UI를 보여주기 / Player의 이름은 랜덤으로 생성
    - [x] 로봇의 카드 3개 보여주기
    - [x] 우승자 카드 옆에 메달 보여주기
---

### 캐릭터 설정 화면 만들기

![ezgif com-gif-maker](https://user-images.githubusercontent.com/66770613/155053319-7407cf3e-c203-41c6-83f6-493877f5aea3.gif)  


### 게임 화면 구성하기

<img width="308" alt="스크린샷 2022-02-22 오후 4 52 26" src="https://user-images.githubusercontent.com/66770613/155086821-d844d95b-928b-47c5-a614-01aed4ed29eb.png">  


<img width="308" alt="스크린샷 2022-02-22 오후 4 52 32" src="https://user-images.githubusercontent.com/66770613/155086875-22f9fa83-0e7f-45a1-9566-f3fdb563539b.png">  

### 완성 구현

![ezgif com-gif-maker](https://user-images.githubusercontent.com/66770613/155742560-0a3c3a59-db3c-4eed-bbaf-87c2ca384c65.gif)

