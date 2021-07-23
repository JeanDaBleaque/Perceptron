package com.jean;

public class ActivationFunctions {
    static int stepFunction(double x) {
        if (x<5) return -1; //Bad quality Wine
        else if (x>=5 && x<6) return 0; //Decent quality wine
        else if (x>=6) return 1; //Good quality wine
        return -1;
    }

    static float sigmoidFunction(float x) {
        return (float) (8 / (1 + Math.exp(-x)));
    }
}
