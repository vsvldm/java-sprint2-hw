import java.util.ArrayList;
import java.util.HashMap;

public class CompareReports {
    public YearlyReport yearlyReport;
    public ArrayList<MonthlyReport> monthlyReports;

    public CompareReports(YearlyReport yearlyReport, ArrayList<MonthlyReport> monthlyReports) {
        this.yearlyReport = yearlyReport;
        this.monthlyReports = monthlyReports;
    }

    public void check() {
        HashMap<Integer, Integer> expensesInMonth = new HashMap<>();
        HashMap<Integer, Integer> profitsInMonth = new HashMap<>();
        HashMap<Integer,Integer> monthlyExpensesPerYear = new HashMap<>();
        HashMap<Integer, Integer> monthlyProfitsPerYear = new HashMap<>();

        for (MonthlyReport monthlyReport : monthlyReports) {
            int expense = 0;
            int profit = 0;
            for (Transaction transaction : monthlyReport.transactions) {
                if (transaction.isExpense){
                    expense += transaction.quantity * transaction.unitPrice;
                    expensesInMonth.put(transaction.month, expense);
                } else {
                    profit += transaction.quantity * transaction.unitPrice;
                    profitsInMonth.put(transaction.month, profit);
                }
            }
        }
        for (MonthTotalPerYear monthTotalPerYear : yearlyReport.monthsTotalPerYear) {
            if (monthTotalPerYear.isExpense){
                monthlyExpensesPerYear.put(monthTotalPerYear.month, monthTotalPerYear.amount);
            } else {
                monthlyProfitsPerYear.put(monthTotalPerYear.month, monthTotalPerYear.amount);
            }
        }
        for (Integer monthByYearlyReport : monthlyExpensesPerYear.keySet()) {
            for (Integer monthByMonthlyReport : expensesInMonth.keySet()) {
                int expenseByMonth = expensesInMonth.get(monthByMonthlyReport);
                int expenseByYear = monthlyExpensesPerYear.get(monthByYearlyReport);
                if (monthByYearlyReport.equals(monthByMonthlyReport)) {
                    if (expenseByYear == expenseByMonth) {
                        System.out.println("_________________");
                        System.out.println("Отчет по расходам за " + monthByMonthlyReport + " месяц совпал с годовым отчетом");
                    } else {
                        System.out.println("_________________");
                        System.out.println("Отчет по расходам за " + monthByMonthlyReport + " месяц НЕ СОВПАДАЕТ с годовым отчетом");
                    }
                }
            }
        }
        for (Integer monthByYearlyReport : monthlyProfitsPerYear.keySet()) {
            for (Integer monthByMonthlyReport : profitsInMonth.keySet()) {
                int profitByMonth = profitsInMonth.get(monthByMonthlyReport);
                int profitByYear = monthlyProfitsPerYear.get(monthByYearlyReport);
                if(monthByYearlyReport.equals(monthByMonthlyReport)){
                    if(profitByYear == profitByMonth) {
                        System.out.println("_________________");
                        System.out.println("Отчет по доходам за " + monthByMonthlyReport + " месяц совпал с годовым отчетом");
                    } else {
                        System.out.println("_________________");
                        System.out.println("Отчет по доходам за " + monthByMonthlyReport + " месяц НЕ СОВПАДАЕТ с годовым отчетом");
                    }
                }
            }
        }
    }
}
