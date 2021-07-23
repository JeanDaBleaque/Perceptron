```java
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
    ```
    This program takes 11 inputs and calculates quality values for each wine sample then compares with real value.  
    Data sample files in dataset/winequality path. In original file there are almost 5000 data values but with 11 input variable this is almost impossible to find good weight vector for these data set. Therefore I simplified dataset to 35 data inputs.