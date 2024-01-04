package econ;

public class EconAverages {

    public static double weightedAverage(double[] values, double[] weights) {
        if (values.length == 0 || weights.length == 0 || values.length != weights.length) {
            throw new IllegalArgumentException("Input arrays are empty or have different lengths.");
        }
        double weightedSum = 0.0;
        double totalWeight = 0.0;
        for (int i = 0; i < values.length; i++) {
            if (weights[i] < 0) {
                throw new IllegalArgumentException("Weighted values must be non-negative.");
            }
            weightedSum += values[i] * weights[i];
            totalWeight += weights[i];
        }
        return weightedSum / totalWeight;
    }

    public static double[] simpleMovingAverage(double[] values, int windowSize) {
        if (values.length == 0 || windowSize <= 0 || windowSize > values.length) {
            throw new IllegalArgumentException("Invalid window size or empty input array.");
        }

        double[] movingAverages = new double[values.length - windowSize + 1];
        for (int i = 0; i <= values.length - windowSize; i++) {
            double sum = 0.0;
            for (int j = i; j < i + windowSize; j++) {
                sum += values[j];
            }
            movingAverages[i] = sum / windowSize;
        }
        return movingAverages;
    }

    public static double[] movingAverageWithRange(double[] values, int range) {
        if (values.length == 0 || range <= 0 || range >= values.length) {
            throw new IllegalArgumentException("Invalid range or empty input array.");
        }

        double[] movingAverages = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            int start = Math.max(0, i - range + 1);
            double sum = 0.0;
            for (int j = start; j <= i; j++) {
                sum += values[j];
            }
            movingAverages[i] = sum / (i - start + 1);
        }
        return movingAverages;
    }

}
