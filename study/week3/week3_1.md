+ 익명객체는 프로그램 내에서 일시적으로 한번만 사용되는 경우에 사용된다
+ 곤충 이라는 부모클래스를 상속받는 거미라는 구현 클래스가 있다고 치자
+ 세상에는 거미는 3만종이 있다고 알려져있다
+ 거미들의 공통적인 특성도 없고 프로그램 내에 잠깐 등장해서 각자의 방식으로 거미줄을 치고 사라진다
+ 우리는 3만종의 거미클래스를 만들어 유지보수 하는것 보다 코드에서 일시적으로 정의하고 쓰고 버리는게 낫다


## 1. 익명객체
+ 이름이 없는 객체(재사용될 일이 없다.)
+ =========================================================================================
+ 필드, 메서드, 매개변수 { } 안에 이름 없는 클래스 형태로 정의됨
+ 코드를 보면 객체생성과 동시에 { } 안의 값들이 정의되고 { } 안의 class는 객체 안에서 동작한다고 볼 수 있다. (자식클래스와 유사 = parent객체안에서 동작하니 parent 객체의 정보를 다 가지고 있기 떄문에)
+ 결국 익명객체는 parent의 자식클래스로 동작하고 자식클래스에서 정의된 필드나 메서드는 사용할 수 없으며 오버라이딩된 메서드만 사용이 가능하다.
+ =========================================================================================

## 1-1. 필드의 초기값으로 익명 객체 생성
```
class A{
  Parent field = new Parent(){ //익명객체를 담을 부모객체 생성
    int childField; //익명객체 필드정의 (parent 단독으로 접근 불가 -> 익명객체의 클래스 이기 떄문)
    void childMethod(){ //익명객체 메서드 정의
    System.out.println("hi");
};
    @Overrid 
    void parentMethod(){ //부모클래스의 parentMethod 재정의
    childField = 3;
    childMethod();
}
};
}
```

+ Q. 갑자기 궁금한건데 부모클래스에서 접근이 불가능한 자식클래스의 변수를 가지고 있는 메소드가 재정의 돼서 사용하는건데 왜 사용이 될까?
+ A. 재정의된 메소드가 동작할때는 본인타입 즉 자식클래스의 타입으로 동작하고 그 결과값이 부모클래스로 반환돼서 그 값을 사용할수있다고 이해하면됨 
+ **부모타입으로 재정의된 메소드를 호출하더라도 그 메소드가 동작하는 동안은 자식타입이고 그 결과값은 부모의 타입으로 반환되어 참조**
+ **당연하지 재정의된 메소드를 호출하면 그건 자식클래스에서 동작하는거니까 호출하는 객체타입이 바뀐거지 메소드 타입이 바뀐게 아니잖니**

## 1-2. 로컬변수의 초기값(메소드 안에 정의된 익명객체/로컬변수 = 메소드 안에 선언되는 변수)
```
class A{
  void method(){
  Parent parent = new Parent(){ // 로컬변수 선언 및 익명객체 정의
    int field;
    void childMethod(){
    System.out.println("hi");
}
@Override
void parentMethod(){ //부모클래스의 메소드 재정의
  childField = 3;
  childMethod();
  }
};
patent.parentMethod(); // parent는 로컬변수이기 떄문에 내부에서 동작
)
}
```

## 1-3. 매개변수의 매개값
```
class A{
  void method1(Parent parent){ }

  void method2(){
    new Parent( // 어차피 매개변수로 변환되거나 매개변수에 담을 것이니 변수는 필요없다 -> 바로 익명객체를 정의하기위한 변수생성 (main에서 익명객체 정의됨)
      int childField; 
      void childMethod(){ }
  @Override
  void parentMethod()[} 
);
}
}
```

+ Q. new Parent(); 라는 키워드는 내가 알고있는 일반적인 형태와 다른데 무엇인가?  
+ A. 우리가 알고 있는 일반적인 형태는 Parent parent = new Parent(); 라는 형태이다. 이것은 Parent 객체를 생성해 parent 라는 변수에 담겠다는 뜻이다
+ 하지만 우리는 객체생성후 익명객체를 정의하고 매개변수에 바로 담을것이기 떄문에 따로 변수명은 필요하지않다.
+ 둘은 객체생성이라는 기능은 동일하지만 new Parent(); 는 객체 생성후 바로 익명객체를 정의하기 위함이라는 점이 다르다. 

## 2. 익명 구현객체 생성
+ 인터페이스의 익명 구현객체 만들기
+ 인터페이스의 경우 인터페이스 타입의 변수또는 필드를 선언하고 구현 객체를 초기값으로 가지는 것이 일반적이다(RemoteControl rc = new TV();)
+ 구현클래스가 재사용 되지 않고 오로지 특정 위치에서 사용할 경우라면 구현클래스를 명시적으로 선언하는것은 귀찮음 - 익명구현객체 사용

## 2-1. 인터페이스 구현객체 필드 선언
```
class A{
  RemoteControl  field = new RemoteControl(){ //필드 선언시 초기값으로 익명 구현객체 생성 
    @Override
     void trunOn(){ //RemoteControl 인터페이스의 추상메소드에대한 실체메소드
} 
}; 
}
```
## 2-2. 로컬변수를 선언할 때 익명구현객체 생성
```
void method(){
  RemoteControl rc = new RemoteControl(){
  @Override
  void trunOn(){ //RemoteControl 인터페이스의 추상메소드에대한 실체메소드
}
};
}
```

## 2-3. 매개변수를 호출할때 익명구현객체 생성
```
class A{
  method2(RemoteControl rc){} // 매개변수 호출

  void method2(
  new RemoteControl(){ //RemoteControl 객체생성후 익명구현객체 메서드 실행 (main 메소드에서 정의됨)
  @Override
  void turnOn(){}
}
);
}

```

## 3. 예외 및 예외처리
+ 예외 : 사용자의 잘못된 조작 또는 개발자의 잘못된 코딩으로 인해 발생하는 프로그램 오류
+ 예외처리 : 예외가 발생하더라도 프로그램을 종료하지 않고 정상 실행 상태를 유지
+ =================================================================
+ Java 에서는 **예외를 클래스**로 관리
+ JVM이 프로그램 실행하는 도중에 예외가 발생하면 **해당 예외클래스로 객체를 생성**
+ 예외처리코드를 예외 객체를 이용할 수 있도록 함
+ =================================================================
+ 모든 예외 클래스는 java.lang.Exception 클래스를 상속 받음
+ 실행 예외클래스는 RutimeException 클래스를 기준으로 구분
+ RuntimeException의 하위클래스가 아니면 일반예외클래스이고 하위클래스면 실행예외 클래스

## 3-1. 일반 예외
+ 컴파일러 체크 예외
+ 프로그램 실행시 예외가 발생할 가능성이 높기 때문에 자바소스를 컴파일 하는 과정에서 해당 예외 처리 코드가 있는지 검사(없으면 에러)
  

## 3-2. 실행 예외
+ 컴파일러 넌체크 예외
+ 실생시 예측할 수 없이 갑자기 발생하기 때문에 컴파일 하는 과정에서 예외 처리 코드가 있는지 검사하지 않음
+ 실행 예외는 자바 컴파일러가 체크하지 않기 때문에 오로지 **개발자 경험의 의존해서 작성**(어 이거 에러날것 같은데 이건 써줘야겠다)

## 3-2_1. NullPointerException
+ 객체가 없는 즉, null 값인 상황에서 객체를 사용하려 해서 발생하는 실행예외
```
public class A{
  public static void main(String[] args){
    String data = null; //값이 null이기 때문에 String 객체를 참조하고 있지 않음 
    System.out.println(data.toString()); //값이 없는 상태에서 String 객체를 참조하려고 하니 문제가 발생  
}
}
```

## 3-2_2. ArrayIndexOutOfBoundsException
+ 배열에서 인덱스 범위를 초과할 경우 발생하는 실행예외
+ 예를 들어 길이가 3인 int arr[] = new int[3] 배열을 사용하고 arr[3] 에 접근할때 범위를 벗어나 발생한다.
```
public class A{
  public static void main(String[] args){
    String data = arr[0];
    System.out.println("data" + data); //실행 매개값이 주어져 있지 않아 오류 발생    
}
}
```

## 3-2_3. NumberFormatException
+ 문자를 숫자로 변환할때 숫자로 변환될 수 없는 문자가 포함되어 있다면 발생하는 실행예외
```
public class A{
  public static void main(String[] args){
    String data1 = "100";
    String data2 = "100a";

    int value = Integer.parseInt(data1);
    int value = Integer.parseInt(data2); //a는 숫자로 바꿀수 없는 문자 이기 때문에 Number실행 예외 발생
}
}
```

## 3-2_4. ClassCastException
+ 타입변환시 대입된 객체가 아니라 다른 객체가 대입된 경우(예시로 보자)
```
// 올바른 타입변환 예시 생성된 Dog 객체가 부모타입 -> 자식타입 

Animal animal = new Dog();
Dog dog = (Dog) animal;

// 잘못된 타입변환 예시

Animal animal = new Dog();
Cat cat = (Cat)animal; //실행 예외 발생 
```

```
public class A{
  public static void main(String[] args){
    Dog dog = new Dog();
    changeDog(dog);

    Cat cat = new Cat();
    changeDog(cat);
}
public static void changeDog(Animal animal){
  Dog dog = (Dog)animal; // animal로 Cat객체를 받아오는데 Dog와 Cat은 animal을 상속한다 해도 서로 영향을 줄수 없는 서로다른 객체이다 - 따라서 연관될 수 없고 Cat 은 Cat(자기 자신) 이나 Animal(부모클래스) 가 아니면 오류발생 
}
  
}
```

## 4. 예외처리 
+ 일반 예외시 컴파일 에러를 발생시켜 개발자가 강제적으로 예외처리코드를 작성하도록 요구

## 4-1.예외처리코드
+ **try - catch - finally** 블록 : 생성자 내부와 메소드 내부에서 작성되어 일반예외와 실행예외가 발생할 경우 예외처리를 가능하게 함


