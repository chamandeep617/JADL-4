package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        MyThread thread = new MyThread();
        thread.start();

        Thread.sleep(10000000000000L);
        System.out.println("Im in " + Thread.currentThread().getName());
    }

    public static class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println("Im in :"+ currentThread().getName()); // thread
            System.out.println(calculate());
        }

        static int calculate(){
            int sum = 0;
            for (int i = 0 ; i <=100 ;i++){
                sum += i;
            }
            return sum;
        }

    }
}
