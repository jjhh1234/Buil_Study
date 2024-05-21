package com.buil.week2.week2_1;

//Anonymous와 Person 클래스를 이용해 만듦
public class AnonymousExample {
    public static void main(String[] args){
        Anonymous an = new Anonymous();
        an.field.wake(); // an객체의 field 부모객체 안에 익명객체에 오버라이드된 wake() 호출
        an.method1(); //an객체 method1 안에 들어있는 익명객체 호출
        an.method2( //매개변수값을 익명객체로 정의해서 매개변수 대입
                new Person(){ //매개변수에 담을거라 따로 변수명이 필요하지 않음
                    void study(){
                        System.out.println("공부합니다.");
                    }
                    @Override
                    void wake(){
                        System.out.println("8시에 일어납니다");
                        study();
                    }
                }
        );
    }

}
