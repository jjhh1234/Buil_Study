# 레이아웃 뷰

## 1.LinearLayout
+ 뷰를 가로나 세로 방향으로 나열하는 레이아웃 클래스
+ horizontal : 가로 
+ vertical : 세로

### 1-1. layout_weight 속성

+ 화면에 생기는 여백을 뷰로 채우는 속성
+ layout_weight에 지정된 숫자는 뷰가 차지하는 여백의 비율을 의미
+ 뷰의 크기를 0으로 하고 설정하기 도 함(화면 전체가 여백이됨, 가로.세로 중 하나만 0으로 함)
+ 만들어진 속성이 포함된 뷰의 갯수에 따라 비율이 나눠짐(속성이 포함된 뷰가 2개면 하나당 1/2 비율을 가짐)
+ 뷰가 수평방향으로 여러개인 상황에서 비율을 아무리 늘려도 화면에 변화가 없는 순간이 오는데 다른 뷰들이 기본값을 유지하기 때문

```
//여백의 비율을 1로 두고 1만큼 차지

<Button
android:layout_weight = "1"
/> 
```  

### 1-2. gravity, layout_gravity 속성

+ 뷰를 정렬할때 사용되는 속성
+ 왼쪽 위를 기준으로 정렬
+ gravity : 콘텐츠를 정렬
+ layout_gravity : 뷰 자체를 정렬
+ LinearLayout 애서 뷰를 화면 중앙 배치하려면 레이아웃에 gravity="center" 을 설정해야 함 (이렇게 설정할 경우엔 작용이 안되진 않고 적용됨) 

```
android:gravity = "right|bottom" //콘텐츠를 오른쪽 아래에 위치

// 주의) LinearLayout 자체가 방향으로 뷰를 배치하기 때문에 LinearLayout의 같은 방향(orientation)으로는 layout_gravity의 속성이 적용 되지 않음
// orientation이 vertical 이면 layout_gravity="center" 은 가로 방향으로 중앙 정렬됨

android:layout_gravity="center_vertical" //뷰를 세로 중앙에 배치
```

## 2. RelativeLayout
+ 화면에 이미 출력된 특정 뷰를 기준으로 방향을 지정하여 배치
+ 각 속성에 입력하는 값은 기준이 되는 뷰의 id

```
android:layout_above = "" // 기준 뷰의 위쪽에 위치

android:layout_below = "" // 기준 뷰의 아래쪽에 위치

android:layout_toLeftOf = "" // 기준 뷰의 왼쪽에 위치

android:layout_toRightOf = "" // 기준 뷰의 오른쪽에 위치
```

## 2-1. align속성
+ 상대뷰를 기준으로 위치를 정하고 기준뷰의 어떤 쪽으로 맞출 건지 정하눈 속성

```
android:layout_alignTop="" // 기준 뷰와 위쪽을 맞춤 

android:layout_alignBottom="" // 기준 뷰와 아래쪽을 맞춤 

android:layout_alignLeft="" // 기준뷰와 왼쪽을 맞춤

android:layout_alignRight="" // 기준 뷰와 오른쪽을 맞춤 

android:layout_alignBaseLine="" // 기준 뷰와 텍스트 기준 선을 맞춤
```

```
//상위 레이아웃을 기준으로 맞춤 정렬하는 속성(뷰를 부모 영역의 오른쪽 또는 아래쪽에 붙이고 싶을 때 사용하느 속성)

android:layout_alignParentTop="" // 부모의 위쪽에 맞춤 

android:layout_alignParentBottom="" // 부모의 아래쪽에 맞춤

android:layout_alignParentRight="" // 부모의 오른쪽에 맞춤

android:layout_alignParentLeft="" // 부모의 왼쪽에 맞춤

android:layout_centerHorizontal="" // 부모의 가로 방향 중앙에 배치 (값은 true로 입력)

android:layout_centerVertical="" // 부모의 세로 방향 중앙에 배치

android:layout_centerInParent="" // 부모의 가로.세로 중앙에 배치
```

## 3. FrameLayout
+ 뷰를 겹쳐서 배치하는 레이아웃 클래스
+ 위치를 조절하거나 그런 특별한 속성이 없음
+ 보통 이벤트 처리코드로 버튼을 누르면 보이게하거나 없어지게 하거나 할때 사용

## 4. GridLayout
+ 행과 열로 구성된 테이블 화면을 만드는 레이아웃 클래스
+ gridlayout에 추가한 뷰의 크기는 자동적으로 wrap_content이므로 넓이를 지정하지 않아도 오류 발생X
+ 줄바꿈을 자동으로 해줌
+ orientation : 방향 설정 (방향 설정에 따라 row, column 줄바꿈 결정됨)
+ rowCount : 세로로 나열할 열 개수
+ columCount : 가로로 나열할 행 개수

### 4-1. 특정 뷰의 위치 조정하기 (사진으로 보강)
+ layout_row(행) : 뷰가 위치하는 세로 방향 인덱스 
+ layout_column(열) : 뷰가 위치하는 가로 방향 인덱스

### 4-2. 특정 뷰의 크기 확장하기 (사진으로 보강)

```
android:layout_gravity = "fill_horizontal" // 뷰를 확장해서 출력(옆에 뷰가 없고 여백이 있어야 적용 가능)
```

### 4-3. 열이나 행 병합하기
+ 어떤 뷰가 테이블에서 여러칸 차지가능

```
android:layout_columSpan="2" //가로로 열 병합 (인덱스 값이므로 0부터 시작)

android:layout_rowSpan="1" //세로로 열 병합 
```

## 5. ConstraintLayout
+ 계층 구조로 배치하는 레이아웃 클래스
+ 가장 많이 사용되는 레이아웃 클래스
+ 절대적 위치가 아니라 상대적 위치를 지원하기 때문에 크기가 다른 핸드폰마다 같은 화면 공유 가능
+ 다른 레이아웃 뷰들은 뷰의 깊이 때문에 메모리에서 뷰 계층 구조를 계산할때 시간이 오래 걸리지만 constraint는 계층구조가 깊지 않기 때문에 메모리 부하가 적음

### 5-1) Relative positioning(상대적 위치 지정)
+ 이 속성을 사용하고 마진을 사용하고 싶으면 모든 방향 기준을 정해주어야 사용 가능

```
app:layout_constraintLeft_toLeftOf : 해당 뷰의 왼쪽을 지정된 요소의 왼쪽과 맞춤
// 나머지도 저런식

app:layout_constraintStart_toStartOf : 해당 뷰의 시작 위치를 지정된 요소의 시작 위치와 맞춤

app:layout_constraintStart_toEndOf : 해당 뷰의 시작 위치를 지정된 요소의 끝 위치와 맞춤

app:layout_constraintBaseline_toBaselineOf : 해당 뷰와 지정된 요소의의 문자열 기준선을 맞춤
```

### 5-2) margins 와 관련된 속성

```
app:layput_goneMarginLeft : 해당 뷰의 왼쪽에 지정된 요소의 visibility가 gone 상태일 때 의 여백을 지정
```

### 5-3) centering positioning과 관련된 속성(중앙 위치지정, bias)
+ constraint 에서 방향 겅어주려면 전부 기준 잡아야 하는듯? 
+ 중앙정렬이 되도록 하기 위해서는 양쪽 방향으로 제약을 동시에 걸어주면 됨 
+ 수평방향 중앙 : 왼쪽과 오른쪽 제약 동시
+ 수직방향 중앙 : 위쪽과 아래쪽 제약 동시 

```
// 기준 방향으로 제약 조건 걸어주기
app:layout_constraintLeft_toLeftOf = "parent" //왼쪽 제약 조건 걸기
app:layout_constraintRight_toRightOf = "parent" //오른쪽 제약 조건 걸기

app:layout_constraintHorizonral_bias ="0.25" // 수평방향으로 치우침강도 조절
app:layout_constraintVertical_bias = "" // 수직방향 치우침 강도 조절
```

### 5-4) Chains 관련된 속성
+ 수평 또는 수직방향으로 연결된 뷰를 그룹처럼 다룰 수 있음
+ 뷰들 간에 양방향으로 연결 되면 chain 으로 인식
+ 첫번째 요소에 설정된 속성의 의해서 제어됨 

```
app:layout_constraintHorizontal_chainStyle : 수평방향에 체인 연결 형태를 지정 (spread, spread_inside, packed) 
```

![image](https://github.com/jjhh1234/Buil_Study/assets/105401500/3b45ab4a-07fc-4880-b4bd-9187ba36de11)

```
app:layout_constraintHorizontal_weight : match_constraint(= 0dp)를 사용하는 요소중 수평방향 여백을 차지하는 비율
app:layout_constraintVertical_weight : match_constraint(= 0dp)를 사용하는 요소중 수직방향 여백을 차지하는 비율
```

