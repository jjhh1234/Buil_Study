package com.buil.week2.week2_1;

public class Anonymous2 {
    RemoteControl rc = new RemoteControl(){ //필드에 익명구현객체 초기화
        @Override
        public void turnOn(){ //추상메소드 재정의
            System.out.println("티비를 켭니다");
        }
        @Override
        public void turnOff(){ //추상메소드 재정의
            System.out.println("티비를 끕니다.");
        }
    };
    void method1(){
        RemoteControl localVal = new RemoteControl(){ //로컬변수로 익명구현객체 초기화
            @Override
            public void turnOn(){ //추상메소드 재정의
                System.out.println("Audio를 켭니다.");
            }
            @Override
            public void turnOff(){ //추상메소드 재정의
                System.out.println("Audio를 끕니다.");
            }
        };
    };
    void method2(RemoteControl rc){
        rc.turnOff(); //매개변수 rc에 정의된 익명구현객체의 오버라이딩된 turnOff 출력
    }
}
