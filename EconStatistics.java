package econ;

import java.util.*;


public class EconStatistics{

    public static double mean(List<Double> data){
        double sum = 0;
        for(double x : data){
            sum += x;
        }

        return sum/(data.size());
    }

    public static double variance(List<Double> data){
        double mean = mean(data);
        double sum = 0;
        if(data.size() < 2){
            return 0;
        }
        
        for(double x : data){
            sum += Math.pow((mean - x) , 2);
        }

        return sum/(data.size() - 1);
    }

    public static double standardDeviation(List<Double> data){
        return Math.sqrt(variance(data));

    }
    public static double coo(List<Double> data1, List<Double> data2) {
        if (data1.size() != data2.size()) {
            throw new IllegalArgumentException("Datasets must have the same size");
        }

        double mean1 = mean(data1);
        double mean2 = mean(data2);
        double sumProductDeviations = 0.0;
        double sumSquaredDeviations1 = 0.0;
        double sumSquaredDeviations2 = 0.0;

        for (int i = 0; i < data1.size(); i++) {
            double deviation1 = data1.get(i) - mean1;
            double deviation2 = data2.get(i) - mean2;
            sumProductDeviations += deviation1 * deviation2;
            sumSquaredDeviations1 += deviation1 * deviation1;
            sumSquaredDeviations2 += deviation2 * deviation2;
        }

        return sumProductDeviations / (Math.sqrt(sumSquaredDeviations1) * Math.sqrt(sumSquaredDeviations2));
    }

    public static double calculateZScore(double value, List<Double> data) {
        double mean = mean(data);
        double standardDeviation = standardDeviation(data);

        
        return (value - mean) / standardDeviation;
    }
}
    