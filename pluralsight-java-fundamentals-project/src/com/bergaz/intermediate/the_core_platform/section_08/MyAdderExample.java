package com.bergaz.intermediate.the_core_platform.section_08;

public class MyAdderExample {
    public static void main(String[] args) {
        String inFile = LocalFilePath.getPath() + "/in_integers.txt";
        String outFile =  LocalFilePath.getPath() + "/out_integers.txt";
        MyAdderRunnable myAdderRunnable = new MyAdderRunnable(inFile, outFile);
        myAdderRunnable.doAdd();
    }
}
