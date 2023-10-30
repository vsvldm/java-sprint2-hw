import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    FileReader fileReader = new FileReader();
    public ArrayList<Transaction> transactions = new ArrayList<>();
    HashMap<String, Integer> profits = new HashMap<>();
    HashMap<String, Integer> expenses = new HashMap<>();
    public int monthForReport = 0;

    boolean checkedLoadFile = false;

    public void loadMonthlyReport(int month, String fileName) {
        monthForReport = month;
        ArrayList<String> lines = fileReader.readFileContents(fileName);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] lineContent = line.split(",");
            String itemName = lineContent[0];
            boolean isExpense = Boolean.parseBoolean(lineContent[1]);
            int quantity = Integer.parseInt(lineContent[2]);
            int unitPrice = Integer.parseInt(lineContent[3]);

            Transaction transaction = new Transaction(itemName, isExpense, quantity, unitPrice, month);
            transactions.add(transaction);
        }
        checkedLoadFile = true;
    }
    public void topProfitAndNameProduct(){
        int mostProfit = 0;
        String mostProfitTitle = null;
        for (Transaction transaction : transactions) {
            if(!transaction.isExpense) {
                int profitProduct = transaction.quantity * transaction.unitPrice;
                profits.put(transaction.itemName, profitProduct);
                if (profitProduct > mostProfit){
                    mostProfit = profitProduct;
                    mostProfitTitle = transaction.itemName;
                }
            }
        }
        System.out.println("Самый прибыльный товар: " + mostProfitTitle);
        System.out.println("Прибыль составила: " + mostProfit);
    }
    public void maxExpenseAndName() {
        int maxExpense = 0;
        String titleMaxExpense = null;
        for (Transaction transaction : transactions) {
            if(transaction.isExpense) {
                int expense = transaction.quantity * transaction.unitPrice;
                expenses.put(transaction.itemName, expense);
                if (expense > maxExpense) {
                    maxExpense = expense;
                    titleMaxExpense = transaction.itemName;
                }
            }
        }
        System.out.println("Самая большая трата: " + titleMaxExpense);
        System.out.println("Сумма затрат: " + maxExpense);

    }
    public int sumProfit() {
        int profitSum = 0;
        for (Transaction transaction : transactions){
            profitSum += profits.getOrDefault(transaction.itemName, 0);
        }
        return profitSum;
    }
    public int sumExpenses() {
        int expenseSum = 0;
        for (Transaction transaction : transactions){
            expenseSum += expenses.getOrDefault(transaction.itemName, 0);
        }
        return expenseSum;
    }
}
