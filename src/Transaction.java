public class Transaction {
    public String itemName;
    public boolean isExpense;
    public int quantity;
    public int unitPrice;
    public int month;

    public Transaction(String itemName, boolean isExpense, int quantity, int unitPrice, int month) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.month = month;
    }
}
