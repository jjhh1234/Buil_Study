package com.buil.week2.week2_1.EX.ex2;

public class AnonymousExample {
    public static void main(String[] args){
        Anonymous an = new Anonymous();
        an.field.run();
        an.method1();
        an.method2(
                new Vehicle(){
                    @Override
                    public void run(){
                    System.out.println("트럭이 달립니다.");
                }
    }
        );
    }
}
// 새로 생긴 의문점 method1을 호출하면 오버라이드 된 메소드가 호출되고 로컬 변수니까 메소드 안에서 실행이 되어야 한다는거 ok
// 병신아 ㅜㅜ 첫번째는 필드로 바로 부른거고 두번째는 메소드 안에서 정의만 해준거니까 밑에 출력문 적어줘야 출력을 하지
// 세번쨰는 당연히 매개변수로 오버라이드된 값 받고 method2의 출력문 출력하는거고