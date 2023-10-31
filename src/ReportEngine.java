import java.util.ArrayList;

public class ReportEngine {
    ArrayList<MonthlyReport> monthlyReports = new ArrayList<>();

    public void loadMonthlyReports() {
        if (monthlyReports.isEmpty()) {
            for (int i = 1; i <= 3; i++) {
                MonthlyReport monthlyReport = new MonthlyReport();
                monthlyReport.loadMonthlyReport(i, "m.20210" + i + ".csv");
                monthlyReports.add(monthlyReport);
            }
            System.out.println("Файлы считаны!");
        } else {
            System.out.println("Месячные отчеты уже были считаны!");
        }
    }
    public void loadYearlyReports(YearlyReport yearlyReport) {
        if (!yearlyReport.checkedLoadFile) {
            yearlyReport.loadYearlyReport("y.2021.csv");
            System.out.println("Файлы считаны!");
        } else {
            System.out.println("Годовой отчет уже был считан!");
        }
    }

}
