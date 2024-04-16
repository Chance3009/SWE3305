import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bank {  

    public List<Account> accList = new ArrayList<>();
    public Account selectedAcc;
    
    Scanner sc = new Scanner(System.in);  

    public void openAccount() {  
        System.out.print("Enter Account No: ");  
        String accNo = sc.next();
        
        if(!isValidAcc(accNo)) {
        	System.out.println("Invalid account number: " + accNo + ". Account number should be a 10-digit number that does not start with 0.");
        	System.exit(0);
        } else if (isAccNoExist(accNo)) {   
        	System.out.println("Invalid account number: " + accNo + ". Account already exists.");
        	System.exit(0);
        }
        
        System.out.print("Enter Account type ([C]urrent | [S]avings): ");  
        String accTypeOption = sc.next(); 
        Account.AccountType accType = Account.AccountType.CURRENT;
        
    	if (accTypeOption.toUpperCase().charAt(0) == 'C') {
    		accType = Account.AccountType.CURRENT;
    	} else if (accTypeOption.toUpperCase().charAt(0) == 'S') {
    		accType = Account.AccountType.SAVINGS;
    	} else {
        	System.out.println("Invalid account type: " + accTypeOption + ". Account type can only be current or savings.");
        	System.exit(0);
    	}
        
        System.out.print("Enter Name: ");  
        String name = sc.nextLine();  
        
        accList.add(new Account(accNo, name, accType, 0));
    }  

    public void depositOption(Account acc) {  
        System.out.println("Enter the amount you want to deposit: RM");  
        long amt = sc.nextLong();  
        
        if(amt < 0) {
        	System.out.println("Invalid amount: RM" + amt + ". Amount to be deposit cannot be a negative number.");
        	System.exit(0);
        }
        
        acc.deposit(amt);
        acc.showAccount();
    }  

    public void withdrawalOption(Account acc) {  
        System.out.println("Enter the amount you want to withdraw: ");  
        long amt = sc.nextLong();  
        
        if (acc.balance >= amt) {  
            acc.withdraw(amt);
            acc.showAccount();
        } else {  
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!" );  
            System.exit(0);
        }  
    }  
    public boolean isAccNoExist(String accNo) {
        for (Account account : accList) {
            if (account.accNo.equals(accNo)) {
                selectedAcc = account; 
                return true; 
            }
        }
        return false; 
    }

    public boolean isValidAcc(String accNo) {
    	String regex = "^[1-9]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(accNo);
          
    	return matcher.matches();
    }
}  