import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        YearlyReport yearlyReport = new YearlyReport();
        ReportGeneration reportGeneration = new ReportGeneration();
        ArrayList<MonthlyReport> monthlyReports = new ArrayList<>();
        CompareReports checker = new CompareReports(yearlyReport, monthlyReports);
        CompareReports compareReports = new CompareReports(yearlyReport, monthlyReports);

        System.out.println("Вас приветствует Бухгалтерия!");
        while (true) {
            printMenu();
            int command = sc.nextInt();
            if (command == 1) {
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
            } else if (command == 2) {
                if (!yearlyReport.checkedLoadFile) {
                    yearlyReport.loadYearlyReport("y.2021.csv");
                    System.out.println("Файлы считаны!");
                } else {
                    System.out.println("Годовой отчет уже был считан!");
                }
            } else if (command == 3) {
                reportGeneration.generationCompareReports(yearlyReport, monthlyReports, compareReports);
            } else if (command == 4) {
                reportGeneration.generationMonthlyReport(monthlyReports);
            } else if (command == 5) {
                reportGeneration.generationYearlyReport(yearlyReport);
            } else if (command == 0) {
                System.out.println("Досвидания!");
                break;
            } else {
                System.out.println("Такой команды не существует");
            }
        }

    }

    public static void printMenu() {
        System.out.println("_________________");
        System.out.println("Какая информация вам необходима?");
        System.out.println("1 - Считать все месячные отчеты.");
        System.out.println("2 - Считать годовой отчет.");
        System.out.println("3 - Сверка отчетов.");
        System.out.println("4 - Вывести информацию обо всех месячных отчетах.");
        System.out.println("5 - Вывести информацию о годовом отчете.");
        System.out.println("0 - Выход.");
    }
}
