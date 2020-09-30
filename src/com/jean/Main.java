package com.jean;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        dataManager.readData();
        ArrayList<WineSample> samples = dataManager.getSamples();
        Iterator it = samples.iterator();
        while (it.hasNext()) {
            WineSample curSample = (WineSample) it.next();
            curSample.printInfo();
        }
    }
}
