package com.bergaz.stringformatting;

import java.util.StringJoiner;

public class main {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner("], [", "{[", "]}");
        sj.setEmptyValue("EMPTY");
        sj.add("alpha");
        sj.add("theta");
        sj.add("gamma").add("beta");
        String result = sj.toString();
        System.out.println(result);

        int david = 13, dawson = 11, dillon = 4, gordon = 2;
        String s1 = "My nephews are " + david + ", " + dawson + ", " + dillon +
                ", and " + gordon + " years old.";
        String s2 = String.format("My nephews are %d, %d, %d, and %d years old.", david, dawson, dillon, gordon );

        float avgYear = (david + dawson + dillon + gordon) / 4;

        String s3 = String.format("Average age of my nephews is %.1f", avgYear);

        String ts1 = String.format("%d", 32);
        String ts2 = String.format("%o", 32);
        String ts3 = String.format("%x", 32);

        String ts4 = String.format("%#o", 32);
        String ts5 = String.format("%#x", 32);
        String ts6 = String.format("%#X", 32);

        String ffs1 = String.format("W:%d X:%d", 5, 235);
        String ffs2 = String.format("W:%d X:%d", 481, 12);

        String ffs3 = String.format("W:%4d X:%4d", 5, 235);
        String ffs4 = String.format("W:%4d X:%4d", 481, 12);

        String ffs5 = String.format("W:%04d X:%04d", 5, 235);
        String ffs6 = String.format("W:%04d X:%04d", 481, 12);

        String ffs7 = String.format("W:%-4d X:%-4d", 5, 235);
        String ffs8 = String.format("W:%-4d X:%-4d", 481, 12);

        String ffs9 = String.format("W:%d", 155643556);
        String ffs10 = String.format("W:%,015d", 155643556);
        String ffs11 = String.format("W:%,.2f", 15254565643.556f);

        String ffs12 = String.format("%d", 123);
        String ffs13 = String.format("%d", -456);

        String ffs14 = String.format("% d", 123);
        String ffs15 = String.format("% d", -456);

        String ffs16 = String.format("%+d", 123);
        String ffs17 = String.format("%+d", -456);

        String ffs18 = String.format("%(d", 123);
        String ffs19 = String.format("%(d", -456);
    }
}
