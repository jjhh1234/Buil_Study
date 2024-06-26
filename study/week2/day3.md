## 1. 추상클래스

+ **설계도**
+ 클래스들의 공통적인 특성을 추출해서 선언한 클래스
+ 공통된 필드와 메소드의 이름을 통일할 목적
+ 실체 클래스를 작성할 때 시간 절약
+ 하나 이상의 추상메소드를 포함하는 클래스(추상메소드가 없어도 abstract를 붙이면 추상 클래스가 된다)
  
![image](https://github.com/jjhh1234/Buil_Study/assets/105401500/c3468863-45e4-4dc4-a6c2-ad6d0e182535)

## 2. 추상클래스 선언

+ 필드, 생성자, 메소드 존재 (일반적인 클래스와 동일)
+ new 연산자를 이용해 객체 생성 불가
+ 상속을 통해 자식 클래스만 생성 가능

```
public abstract class 클래스{

}
```

## 2-1. 추상클래스 객체 생성 불가 이유

+ 위에서 우리는 추상클래스를 실체클래스들의 공통적인 특성들을 추출해 놓은 **설계도** 라고 정의 했다.
+ 공통적으로 추출된 내용들은 예를 들면 '웃는다' , '화를낸다', '슬퍼한다' 등이 있을 것이다.
+ 이를 각각의 실체 클래스 들에서 구현하면 A 클래스에서는 '이가 환히 보이게 웃는다' , B 클래스에서 '조용이 미소지으며 웃는다' , C 클래스에서 '소리내어 웃는다' 라고 정의 된다 때문에 공통적인 특성들을 크게 보면 **규격** 에 가깝다.
+ 이처럼 추상클래스의 공통적인 추출 내용은 말 그대로 **추상적** 이고 실체가 없는 미완성 클래스 이기에 이것으로는 객체를 생성할수가 없는것이다. 
+ 오버라이딩 하지 않으려면 자식클래스도 똑같이 abstract 키워드로 추상클래스가 되어야함 

## 3. 추상메소드와 재정의

+ **자식클래스는 반드시 추상메소드를 재정의해서 사용해야함**
+ Animal 추상클래스에서 sound() 라는 추상메소드를 정의하고 실체클래스에서 직접 작성해야함

```
public abstract class Animal{ // 추상 클래스 선언
  public String kind;

public void breath(){
  System.out.println("숨을 쉽니다");
  }

public abstract void sound(); // 추상 메소드 선언

----------------------------------------------------------------------------------------------------------

public class Cat extends Animal{

public Cat(){  // 생성자 초기값 지정
    this.kind = "포유류";  // 이거 super도 가능하고 this도 가능함 
}

  @Override //  추상 메소드 재정의
  public void sound(){
  System.out.println("야옹");
      }
    }
  }

```

