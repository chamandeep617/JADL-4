package com.company;

public class BankSynchronization {

    public static void main(String[] args) throws InterruptedException {

        Bank acc1 = new Bank(1,100);

        Bank acc2 = new Bank(2,300);

        MyThread[] thread = new MyThread[6];

        thread[0] = new MyThread(acc1,true,50);   // 0
        thread[1] = new MyThread(acc1,false,100);
        thread[2] = new MyThread(acc1,true,250);

//        amount of acc1 is 300

        thread[3] = new MyThread(acc2,false,100);
        thread[4] = new MyThread(acc2,true,350);
        thread[5] = new MyThread(acc2,false,150);

//        anount of acc2 is 400

        for(int i = 0 ; i < 6 ; i++){
            thread[i].start();
        }

        for(int i = 0 ; i < 6 ; i++){
            thread[i].join();
        }

        System.out.println("Amount in acc1 : "+ acc1.getBalance()+", Amount for acc2 : "+acc2.getBalance());
    }

    public static class MyThread extends Thread{

        private Bank obj;
        boolean isDeposit;
        private int amount;

        public MyThread(Bank obj, boolean isDeposit, int amount){
            this.obj = obj;
            this.isDeposit = isDeposit;
            this.amount = amount;
        }

        @Override
        public void run() {
            if(isDeposit){
                Deposit();
            }else{
                Withdraw();
            }
        }

        private void Deposit(){
            synchronized (Bank.class) {
                System.out.println("I'm in : " + currentThread().getName());
                this.obj.setBalance(this.obj.getBalance() + this.amount);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void Withdraw() {
            synchronized (Bank.class) {
                System.out.println("I'm in : " + currentThread().getName());
                this.obj.setBalance(this.obj.getBalance() - this.amount);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
