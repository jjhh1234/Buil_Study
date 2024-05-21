package com.buil.week2.week2_1;

//RemoteControl , Anonymous2
public class AnonymousExample2 {
    public static void main(String[] args){
       Anonymous2 an = new Anonymous2();
       an.rc.turnOn();
       an.method1(); //an객체안의 method1 안에 오버라이드된
       an.method2( // 매개변수 초기화
               new RemoteControl() { //RemoteControl 객체생성 - 바로 매개변수에 넣을거라 이름 필요없음
               @Override
               public void turnOn(){ //추상메소드 재정의
                   System.out.println("SmartTv를 켭니다");
               }
               @Override
                   public void turnOff(){// 추상메소드 재정의
                   System.out.println("smartTv를 끕니다");
               }
               }
       );


               }
    }