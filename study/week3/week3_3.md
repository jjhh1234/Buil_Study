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
+ Object 클래스의 equals 는 객체의 주소값이 동일한지 확인
+ String 클래스의 equals 는 객체의 내용이 동일한지 확인인

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
+ A) 강제형변환은 그렇게 이루어지는 것이 맞다. 해당 문제의  메소드를 사용할 때 Object는 최상위 타입이기 때문에 매개변수값으로 어떤 타입의 객체가 와도 상관이 없다. 만약 Test를 상속하는 test 클래스의 객체가 매개변수로 들어와서 Object로 형변환 됐다면 그건 최상위 클래스가 된다는 의미, 따라서 부모타입을 자식타입으로 강제형변환을 해준다는 정론이된다. 그럼 instanceof의 기능은 잘못되지않았냐는 궁금증이 생기는데 instanceof의 정확한 기능은 기준객체의 실체객체 타입을 타입과 비교하는 것이다. 이렇게 되면 아무 문제가 생기지 않음 

### Q) equals을 재정의하는 이유가 뭔가요?
+ 동일한 데이터를 가진 다른 주소값을 가진 객체는 사용자 입장에서 결국 같은 객체라고 볼 수 있다. 기존의 equals는 주소값을 정의하는 메소드 이기 때문에 사용시 주소값을 비교해 false를 반환한다. 오버라이딩을 통해 로직을 수정하면 다른 주소값을 가진 객체라해도 비교를 통해 데이터값이 동일한지 알 수 있다.
   
+ 근데 굳이 재정의 안해도 되는거 아니냐 싶지만 그건 보안 어쩌구 문제 떄문에 지양해야 한다어쩌구 - 필드 노출 떄문에 그런듯

### Q) equals를 재정의할때 동일성을 비교해야하는 이유
```
//타입 정의

public class Student{

  Long id;
  String name;
  int age;

public Student(Long id, String name, int age){
  this.id = id;
  this.name = name;
  this.age = age;
  }
}

```

```
// 객체생성
public void equalTest(){

  Student s1 = new Student(1L,"둘리",12);
  Student s2 = new Student(1L,"둘리",12);
}

// 둘은 동일한 데이터값을 가지므로 같은 객체라고 할 수 있지만 equals를 사용하면 주소값이 비교되기 때문에 다른 객체로 간주된다.

//주소값은 다르지만 우리가 보기에 둘은 동일한 객체다. 따라서 이 두개가 동일한 타입이거나 상속 관계에 있는 경우 형변환 해주면 서로의 필드 내용을 확인해 동일한 데이터값을 가진 객체임을 알 수 있게 해준다.
```

### 2-1_2. 객체 해시코드 - Object 클래스의 hashCode 메소드
+ 객체 해쉬코드 : 객체를 식별하는 하나의 정수값
+ hashCode() : 객체의 메모리 번지를 이용해서 하나의 해시코드를 만들어 리턴 -> 객체마다 다른 값을가짐 
+ equals와 함께 사용되는 이유: equals로 동일한 값을 가지는 객체를 같다고 만들어주긴 했지만 반환되는 hashCode가 다르므로 아직 완전히 동일한 객체라고 보기는 힘들기 떄문에 그 부분을 정의해주는 것 

```
//해쉬코드를 재정의 하지 않았을때

public class Key{

  public int num;

  public Key(int num){
    this.num = num;
  }

  @Override
  public boolean equals(Object obj){
    if(obj instanceof Key){
      Key compareKey = (Kye)obj;
      if(this.num == compareKey.num){
      return true;
    }
}
return false;
  }
}

//이경우에 equal 메소드를 재정의 함으로써 동등객체임을 인정해주긴 했지만 반환되는 해쉬코드는 다르기 떄문에 완전히 동일하다고 보기는 힘들다

```



















