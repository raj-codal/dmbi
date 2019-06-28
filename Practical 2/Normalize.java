package dmbi;

import com.sun.org.apache.xalan.internal.lib.ExsltMath;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Raj Dhanani
 */

public class Normalize {

    ArrayList dataSet;

    int min, max, newMin, newMax;

    float mean, variance, sd; // sd -> standard deviation

    public Normalize(ArrayList dataSet) {
        this.dataSet = dataSet;
        this.min = (int) Collections.min(dataSet);
        this.max = (int) Collections.max(dataSet);
        initMean();
        initVariance();
    }
    
    void initMean(){
        mean = 0;
        dataSet.forEach((x) -> {
            mean += (int) x;
        });
        mean /= dataSet.size();
    }
    
    void initVariance(){
        variance = 0;
        dataSet.forEach((x) -> {
            variance += ((int) x - mean) * ((int) x - mean);
        });
        variance /= dataSet.size();
        sd = (float) Math.sqrt(variance);
    }

    void initMinMax(int newMin, int newMax) {
        this.newMin = newMin;
        this.newMax = newMax;
    }

    float zScore(int v) {
        return (v - mean) / sd;
    }

    float decimalScaling(int v) {
        int j = Integer.toString(max).length();
        return (float) (v / ExsltMath.power(10, j));
    }

    float minMax(int v) {
        return (((float) (v - min) * (newMax - newMin) / (max - min)) + newMin);
    }

    float minMax(int v, int newMin, int newMax) {
        return (((float) (v - min) * (newMax - newMin) / (max - min)) + newMin);
    }

}
