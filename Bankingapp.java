
class invalidAmountException extends Exception {
    public invalidAmountException(String message) {
        super(message);
    }
}
class account {
    String accountNumber;
    String accountHolderName;
    double balance;

    public account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }
    public void deposit (double amount)
    {
        if(amount>0)
        {
            balance+=amount;
            System.out.println("DEPOSITED: "+ amount);
        } else {
            System.out.println("amount must be positive");
        }
    }
    public void withdraw(double amount) throws invalidAmountException
    {
        if(amount>balance)
        {
            throw new invalidAmountException("insuffiecnt fund for withdrawl");
        } else if(amount<=0)
        {
            throw new invalidAmountException("wihtdrawl must be psotive");
        } else 
        {
            balance -= amount;
            System.out.println("wihtdraw: "+ amount);
        }
    }
    public double getBalance()
    {
        return balance;
    }
}

public class Bankingapp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Banking Application");
        account myAccount = new account("123456789", "Arpit Anand", 1000.0);
        myAccount.deposit(500.0);       
        
        try {
            myAccount.withdraw(2000.0); 
        } catch (invalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }   
        System.out.println("Current Balance: " + myAccount.getBalance());

    }
    
}
