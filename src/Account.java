public class Account {
    protected String accNo;  
    protected AccountType accType;  
    protected long balance;  
    
    enum AccountType {
        SAVINGS, CURRENT;
    }
    
    public Account(String accNo, AccountType accType, long balance) {
    	this.accNo = accNo;
    	this.accType = accType;
    	this.balance = balance;
    }
    
    public void showAccount() {  
        System.out.println("Account no.: " + accNo);  
        System.out.println("Account type: " + accType.toString().substring(0,1) + accType.toString().substring(1).toLowerCase());  
        System.out.println("Balance: RM" + balance + "\n");  
    }  
    
    public void deposit(long amount) { 
        balance += amount;  
    }  
    
    public void withdraw(long amount) { 
        balance -= amount;  
    }
}
