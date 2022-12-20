package com.mygdx.game.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestRunner {
    public static void main(String[] args) {

        System.out.println();

        System.out.println("Running Test 1, which tests if all points of the terrain are lesser than half the screen height: ");
        Result result= JUnitCore.runClasses(MyTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if(result.getFailures().isEmpty()){
            System.out.println("There were no failiures!");
        }

        System.out.println("Result of the rest was : " +result.wasSuccessful());
        System.out.println();
        System.out.println();

        System.out.println("Running Test 2, Which checks if the health of a newly created player is 100");
        Result result2= JUnitCore.runClasses(MyTest2.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if(result.getFailures().isEmpty()){
            System.out.println("There were no failiures!");
        }

        System.out.println("Result of the rest was : " +result.wasSuccessful());
    }
}