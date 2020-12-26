package com.company;

public class ThreadRunnable {

    public static void main(String[] args) {
        MyThread obj = new MyThread();

        Thread thread = new Thread(obj);

        thread.start();
    }

    public static class obj{

    }
    public static class MyThread extends obj implements Runnable {

        @Override
        public void run() {
            System.out.println("Im in :"+ Thread.currentThread().getName()); // thread
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
