package com.jean;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import static com.jean.ActivationFunctions.stepFunction;

public class Perceptron {
    float wFa, wVa, wCa, wRs, wC, wFs, wTs, wD, wPh, wS, wA;
    final float n = 0.0000005f;
    final int totalIteration = 10000;
    ArrayList<WineSample> samples;
    Random r;
    double errorRate = 0;
    final float upperBound = 1f;
    Perceptron() throws URISyntaxException {
        DataManager dataManager = new DataManager();
        r = new Random();
        dataManager.readData();
        samples = dataManager.getSamples();
    }

    void printSamples() {
        Iterator it = samples.iterator();
        while (it.hasNext()) {
            WineSample curSample = (WineSample) it.next();
            curSample.printInfo();
        }
    }

    void init() {
        generateWeights();
    }

    void generateWeights() {
        r.setSeed(System.currentTimeMillis());
        wFa = r.nextFloat();
        wVa = r.nextFloat();
        wCa = r.nextFloat();
        wRs = r.nextFloat();
        wC = r.nextFloat();
        wFs = r.nextFloat();
        wTs = r.nextFloat();
        wD = r.nextFloat();
        wPh = r.nextFloat();
        wS = r.nextFloat();
        wA = r.nextFloat();
        printWeights();
    }

    void startAlgorithm() {
        float totalSum = 0;
        while (true) {
            Iterator it = samples.iterator();
            while (it.hasNext()) {
                WineSample curSample = (WineSample) it.next();
                totalSum = curSample.fixedAcidity * wFa + curSample.volatileAcidity * wVa + curSample.citricAcid * wCa +
                        curSample.residualSugar * wRs + curSample.chlorides * wC + curSample.freeSulfurDioxide * wFs +
                        curSample.totalSulfurDioxide * wTs + curSample.density * wD + curSample.pH * wPh +
                        curSample.sulphates * wS + curSample.alcohol * wA;
                float c = n * (curSample.quality - stepFunction(totalSum));
                wFa = wFa + c * curSample.fixedAcidity;
                wVa = wVa + c * curSample.volatileAcidity;
                wCa = wCa + c * curSample.citricAcid;
                wRs = wRs + c * curSample.residualSugar;
                wC = wC + c * curSample.chlorides;
                wFs = wFs + c * curSample.freeSulfurDioxide;
                wTs = wTs + c * curSample.totalSulfurDioxide;
                wD = wD + c * curSample.density;
                wPh = wPh + c * curSample.pH;
                wS = wS + c * curSample.sulphates;
                wA = wA + c * curSample.alcohol;
                errorRate = (errorRate + 0.5 * Math.pow((curSample.quality - stepFunction(totalSum)), 2));
            }
            //System.out.println("Error rate = " + errorRate); //Uncomment here if you want to see calculation steps.
            if (errorRate >= 0f && errorRate <= upperBound) break;
            else {
                errorRate = 0;
            }
        }
        System.out.println("Error rate = " + errorRate);
    }

    void printWeights() {
        System.out.println(wFa + ";" + wVa + ";" + wCa + ";" + wRs + ";" + wC + ";" + wFs + ";" + wTs + ";" + wD + ";" + wPh + ";" + wS + ";" + wA);
    }

    void checkResults() {
        System.out.print("Final vector: ");
        printWeights();
        Iterator it = samples.iterator();
        while (it.hasNext()) {
            WineSample curSample = (WineSample) it.next();
            float quality = curSample.fixedAcidity * wFa + curSample.volatileAcidity * wVa + curSample.citricAcid * wCa +
                    curSample.residualSugar * wRs + curSample.chlorides * wC + curSample.freeSulfurDioxide * wFs +
                    curSample.totalSulfurDioxide * wTs + curSample.density * wD + curSample.pH * wPh +
                    curSample.sulphates * wS + curSample.alcohol * wA;
            System.out.println("Calculated Quality = " + stepFunction(quality) + ", Expected Quality = " + curSample.quality);
        }
    }
}
