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

### 📚 2. EditText 추가하기

#### 🔖 유용한 기능들
- label text(닉네임)
- required (필수)
- helper text
- error message
- icons
- character counter
- [머테리얼디자인](https://material.io/components/text-fields)

### 📚 3. 캐릭터 생성하기

### 📚 4. 캐릭터 정보 나타내는 버튼 추가하기





## 🌞 게임 화면 구성하기

### 📚 1. Bottom navigation 추가
1. XML 코드로 Bottom navigation 추가
2. Bottom navigation에 넣을 메뉴를 새로 만들어야 함
3. res 폴더에서 새 폴더 > menu 리소스 폴더 및 XML 파일을 만든다
4. menu 안에 넣을 item들을 만든다
5. 해당 menu XML 파일의 이름을 Bottom navigation과 연결하면 만들어진다.

### 📚 2. Top App bar 추가 추가

### 📚 1. Fragment 추가하기
#### 🔖 Fragment
- Fragment는 FragmentActivity 내의 어떤 동작 또는 사용자 인터페이스의 일부를 나타냅니다. 여러 개의 프래그먼트를 하나의 액티비티에 결합하여 창이 여러 개인 UI를 빌드할 수 있으며, 하나의 프래그먼트를 여러 액티비티에서 재사용할 수 있습니다. 프래그먼트는 액티비티의 모듈식 섹션이라고 생각하면 됩니다. 이는 자체적인 수명 주기를 가지고, 자체 입력 이벤트를 수신하고, 액티비티 실행 중에 추가 및 삭제가 가능합니다(다른 액티비티에 재사용할 수 있는 "하위 액티비티"와 같은 개념).
- 여러 종류의 기기에서 다양한 레이아웃 형태로 보여주기 위한 용도를 가짐

