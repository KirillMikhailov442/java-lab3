package ru.mikhailov.math;

public class MyMath {
    public static double power(String x, String y) {
        int intX = Integer.parseInt(x);
        int intY = Integer.parseInt(y);

        if (intX == 0 && intY == 0)
            throw new RuntimeException("0 возводить в степень 0 нельзя");
        return Math.pow(intX, intY);
    }
}
