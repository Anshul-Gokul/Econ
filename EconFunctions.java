package econ;

import java.util.*;

public class EconFunctions {

    public static double calculatePresentValue(List<Double> cashFlows, double discountRate) {
        double presentValue = 0.0;

        for (int t = 0; t < cashFlows.size(); t++) {
            double cashFlow = cashFlows.get(t);
            double discountFactor = 1.0 / Math.pow(1.0 + discountRate, t);
            presentValue += cashFlow * discountFactor;
        }

        return presentValue;

    }

    public static double calculateNPV(List<Double> cashFlows, double discountRate) {
        double initialInvestment = cashFlows.get(0);
        double npv = calculatePresentValue(cashFlows, discountRate) - initialInvestment;
        return npv;
    }


    public static double calculateFutureValue(double presentValue, double interestRate, int periods) {
        return presentValue * Math.pow(1.0 + interestRate, periods);
    }

  
    public static double calculateLoanPayment(double loanAmount, double interestRate, int loanTerm) {
        double monthlyInterestRate = interestRate / 12.0 / 100.0; 
        int numberOfPayments = loanTerm * 12; 
        return loanAmount * (monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
    }


    public static double calculateWACC(double costOfDebt, double costOfEquity, double taxRate, double debtWeight, double equityWeight) {
        return (costOfDebt * debtWeight) + (costOfEquity * equityWeight * (1 - taxRate));
    }


    public static double calculatePaybackPeriod(List<Double> cashFlows) {
        double cumulativeCashFlow = 0.0;
        int paybackPeriod = 0;

        for (int t = 0; t < cashFlows.size(); t++) {
            cumulativeCashFlow += cashFlows.get(t);
            if (cumulativeCashFlow >= 0) {
                paybackPeriod = t;
                break;
            }
        }

        return paybackPeriod;
    }

}
