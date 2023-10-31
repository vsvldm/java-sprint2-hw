import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        YearlyReport yearlyReport = new YearlyReport();
        ReportGeneration reportGeneration = new ReportGeneration();
        ReportEngine reportEngine = new ReportEngine();
        ArrayList<MonthlyReport> monthlyReports = reportEngine.monthlyReports;
        CompareReports compareReports = new CompareReports(yearlyReport, monthlyReports);

        System.out.println("Вас приветствует Бухгалтерия!");
        while (true) {
            printMenu();
            int command = sc.nextInt();
            if (command == 1) {
                reportEngine.loadMonthlyReports();
            } else if (command == 2) {
               reportEngine.loadYearlyReports(yearlyReport);
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
