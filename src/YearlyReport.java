import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    FileReader fileReader = new FileReader();
    public ArrayList<MonthTotalPerYear> monthsTotalPerYear = new ArrayList<>();
    boolean checkedLoadFile = false;
    HashMap<Integer, Integer> profits = new HashMap<>();
    HashMap<Integer, Integer> expenses = new HashMap<>();


    public void loadYearlyReport(String fileName){
        ArrayList<String> lines = fileReader.readFileContents(fileName);
        for (int i = 1; i < lines.size(); i++){
            String line = lines.get(i);
            String[] lineContent = line.split(",");
            int month = Integer.parseInt(lineContent[0]);
            int amount = Integer.parseInt(lineContent[1]);
            boolean isExpense = Boolean.parseBoolean(lineContent[2]);
            MonthTotalPerYear monthTotalPerYear = new MonthTotalPerYear(month, amount, isExpense);
            monthsTotalPerYear.add(monthTotalPerYear);
        }
        checkedLoadFile = true;
    }

    public int getAverageExpense() {

        int amountSumExpense = 0;
        for (MonthTotalPerYear monthTotalPerYear : monthsTotalPerYear) {
            if (monthTotalPerYear.isExpense) {
                amountSumExpense += monthTotalPerYear.amount;
                expenses.put(monthTotalPerYear.month, monthTotalPerYear.amount);
            }
        }
        return amountSumExpense / expenses.size();
    }
    public int getAverageProfit() {

        int amountSumProfit = 0;
        for (MonthTotalPerYear monthTotalPerYear : monthsTotalPerYear) {
            if (!monthTotalPerYear.isExpense) {
                amountSumProfit += monthTotalPerYear.amount;
                profits.put(monthTotalPerYear.month, monthTotalPerYear.amount);
            }
        }
        return amountSumProfit / profits.size();
    }
    public HashMap<Integer, Integer> getMonthlyProfit() {
        HashMap<Integer, Integer> monthlyProfits = new HashMap<>();
        for (MonthTotalPerYear monthTotalPerYear : monthsTotalPerYear) {
            int monthlyProfit = profits.get(monthTotalPerYear.month) - expenses.get(monthTotalPerYear.month);
            monthlyProfits.put(monthTotalPerYear.month, monthlyProfit);
        }
        return monthlyProfits;
    }

}
