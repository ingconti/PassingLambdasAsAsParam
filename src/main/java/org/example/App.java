package org.example;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class App
{

    // define a method that accepts a lambda as a param:

    static public void makeSomeDirtyWorkOn(int i, Callback cb) {
        cb.body(i);
    }

    static public void waitABitAndMakeSomeDirtyWorkOn(int i, Callback cb) {

        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("\nTask performed on: " + new Date()  );
                cb.body(i);
            }
        };
        Timer timer = new Timer("Timer");

        long delay = 1000L;
        timer.schedule(task, delay);
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        // define 1 st callback:

        Callback lambda1 = (arg) -> {
            System.out.println(arg);
        };

        Callback lambda2 = (arg) -> {
            System.out.println(arg * 2);
        };

        // we can pass a differ lambda to be executed:

        makeSomeDirtyWorkOn(10, lambda1);
        makeSomeDirtyWorkOn(10, lambda2);
        waitABitAndMakeSomeDirtyWorkOn(10, lambda1);

    }
}
