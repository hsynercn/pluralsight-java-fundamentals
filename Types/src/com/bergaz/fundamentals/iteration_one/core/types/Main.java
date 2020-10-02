package com.bergaz.fundamentals.iteration_one.core.types;

public class Main {

    private int result1;

    public static void main(String[] args) {
        final int a = 0;
        final int b;
        b = a;
        String myVar = null;

        byte x = 8;
        short y = 16;
        int z = 32;
        long t = 98999999L;
        float g = 0.00001f;
        double h = 0.0000000000000000007;
        char o = '\u00DD';

        int first = 5;
        int second = 5;
        System.out.println(++first);
        System.out.println(second++);

        int valA = 21;
        int valB = 6;
        int valC = 3;
        int valD = 1;

        int resulta1 = valA - valB / valC;
        int resulta2 = (valA - valB) / valC;
        int resulta3 = valA / valC * valD + valB;//13
        int resulta4 = valA / (valC * (valD + valB));//1

        //postfix: x++ x-- > prefix: ++x --x > multiplication: * / % > additive: + -

        float floatVal = 1.0f;
        double doubleVal = 4.0d;
        byte byteVal = 7;
        short shortVal = 7;
        long longVal = 5;

        short resultb1 = byteVal;
        short resultb2 = (short) longVal;

        short resultb3 = (short) (byteVal - longVal);
        double resultb4 = longVal - floatVal - doubleVal;

        boolean cmp1 = 'b' > 'a';
        boolean cmp2 = 'a' >= 'a';
        boolean cmp3 = 'a' < 'b';
        boolean cmp4 = 'a' <= 'c';

        boolean cmp5 = true == true;
        boolean cmp6 = true != false;

        int l = 10;
        l = l++; //this is a mistake

        int value1 = 15;
        int value2 = 10;
        int maxValue = value1 > value2 ? value1 : value2;

        if (value1 > value2)
            System.out.println("Value 1 is greater");
        else
            System.out.println("Value 2 is greater");

        if (value1 > value2)
            System.out.println("Value 1 is greater");
        else if (value2 > value1)
            System.out.println("Value 2 is greater");
        else
            System.out.println("Value 1 and value 2 are equal");

        double value11 = 100.0d;
        double value12 = 50.0d;
        double result = 0.0d;
        char opCode = 'd';

        if (opCode == 'a') {
            result = value11 + value12;
        } else if (opCode == 's') {
            result = value11 - value12;
        } else if (opCode == 'm') {
            result = value11 * value12;
        } else if(opCode == 'd') {
            result = value11 / value12;
        } else {
            result = 0.0d;
        }

        switch (opCode) {
            case 'a':
                result = value11 + value12;
                break;
            case 's':
                result = value11 - value12;
                break;
            case 'm':
                result = value11 * value12;
                break;
            case 'd':
                result = value12 != 0 ? value11 / value12 : 0.0d;
                break;
            default:
                result = 0.0d;
        }

        int  c1 = 25, c2 = 20, c3 = 15;
        boolean cRes = c1 > c2 & c2 > c3;

        boolean case1 = true & true;
        boolean case2 = (false | true) | (false | true) | (true | true);
        boolean case3 = false ^ true;

        boolean case4 = (false && true);//right side executes when only needed

        int dvider = 0;
        if(dvider != 0 && 100 / dvider > 5)
            System.out.println("valid division");

        try {
            if(dvider != 0 & 100 / dvider > 5)//right side executed
                System.out.println("valid division");
        } catch (Exception e) {
            System.out.println("invalid division");
        }

        boolean isBlock = true;
        int blockVal;

        if (isBlock) {
            blockVal = 100;//without a block we can't use multiple lines with if
            System.out.println("This is a block");
        } else {
            blockVal = 200;
            System.out.println("This is another block");
        }

        int someValue = 4;
        int factorial = 1;
        while (someValue > 1) {
            factorial *= someValue;
            someValue--;
        }

        while (someValue > 0)
            someValue--;

        int iVal = 0;

        do
          iVal++;
        while (iVal < 10);

        do {
            iVal--;
        } while (iVal > 0);

        int i = 1;
        while (i < 100) {
            System.out.println(i);
            i *= 2;
        }
        for(i = 1; i < 100; i *= 2)
            System.out.println(i);

        float[] fVals = { 10.0f, 20.0f, 15.0f };
        float sum = 0.0f;
        for(int index = 0; index < fVals.length; index++)
            sum += fVals[index];

        sum = 0.0f;
        for( float temp : fVals)
            sum += temp;
    }

    static void swap(int i, int j) {
        int k = i;
        i = j;
        j = k;//parameter passed by value, not effective outside of the method
    }
}
