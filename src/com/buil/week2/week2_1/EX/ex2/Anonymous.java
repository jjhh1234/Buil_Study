package com.buil.week2.week2_1.EX.ex2;

public class Anonymous {
    Vehicle field = new Vehicle(){ //필드에 Vehicle 인터페이스에 대한 구현객체생성
        @Override
        public void run(){ //생성과 동시에 구현객체 안에 익명 구현 객체 정의
            System.out.println("자전거가 달립니다.");
        }
    };
    void method1(){ //Anonymous의 메소드 정의
        Vehicle field = new Vehicle(){ //메소드 안에 로컬 Vehicle 구현객체생성
          @Override
          public void run(){ //생성과 동시에 익명구현 객체 정의
              System.out.println("승용차가 달립니다.");
          }
        };
        field.run(); //로컬 변수로 선언했기 때문에 메소드 내부에 출력문
    }
    void method2(Vehicle v){ //매개변수 v에 정의된 익명구현 객체 (메소드 호출문에 정의)
        v.run();
    }
}
