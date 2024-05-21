package com.buil.week2.week2_1.EX.ex1;

public class AnonymousExample {
    public static void main(String[] args) {
        Anonymous an = new Anonymous();
        an.field.start();
        an.method1();
        an.method2(
                new Worker(){
                    @Override
                    public void start(){
                        System.out.println("테스트를 합니다.");
                    }
                }
        );
    }
}
