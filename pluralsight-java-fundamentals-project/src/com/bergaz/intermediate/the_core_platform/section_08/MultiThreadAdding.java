package com.bergaz.intermediate.the_core_platform.section_08;

import java.util.ArrayList;
import java.util.Arrays;

public class MultiThreadAdding {
    public static void main(String[] args) {
        String[] inFiles = {
                "in_integers_1.txt", "in_integers_2.txt",
                "in_integers_3.txt", "in_integers_4.txt",
                "in_integers_5.txt", "in_integers_6.txt"};
        String inFolder = LocalFilePath.getPath() + "/in_files/";
        String outFolder =  LocalFilePath.getPath() + "/out_files/";

        ArrayList<Thread> threadArrayList = new ArrayList<>();

        Arrays.asList(inFiles).forEach(inFile -> {
            MyAdder myAdder = new MyAdder(inFolder + inFile, outFolder + "out_" + inFile);
            Thread thread = new Thread(myAdder);
            thread.start();
            threadArrayList.add(thread);
        });

        threadArrayList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
