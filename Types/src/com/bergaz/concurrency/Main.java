package com.bergaz.concurrency;

public class Main {
    public static void main(String[] args) {
        String[] inFiles = {"C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file1.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file2.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file3.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file4.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file5.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\in_file6.txt"};

        String[] outFiles = {"C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\out_file1.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\out_file2.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\out_file3.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\out_file4.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\out_file5.txt",
                "C:\\Pluralsight\\pluralsight-java-fundamentals\\Types\\files\\out_file6.txt"};

        for(int i = 0; i < inFiles.length; i++){
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            adder.doAdd();
        }
    }
}
