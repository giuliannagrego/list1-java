package entities;

public class Account {
    private String accountHolderName;
    private int accountNumber;
    private double accountSalary;
    public Account(int id){

    }
    public Account(int id, String accountHolderName){
        this.accountNumber = id;
        this.accountHolderName = accountHolderName;
    }
    public Account(int id, String accountHolderName, double accountSalary) {
        this.accountNumber = id;
        this.accountHolderName = accountHolderName;
        this.accountSalary = accountSalary;
    }

    public String setAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getAccountNumber(){
        return accountNumber;
    }
    public double getAccountSalary() {
        return accountSalary;
    }
    public void setAccountSalary(Double salary) {
        this.accountSalary = salary;
    }
    public void increaseSalary(double percentage) {
        accountSalary += accountSalary * percentage / 100.0;
    }
    public String toString() {
        return accountNumber
                + ", "
                + accountHolderName
                + ", "
                + String.format("%.2f", accountSalary);
    }
}
