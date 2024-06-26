## 1. API
+ **라이브러리**
+ 프로그램 개발에 자주 사용되는 클래스 및 인터페이스의 모음 (java.lang , java.util 등)
+ [자바 API 문서](https://docs.oracle.com/en/java/javase/index.html)

## 2.java.lang 패키지
+ 자바 프로그램의 **기본적인 클래스**를 담고있는 패키지
+ java.lang 패키지 안에 클래스와 인터페이스는 import 없이 사용 가능(ex. String, System 클래스 등)
+ **Object, System, Class, String, Wrapper, Math 등**

### 2_1. Object 클래스
+ **자바의 최상위 부모클래스**
+ 자바의 모든 클래스는 **Object 클래스의 자식이거나 자손 클래스**

![image](https://github.com/jjhh1234/Buil_Study/assets/105401500/27ac43ab-5472-468c-9d1a-8f6a5c4b6dec)

### 2-1_1. 객체비교 equals() - Object 클래스의 equal 메소드
+ eaual메소드의 매개타입은 Object 인데 이것은 모든 객체가 매개값으로 대입될 수 있음을 의미
+ 비교연산자 '==' 와 동일한 값을 리턴

```
Object obj1 = new Object(); // obj1의 주소값에 해당하는 데이터를 생성
Object obj2 = new Object(); //obj2에 주소값에 해당하는 데이터를 생성

boolean result = obj1.equals(obj2);

boolena result = (obj1 == obj2);

// 결과값은 동일하지 않다고 나옴

```

### 2-1_2. instanceof 함수
+ 기준이 되는 객체가 해당 클래스의 타입이거나 해당 타입을 상속 받는 객체인 경우 사용
+ **비교는 실체 객체 클래스 기준으로 이루어짐 Q참고**

```
public class Member{ //멤버 클래스 선언

  public String id; //필드 id 선언

  public Member(String id){ //생성자 선언
    this.id = id;
}

  @Override // 재정의
  public boolean equals(Object obj){ // Object 클래스의 equal 클래스 재정의, Object 타입의 매개변수 obj

    if(obj instanceof Member){ // obj의 타입이 Member거나 Member를 상속 받는 객체라면

    Member member = (Member) obj; // obj를 강제 형변환 으로 Member로 만들어서 member에 담음(자식클래스로 변환 or 타입변환)

    if(id.equals(member.id)){ // 이후 id 값이 동일하다면 ture 반환
      return true;
    }
  }
return false;
}
}
```

### Q) instanceof가 기준객체의 타입이 비교타입의 클래스와 동일하거나 해당 클래스의 자식클래스일때 if문이 이루어진다면 왜 강제 형변환을 하는가?, Member member = (Member) obj는 결국 obj 라는 자식클래스를 부모클래스로 강제 형변환 하겠다는건데 강제 형변환은 상속 관계있는 부모가 자식으로 강제 형변활 될때 사용하는것이라고 알고있는데 이것이 왜 가능한가
+ **A) 강제형변환은 그렇게 이루어지는 것이 맞다. 해당 문제의  메소드를 사용할 때 Object는 최상위 타입이기 때문에 매개변수값으로 어떤 타입의 객체가 와도 상관이 없다. 만약 Test를 상속하는 test 클래스의 객체가 매개변수로 들어와서 Object로 형변환 됐다면 그건 최상위 클래스가 된다는 의미, 따라서 부모타입을 자식타입으로 강제형변환을 해준다는 정론이된다. 그럼 instanceof의 기능은 잘못되지않았냐는 궁금증이 생기는데 instanceof의 정확한 기능은 기준객체의 실체객체 타입을 타입과 비교하는 것이다. 이렇게 되면 아무 문제가 생기지 않음 **

### Q) equal을 저렇게 재정의 해도 되느냐?
+ 우리가 사용하는 equal은 String에서 재정의 된것이기 때문에 우리는 String의 상속을 받는 입장으로 재정의된 equal을 사용하게 된다. 그래서 문제없뜸 
