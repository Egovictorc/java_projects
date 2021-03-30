package com.victor;

public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from another thread");

                for (int i =0; i < 5; i++) {
                    System.out.println("Printing "+ i + " in a worker thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();



        for (int i =0; i < 5; i++) {
            System.out.println("Printing "+ i + " in the main thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
