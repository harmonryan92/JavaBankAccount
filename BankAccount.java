public class BankAccount {
    //declare your account number, balance and account holder variables
    private int accountNumber;
    private float balance;
    private String accountHolder;

    //getters and setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    //constructor
    public BankAccount(int accountNumber, float balance, String accountHolder) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolder = accountHolder;
    }

    //toString method
    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
                "\nBalance: " + balance +
                "\nAccount Holder: " + accountHolder;
    }

    public void deposit(double depositAmount) {
        balance += depositAmount;
        System.out.println("Deposit to " + accountNumber + " successful! New balance: " + balance);
    }

    public boolean withdraw(double withdrawAmount) {
        if (withdrawAmount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        } else {
            balance -= withdrawAmount;
            System.out.println("Withdraw from " + accountNumber + " successful! New balance: " + balance);
            return true;
        }
    }

    public int compare(BankAccount other) {
        if (balance > other.balance) {
            System.out.println(this.accountNumber+" has more money than "+other.accountNumber);
            return 0;
        } else if (balance < other.balance) {
            System.out.println(other.accountNumber+" has more money than "+this.accountNumber);
            return 0;
        } else {
            System.out.println(this.accountNumber+" has the same amount as "+other.accountNumber);
            return 0;
        }
    }

    public void transfer(BankAccount otherAccount, double amount) {
        boolean transferCheck = this.withdraw(amount);

        if (transferCheck) {
            otherAccount.deposit(amount);
        }
    }
}
