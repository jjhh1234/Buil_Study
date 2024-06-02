# 레이아웃 뷰

## 1.LinearLayout
+ 뷰를 가로나 세로 방향으로 나열하는 레이아웃 클래스
+ horizontal : 가로 
+ vertical : 세로

### 1-1. layout_weight 속성
+ 화면에 생기는 여백을 뷰로 채우는 속성
+ layout_weight에 지정된 숫자는 뷰가 차지하는 여백의 비율을 의미

```
//여백의 비율을 1로 두고 1만큼 차지

<Button
android:layout_weight = "1"
/> 
```  

