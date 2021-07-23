package com.jean;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

import static com.jean.ActivationFunctions.stepFunction;

public class DataManager {
    private ArrayList<WineSample> samples;
    public DataManager() {
        samples = new ArrayList<>();
    }
    public void readData() throws URISyntaxException {
        URL resource = getClass().getClassLoader().getResource("winequality-white.csv");
        File file = new File(resource.toURI());
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line=br.readLine()) != null) {
                if (line.startsWith("/")) {
                    continue;
                } else {
                    String[] properties = line.split(";");
                    WineSample curSample = new WineSample();
                    curSample.fixedAcidity = Float.parseFloat(properties[0]);
                    curSample.volatileAcidity = Float.parseFloat(properties[1]);
                    curSample.citricAcid = Float.parseFloat(properties[2]);
                    curSample.residualSugar = Float.parseFloat(properties[3]);
                    curSample.chlorides = Float.parseFloat(properties[4]);
                    curSample.freeSulfurDioxide = Float.parseFloat(properties[5]);
                    curSample.totalSulfurDioxide = Float.parseFloat(properties[6]);
                    curSample.density = Float.parseFloat(properties[7]);
                    curSample.pH = Float.parseFloat(properties[8]);
                    curSample.sulphates = Float.parseFloat(properties[9]);
                    curSample.alcohol = Float.parseFloat(properties[10]);
                    curSample.quality = stepFunction(Float.parseFloat(properties[11]));
                    samples.add(curSample);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<WineSample> getSamples() {
        return samples;
    }
}
