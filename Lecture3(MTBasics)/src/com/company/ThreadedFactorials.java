package com.company;

import java.math.BigInteger;

public class ThreadedFactorials {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {10000,5000,30000,12000,50000,15000,40000,19000,17000,26000,14000}; //  15 12 516  66 58 862 6585

        long start = System.currentTimeMillis();

        MyThread[] threads = new MyThread[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            threads[i] = new MyThread(arr[i]);
//            threads[i].setDaemon(true);
            threads[i].start();
            threads[i].join();
        }
 // --->
//        for(int i = 0 ; i < arr.length ; i++){
//            threads[i].join();
//        }

        for(int i = 0 ; i < arr.length ; i++){
            System.out.println(arr[i] +" have factorial : "+threads[i].result);
        }

        System.out.println("Time taken : "+(System.currentTimeMillis()-start));

    }

    public static class MyThread extends Thread{

        BigInteger result;
        private int num;

        public MyThread(int num){
            this.num = num;
            result = BigInteger.ONE;

        }
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            factorial();
        }

        public void factorial(){
            for(int i = 2 ; i<= num ; i++){
                result = result.multiply(BigInteger.valueOf(i));
            }
        }
    }
}