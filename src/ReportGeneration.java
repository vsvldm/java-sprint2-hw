import java.util.ArrayList;
import java.util.HashMap;

public class ReportGeneration {

    public void generationYearlyReport(YearlyReport yearlyReport) {
        if (yearlyReport.checkedLoadFile) {
            System.out.println("_________________");
            System.out.println("Отчет за 2021 год: ");
            System.out.println("Средний расход за год: " + yearlyReport.getAverageExpense());
            System.out.println("Средний доход за год: " + yearlyReport.getAverageProfit());
            HashMap<Integer, Integer> monthlyProfits = yearlyReport.getMonthlyProfit();
            for (Integer month : monthlyProfits.keySet()) {
                System.out.println("Прибыль за " + month + " месяц составила: " + monthlyProfits.get(month));
            }
        } else {
            System.out.println("Отчеты не считаны! Считайте их в главном меню!");
        }
    }

    public void generationMonthlyReport(ArrayList<MonthlyReport> monthlyReports) {
        if (!monthlyReports.isEmpty()) {
            for (MonthlyReport report : monthlyReports) {
                    System.out.println("_________________");
                    System.out.println("Отчет за " + report.monthForReport + " месяц:");
                    report.topProfitAndNameProduct();
                    report.maxExpenseAndName();
            }
        } else {
            System.out.println("Отчеты не считаны! Считайте их в главном меню!");
        }
    }
    public void generationCompareReports(YearlyReport yearlyReport, ArrayList<MonthlyReport> monthlyReports, CompareReports compareReports) {
        if (!monthlyReports.isEmpty() && yearlyReport.checkedLoadFile){
            compareReports.check();
        } else {
            System.out.println("Отчеты не считаны! Считайте их в главном меню!");
        }
    }
}
