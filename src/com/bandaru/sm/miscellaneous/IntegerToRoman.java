package com.bandaru.sm.miscellaneous;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(convert(900));
    }

    public static String convert(int num) {
        int temp = num;
        String result = "";
        if (temp / 1000 > 0) {
            int M = temp / 1000;
            temp = temp % 1000;
            for (int i = 0; i < M; i++) {
                result = result + "M";
            }
        }
        if (temp / 100 > 0) {
            int D = temp / 100;
            temp = temp % 100;
            if (D == 4) {
                result = result + "CD";
            }
            if (D == 9) {
                result = result + "CM";
            }
            if (D >= 1 && D <= 3) {
                for (int i = 0; i < D; i++) {
                    result = result + "C";
                }
            }
            if (D == 5) {
                result = result + "D";
            }
            if (D >= 6 && D <= 8) {
                result = result + "D";
                for (int i = 5; i < D; i++) {
                    result = result + "C";
                }
            }
        }
        if (temp / 10 > 0) {
            int C = temp / 10;
            temp = temp % 10;
            if (C == 4) {
                result = result + "XL";
            }
            if (C == 9) {
                result = result + "XC";
            }
            if (C == 5) {
                result = result + "L";
            }
            if (C >= 1 && C <= 3) {
                for (int i = 0; i < C; i++) {
                    result = result + "X";
                }
            }
            if (C >= 6 && C <= 8) {
                result = result + "L";
                for (int i = 5; i < C; i++) {
                    result = result + "X";
                }
            }
        }
        if (temp > 0) {
            if (temp == 4) {
                result = result + "IV";
            }
            if (temp == 9) {
                result = result + "IX";
            }
            if (temp == 5) {
                result = result + "V";
            }
            if (temp >= 1 && temp <= 3) {
                for (int i = 0; i < temp; i++) {
                    result = result + "I";
                }
            }
            if (temp >= 6 && temp <= 8) {
                result = result + "V";
                for (int i = 5; i < temp; i++) {
                    result = result + "I";
                }
            }
        }
        return result;
    }
}


