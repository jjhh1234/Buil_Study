package com.buil.week2.week2_1;

public class Anonymous {
    Person field = new Person(){ //익명객체 정의
      void work(){ //익명객체 안의 메소드
          System.out.println("출근합니다.");
      }
      @Override
        void wake(){ //부모클래스의 메소드 오버라이딩
          System.out.println("6시에 일어납니다.");
      }
    };

    void method1(){
        Person localVar = new Person(){ //메서드 안에 로컬 변수 생성
            void walk(){
                System.out.println("산책합니다.");
            }
            @Override
            void wake(){
                System.out.println("7시에 일어납니다.");
                walk();
            }
        };
        localVar.wake(); //로컬 변수는 메소드 내에서만 사용가능
    }

    void method2(Person person){ //매개변수로 익명객체 생성
        person.wake(); //매개변수로 초기화돤 익명변수의 값을 받아와서 Override된 wake 실행
    }
}
