# kotlin-cardgame

- 요구사항 파악
- 구현 완료 후 자신의 github 아이디에 해당하는 브랜치에 PR을 통해 코드 리뷰 요청
- 코드 리뷰 피드백에 대한 개선 작업 후 push
- 모든 피드백 완료 후 다음 단계를 도전하고 이전 과정 반복

---

# 추가 학습내용 

<br></br>
## ConstraintLayout

- RelativeLayout 의 상대적 위치 관계에 따른 배치 기능
- LinearLayout 의 가중치 기능
- Chain 을 사용해 다른 레이아웃 없이 요소드를 그룹화 가능

### Chain

: 위젯들 끼리 제약 조건으로 묶임

1. Spread
    - 양 옆 마진을 계산하고 위젯들끼리 남은 공간을 균등히 할당 받음
2. Spread Inside
    - 양 옆 마진 없이 위젯들끼리 공간을 균등히 할당 받음
    - 마진값 보다 우선시 됨
3. Weighted
    - spread or spredInside 설정후 맞추고 싶은 높이 혹은 너비를 0dp 설정
    - weight 를 통해서 체우기
4. Packed
    - 연결 된 위젯들끼리 붙게됨
    - 마진으로 조절
    - 가운데로 붙지 않고 치우쳐서 붙을 수 있음(layout_constraintHorizontal_bias = 0 일시 왼쪽 정렬)


1.  문제상황
    View 의 크기를 구해서 특정 작업을 진행하려는데 계속 view의 크기가 0 이라는 답을 얻었다. 문제를 확인해보니 View가 그려지기 전에 그 크기에 접근했기 때문이라고 한다. 실제로 View 는 onResume 에서 그려지기 때문에 이를 위해서 ViewTreeObserver 를 사용했다.

<br></br>

## 2.  ViewTreeObserver

### 문제 상황
View 의 크기를 구해서 특정 작업을 진행하려는데 계속 view의 크기가 0 이라는 답을 얻었다. 문제를 확인해보니 View가 그려지기 전에 그 크기에 접근했기 때문이라고 한다. 실제로 View 는 onResume 에서 그려지기 때문에 이를 위해서 ViewTreeObserver 를 사용했다.

### ViewTreeObserver 요약
이름 그대로 ViewTree에 대한 옵저버 역할을 하며 옵저버의 리스너를 등록하면 ViewTree 의 변화를 감지할 수 있다. 
리스너로는 아래와 같은 리스너를 선택하여 변화를 감지 할 수 있다.

### 3. 주의점
ViewTreeObserver.XX 의 리스너를 생성하고 등록한뒤에는 반드시 remove 해주는 것 이 필요하다.
제거해주시 않으면 어떤 리스너를 생성하던 끊임 없이 호출되어 메모리를 낭비할 수 있다.
그리고 이때 OnDrawListener 를 채택하여 사용하였는데 draw 리스너는 리스너의 삭제를 오버라이딩 한 공간에서 할 수 없는지라 대체로 OnGlobalLayoutListener 를 선택 해서 사용했다.
이에 대한 정확한 이유는 찾지 못했다.....
