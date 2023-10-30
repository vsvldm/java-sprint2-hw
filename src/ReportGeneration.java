import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ReportGeneration {
    Scanner sc = new Scanner(System.in);

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
            while (true) {
                readYesOrNo();
                int readOrNo = sc.nextInt();
                if (readOrNo == 1) {
                    yearlyReport.loadYearlyReport("y.2021.csv");
                    System.out.println("Файлы считаны!");
                    break;
                } else if (readOrNo == 2) {
                    break;
                } else {
                    System.out.println("Введена неверная команда!");
                }
            }
        }
    }

    public void generationMonthlyReport(ArrayList<MonthlyReport> monthlyReports) {
        if (!monthlyReports.isEmpty()) {
            for (MonthlyReport report : monthlyReports) {
                if (report.monthForReport == 1) {
                    System.out.println("_________________");
                    System.out.println("Январь");
                    report.topProfitAndNameProduct();
                    report.maxExpenseAndName();
                } else if (report.monthForReport == 2) {
                    System.out.println("_________________");
                    System.out.println("Февраль");
                    report.topProfitAndNameProduct();
                    report.maxExpenseAndName();
                } else if (report.monthForReport == 3) {
                    System.out.println("_________________");
                    System.out.println("Март");
                    report.topProfitAndNameProduct();
                    report.maxExpenseAndName();
                }
            }
        } else {
            while (true) {
                readYesOrNo();
                int readOrNo = sc.nextInt();
                if (readOrNo == 1) {
                    for (int i = 1; i <= 3; i++) {
                        MonthlyReport monthlyReport = new MonthlyReport();
                        monthlyReport.loadMonthlyReport(i, "m.20210" + i + ".csv");
                        monthlyReports.add(monthlyReport);
                    }
                    System.out.println("Файлы считаны!");
                    break;
                } else if (readOrNo == 2) {
                    break;
                } else {
                    System.out.println("Введена неверная команда!");
                }
            }
        }
    }
    public void generationCompareReports(YearlyReport yearlyReport, ArrayList<MonthlyReport> monthlyReports, CompareReports compareReports) {
        if (!monthlyReports.isEmpty() && yearlyReport.checkedLoadFile){
            compareReports.check();
        } else {
            while (true) {
                readYesOrNo();
                int readOrNo = sc.nextInt();
                if (readOrNo == 1) {
                    yearlyReport.loadYearlyReport("y.2021.csv");
                    for (int i = 1; i <= 3; i++) {
                        MonthlyReport monthlyReport = new MonthlyReport();
                        monthlyReport.loadMonthlyReport(i, "m.20210" + i + ".csv");
                        monthlyReports.add(monthlyReport);
                    }
                    System.out.println("Файлы считаны!");
                    break;
                } else if (readOrNo == 2) {
                    break;
                } else {
                    System.out.println("Введена неверная команда!");
            }
        }
    }
    }

    public void readYesOrNo() {
        System.out.println("Файл отчета не считан! Хотите считать?");
        System.out.println("1 - Да");
        System.out.println("2 - Нет");
    }
}
