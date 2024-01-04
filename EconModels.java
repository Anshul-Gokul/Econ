package econ;

public class EconModels {

    public static double calculateSolowModel(double capital, double labor, double output, double depreciationRate, double savingsRate, double technologicalProgress) {
        return (savingsRate * output - depreciationRate * capital) / labor + technologicalProgress;
    }

    public static double calculateCobbDouglas(double labor, double capital, double alpha, double beta) {
        return Math.pow(labor, alpha) * Math.pow(capital, beta);
    }

    public static double calculatePhillipsCurve(double inflationRate, double unemploymentRate, double naturalRateOfUnemployment, double PhillipsCoefficient) {
        return inflationRate - PhillipsCoefficient * (unemploymentRate - naturalRateOfUnemployment);
    }

    public static double calculateISLMModel(double output, double interestRate, double autonomousSpending, double consumptionSlope, double investmentSlope, double moneySupply, double priceLevel, double moneyVelocity) {
        double income = output * priceLevel;
        double consumption = autonomousSpending + consumptionSlope * (income - interestRate);
        double investment = autonomousSpending + investmentSlope * interestRate;
        double moneyDemand = income * moneyVelocity;
        double moneyEquilibrium = moneySupply;

        return income - (consumption + investment) - (moneyDemand - moneyEquilibrium);
    }

    public static double calculateMultiplierAcceleratorModel(double initialInvestment, double consumptionParameter, double investmentParameter, double incomeChange) {
        return initialInvestment + (consumptionParameter * incomeChange) + (investmentParameter * incomeChange);
    }

    public static double calculateQuantityTheoryOfMoney(double moneySupply, double moneyVelocity, double priceLevel) {
        return moneySupply * moneyVelocity - priceLevel;
    }

    public static double calculateHarrodDomarModel(double autonomousInvestment, double marginalPropensityToSave, double changeInIncome) {
        return autonomousInvestment / (1 - marginalPropensityToSave) + changeInIncome;
    }

    public static double calculateMundellFlemingModel(double income, double interestRate, double governmentSpending, double taxes, double netExports) {
        return income - (interestRate + governmentSpending - taxes) + netExports;
    }

    public static double calculateOkunsLaw(double outputGap, double potentialOutput) {
        return outputGap - potentialOutput;
    }
  

}