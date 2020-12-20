package com.company;


class Student{


    static class apj{

    }
    static int a = 10;
    static int b = 20;


    public Student() {
    }

    public Student(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public static int getSum(){
//        static int c =30;
        return a+b;
    }

}


public class Main {

    static{
        System.out.println("hi");
    }

    public static void main(String[] args) {
        final Student obj ;
        obj = new Student(10,20);
        obj = new Student(20,30);
        final int a;
        a = 10;
        a = 11;
        System.out.println(Student.getSum());
        Math.abs();
    }
}
