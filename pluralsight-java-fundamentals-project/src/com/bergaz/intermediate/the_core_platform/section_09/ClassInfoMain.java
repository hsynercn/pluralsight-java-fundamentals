package com.bergaz.intermediate.the_core_platform.section_09;

public class ClassInfoMain {
    public static void main(String[] args) {
        HighVolumeAccount highVolumeAccount = new HighVolumeAccount("1234");
        ClassInfo.getInfo(highVolumeAccount);
    }
}
