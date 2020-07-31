package com.bergaz.fundamentals.controlappexecution;

import java.util.Map;

public class SystemAndEnvironment {
    public static void main(String[] args) {
        String userName = System.getProperty("user.name");
        String userHome = System.getProperty("user.home");
        String osArchitecture = System.getProperty("os.arch");
        String javaVendor = System.getProperty("java.vendor");

        Map<String, String> getenv = System.getenv();
        getenv.forEach((k,v) -> System.out.println(k+">"+v));
    }
}
