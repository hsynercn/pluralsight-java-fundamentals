package com.bergaz.controlappexecution;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CmdArguments {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("No arguments");
        } else if(args.length == 1){
            readFile(args[0]);
        }
    }

    private static void readFile(String path) {
        try(BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String inValue;
            while((inValue = br.readLine()) != null) {
                System.out.println(inValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
