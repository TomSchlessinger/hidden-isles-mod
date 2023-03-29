package net.myshampooisdrunk.hiddenisles.util;



public class MathUtils {


    public static double map(double x, double in_min, double in_max, double out_min, double out_max) {//taken from arduino map function
        return ((x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min);
    }



}
