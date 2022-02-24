## 🌞 캐릭터 설정 화면 만들기
### 📚 1. Layout 추가하기
#### 🔖 Linear Layout
- `LinearLayout`은 세로 또는 가로의 단일 방향으로 모든 하위 요소를 정렬하는 뷰 그룹입니다. `android:orientation` 속성을 사용하여 레이아웃 방향을 지정할 수 있습니다.
- 단일 방향으로 (가로 또는 세로 방향) view를 배치할 수 있는 레이아웃
- 만약 방향을 바꾸고 싶다면 레이아웃을 하나 더 만들어서 배치해야 한다
##### 주요 속성
- gravity : View 내부의 요소들의 위치 정렬 기준을 정함
- layout_gravity : View의 위치 정렬 기준을 정함

#### 🔖 Relative Layout
- 렐러티브 레이아웃은 특정 뷰를 기준으로 상대적인 위치를 배치할 수 있다.
- 예를 들어, 다른 뷰의 오른쪽 또는 왼쪽 등을 설정하여 뷰를 배치할 수 있다.

### 📚 2. EditText 추가하기
- EditText 중에서도 여기 미션에서는 `TextInputLayout` 과 `TextInputEditText`를 활용했다.
- `TextInputEditText`은 EditText를 상속받아 모든 메서드를 활용할 수 있으며, `TextInputLayout`을 통해 좋은 룩앤삘과 아래에서 설명할 다양한 기능들을 활용할 수 있다.
#### 🔖 유용한 기능들
- label text(닉네임)
- helper text : 여기서 닉네임 조건을 설명해줌
- error message
- icons : 여기서 clear 아이콘을 주어서 쉽게 클리어할 수 있도록 함
- character counter : 제한 글자인 5글자를 알려주도록 함
- [머테리얼디자인](https://material.io/components/text-fields)

#### 🔖 필수 조건 설정하기
- EditText의 입력값을 체크하는 `addTextChangedListener(object : TextWatcher` 메서드를 활용함
- ` if ((p0?.contains("[A-Z|a-z]".toRegex())) == false) nextActivityBtn.isEnabled = false` 정규식을 써서 최소 알파벳 1글자가 포함되도록 함
- ` p0?.forEach {
  if (!it.isLetterOrDigit()) nextActivityBtn.isEnabled = false
  }` : `.isLetterOrDigit()` 함수로 각 char이 숫자 또는 문자가 아니면 버튼을 비활성화시킴

### 📚 3. 캐릭터 생성하기
- 캐릭터는 `ImageButton`를 활용함
- 각 이미지를 vector asset 추가를 통해 가져옴

#### 🔖 Image Button VS Button
- 이미지 버튼은 `이미지 뷰`를 상속받음. 버튼은 `텍스트뷰`를 상속받음
- 그래서 이미지 버튼은 눌러도 자동으로 state가 따로 seleted가 되지 않는다.
  - 그래서 실제 코드에서는 `.isSelected`를 통해 셀렉 상태를 수동으로 조절
- 이미지 버튼은 버튼의 기능보다 이미지의 기능이 더 강하다. 따라서 이미지 버튼을 눌렀을 때 이벤트 또는 액션을 수행하기 위해서는 `.setOnTouchListenr` 를 활용해야 한다. (나중에 공부하자)
- 버튼에서 이미지를 쓰려면 `background` 속성을 활용해야 한다. (그래서 미션이 `background` 구현이였나보다)

#### 🔖 background VS src
- background 
  - 이미지가 이미지뷰 사이즈에 맞춰짐
  - 패딩 값 적용 불가
- src    
  - 이미지가 원래 크기대로 보임
  - 패딩 적용 가능
  
#### 🔖 scaleType
- android:scaleType = "Center"
  - 이미지의 크기와 비율을 유지하며 이미지의 중앙을 ImageView의 중심에 맞춥니다.
- android:scaleType = "centerCrop"
  - 이미지의 비율을 유지하며 가로,세로 중 짧은 쪽을 ImageView에 꽉 차게 출력합니다.
- android:scaleType = "centerInside"
  - 이미지의 가로, 세로 중 긴 쪽을 ImageView의 레이아웃에 맞춰 출력합니다. 이미지의 비율은 유지되며 남는 공간은 background의 색으로 채워집니다.
- android:scaleType = "fitCenter"
  - centerInside와 매우 유사합니다. 단, 이미지의 크기가 ImageView보다 작다면 ImageView의 크기에 따라 달라집니다.
- android:scaleType = "fitStart"
  - ImageView 안에서 가로, 세로 비율을 유지하며 fit하게 출력됩니다.
- android:scaleType = "fitEnd"
  - fitStart와 마찬가지로 가로&세로 비율을 유지하며 fit하게 출력됩니다. 우측 하단을 기준으로 정렬됩니다.
- android:scaleType = "fitXY"
  - 가로, 세로 비율에 상관 없이 ImageView에 꽉 차게 보여집니다. 이미지가 찌그러진 상태로 보입니다.
- [출처](https://gdbagooni.tistory.com/15)
- [공식문서](https://developer.android.com/reference/kotlin/android/widget/ImageView.ScaleType)
- [ScaleToFit](https://developer.android.com/reference/kotlin/android/graphics/Matrix.ScaleToFit)

### 📚 4. 캐릭터 정보 나타내는 버튼 추가하기
- 이미지를 클릭할 때마다 해당 이미지를 다시 ImageView에 넣어 보여줌ㅁㄴ
- `background`를 설정하여 사실 이미지를 클릭할 때마다 색깔을 다르게 해서 클릭했다는 점을 알리고 싶었지만 문제가 발생하여 다음에 구현할 예정
- 눌러진 버튼을 따로 변수로 저장하고, 해당 변수값이 없으면 `다음` 버튼을 눌러도 다음 액티비티로 가는 것이 아니라 스낵바를 보여주도록 함

> 결과
![3](https://user-images.githubusercontent.com/95393311/155262912-de6e3c5c-feef-4473-a739-5888fb27c0db.gif)


## 🌞 게임 화면 구성하기
### 📚 1. Bottom navigation 추가
1. XML 코드로 Bottom navigation 추가
2. Bottom navigation에 넣을 메뉴를 새로 만들어야 함
3. res 폴더에서 새 폴더 > menu 리소스 폴더 및 XML 파일을 만든다
4. menu 안에 넣을 item들을 만든다
5. 해당 menu XML 파일의 이름을 Bottom navigation과 연결하면 만들어진다.

### 📚 2. Top App bar 추가 추가
1. ToolBar를 추가하기 위해서는 공식 문서에서는 Coordinator layout과 Appbar layout을 추가하도록 설명했는데, 현재 미션에서는 따로 상호작용 및 디테일한 디자인 작업은 하지 않을 계획이므로 바로 Toolbar 코드를 넣어 생성함
2. title, 스타일 등 속성을 부여
3. 기존에 정의된 액션바를 보이지 않게 하기 위해 manifest.xml 에서 NoActionBar를 추가해준다.

#### Coordinator layout이란?
- CoordinatorLayout은 아래 두 가지 경우에 사용하기 위해 의도되었는데!
    - 화면의 최상위 부분을 꾸미거나 크롬 레이아웃을 사용하기 위해 사용된다.
        - 여기서 화면의 최상위 부분이라는 것은 안드로이드 화면에 배치되는 최상위 위젯을 의미하는데 AppbarLayout 이나 FloatingActionButton 이 최상위 위젯에 속한다.
    - 하나 이상의 자식 뷰와 어떤 특별한 상호작용을 하기 위한 컨테이너로 사용된다.
        - 또한 하나 이상의 자식 뷰와 특별한 상호작용이라는 말의 뜻은 리사이클러뷰를 위로 스크롤하면 AppBar가 사라지고, 아래로 스크롤하면 AppBar가 나타나는 효과 를 생각해보면 될 것 같다!

### 📚 1. Fragment 추가하기
#### 🔖 Fragment
- Fragment는 FragmentActivity 내의 어떤 동작 또는 사용자 인터페이스의 일부를 나타냅니다. 여러 개의 프래그먼트를 하나의 액티비티에 결합하여 창이 여러 개인 UI를 빌드할 수 있으며, 하나의 프래그먼트를 여러 액티비티에서 재사용할 수 있습니다. 프래그먼트는 액티비티의 모듈식 섹션이라고 생각하면 됩니다. 이는 자체적인 수명 주기를 가지고, 자체 입력 이벤트를 수신하고, 액티비티 실행 중에 추가 및 삭제가 가능합니다(다른 액티비티에 재사용할 수 있는 "하위 액티비티"와 같은 개념).
- 여러 종류의 기기에서 다양한 레이아웃 형태로 보여주기 위한 용도를 가짐
- 프래그먼트는 단독으로 쓸 수 없고 호스팅 액티비티 (주인) 또는 다른 프래그먼트에 의해 호스팅되어야 한다.
- 특정 액티비티에 종속되지 않고 여러 개의 액티비티에서 사용될 수 있어 재사용성이 좋다
- 그런만큼 다른 프래그먼트나 액티비티에 의해 변경되면 안된다.

#### 🔖 Fragment 추가하는 방법
- 먼저 특정 액티비티 레이아웃에 fragment 영역을 보여줄 레이아웃을 추가한다
- fragment 레이아웃을 추가하고 꾸민다
- alt + insert를 통해 기본 fragment 클래스를 생성하고 `view = inflater.inflate(R.layout.fragment_character, container, false)` 에 연결할 레이아웃 ID를 넣어준다
- 호스트로 지정할 액티비티에서 Fragment 매니저를 활용한다.
`supportFragmentManager.commit {
  replace(R.id.layout_fragment, CharacterFragment())
  }`

#### 🔖 FragmentManger 란?
- 액티비티 간의 통신을 intent 객체가 담당하듯이 액티비티 - 프래그먼트 또는 프래그먼트 - 프래그먼트 간의 통신은 FragementManger를 통한다.
- 이 때, 사용되는 단위는 transaction이다

#### 🔖 Fragment Transaction 이란?
- 프래그먼트 트랜잭션 클래스는 프래그먼트 추가/교체/삭제 작업을 제공
- 이 외에도 프래그먼트 트랜잭션은 프래그먼트 관리자가 수행할 단일 단위
- 하나의 프래그먼트 트랜잭션 단위 내에 프래그먼트 트랜잭션 클래스가 제공하는 프래그먼트 추가/교체/삭제 작업 등을 명시하면 됩니다.

### 📚 2. Fragment간 화면 이동하기
- `.setOnItemSelectedListener`메서드로 네비게이션의 destination 클릭할 때마다 `fragment매니저의 replace()`를 통해 지정된 프래그먼트를 보여줌

### 📚 3. 액티비티-액티비티, 액티비티-프래그먼트 간 데이터 전달
#### 🔖 액티비티-액티비티 간 데이터 전달
1. 액티비티 간에 데이터를 전달하기 위해서는 `intent`와 `putExtra()` 메서드를 활용하면 된다.
2. 수신할 때도 마찬가지로 `intent.get[데이터타입]Extra()`를 활용하면 된다.

#### 🔖 액티비티-프래그먼트 간 데이터 전달 (여기에서 문제가 발생)
1. 액티비티와 프래그먼트 간에 데이터를 전달하기 위해서는 `Bundle` 객체를 활용하면 된다.
```
<데이터를 전달하는 액티비티>
val nickname = intent.getStringExtra("nickname")!!
        val image = intent.getByteArrayExtra("character")!!
        val bundle = Bundle()
        bundle.putString("name", nickname)
        bundle.putByteArray("char", image)
        charFragment.arguments = bundle
        
<데이터를 받는 프래그먼트>
        val nickname = arguments?.getString("name")
        val image = arguments?.getByteArray("char")      
```

> 이 부분에서 몇 시간을 헤맸는데, 자꾸 프래그먼트에서 값을 null로 받아들인 문제가 발생했었다. 그리고 마침내 해결했는데,
```
R.id.setting -> {
    transferDataTofragment()
    supportFragmentManager.commit {
        replace(R.id.layout_fragment, CharFragment())
    }
true

R.id.setting -> {
    transferDataTofragment()
    supportFragmentManager.commit {
        replace(R.id.layout_fragment, charFragment)
    }
true
```
> 여기에서 `charFragment` 를 `CharFragment()`로 해서 자꾸 데이터가 null 값으로 수신했었음. 추측하기로는 객체가 만들어지기 전에 전달을 해서 값이 제대로 수신되지 않았던 것으로 보임


#### 🔖 데이터 전달은..
- 액티비티-액티비티, 액티비티-프래그먼트 간 데이터 전달은 모두 `키-값` 타입으로 전달된다.

### 📚 4. 버튼누르면 특정 웹브라우저로
- 암시적 인텐트를 활용하면 된다.
```
 charBtn.setOnClickListener {
            val webpage: Uri = Uri.parse("https://codesquad.kr/")
            val intent = Intent(Intent.ACTION_VIEW,webpage)
            startActivity(intent)
```
> 결과
![6](https://user-images.githubusercontent.com/95393311/155262179-bc5f6cfd-f076-4554-9553-17f765471e6b.gif)

