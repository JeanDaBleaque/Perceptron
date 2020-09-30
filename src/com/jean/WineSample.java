package com.jean;

public class WineSample {
    float fixedAcidity;
    float volatileAcidity;
    float citricAcid;
    float residualSugar;
    float chlorides;
    float freeSulfurDioxide;
    float totalSulfurDioxide;
    float density;
    float pH;
    float sulphates;
    float alcohol;
    float quality;
    public void printInfo() {
        System.out.println("--------------------------------------------");
        System.out.println("Fixed Acidity: " + fixedAcidity);
        System.out.println("Volatile Acidity: " + volatileAcidity);
        System.out.println("Citric Acid: " + citricAcid);
        System.out.println("Residual Sugar: " + residualSugar);
        System.out.println("Chlorides: " + chlorides);
        System.out.println("Free Sulfur Dioxide: " + freeSulfurDioxide);
        System.out.println("Total Sulfur Dioxide: " + totalSulfurDioxide);
        System.out.println("Density: " + density);
        System.out.println("pH: " + pH);
        System.out.println("Sulphates: " + sulphates);
        System.out.println("Alcohol: " + alcohol);
        System.out.println("Quality: " + quality);
    }
}
