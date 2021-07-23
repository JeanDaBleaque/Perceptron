package com.jean;

import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        Perceptron perceptron = new Perceptron();
        perceptron.init();
        perceptron.printSamples();
        perceptron.startAlgorithm();
        perceptron.checkResults();
    }
}
