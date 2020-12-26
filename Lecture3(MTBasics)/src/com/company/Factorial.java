package com.company;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {10000,5000,30000,12000,50000,15000,40000,19000,17000,26000,14000};

        long start = System.currentTimeMillis();
        for(int num : arr){
            System.out.println(factorial(num));
        }
//        Thread.sleep(1000000);
        System.out.println("Time taken : "+(System.currentTimeMillis()-start));

    }

    public static BigInteger factorial(int num){
        BigInteger result = BigInteger.ONE;
        for(int i = 2 ; i<= num ; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;

    }
}
