package com.gallery;

import java.io.IOException;

import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

import com.gallery.impl.MainFlowImpl;

public class Main {
  
    /* 
     * ******************************************* 
     *              MAIN CLASS
     * ******************************************* 
     */

    public static void main(String[] args) throws IOException{

        Executor executor = new TestExecutor(
            MainFlowImpl.class
        );

        Result result = executor.execute(true);

        if (result.hasErrors()) {
            for (String error : result.getErrors()) {
                System.out.println(error);
            }
        }

    }
}