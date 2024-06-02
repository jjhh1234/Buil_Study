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
+ LinearLayout 애서 뷰를 화면 중앙 배치하려면 레이아웃에 gravity="center" 을 설정해야 함

```
android:gravity = "right|bottom" //콘텐츠를 오른쪽 아래에 위치

// 주의) LinearLayout 자체가 방향으로 뷰를 배치하기 때문에 LinearLayout의 같은 방향(orientation)으로는 layout_gravity의 속성이 적용 되지 않음

android:layout_gravity="center_vertical" //뷰를 세로 중앙에 배치
```

