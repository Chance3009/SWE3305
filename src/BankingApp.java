import java.util.Scanner;  

public class BankingApp {  
    public static void main(String arg[]) { 
    	Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);  

        int ch;  
        do {  
            System.out.println("\n ***Banking System Application***");  
            System.out.println("1. Display all account details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Open a new account \n 6.Exit ");  
            System.out.println("Enter your choice: ");  
            
            ch = sc.nextInt();  
                switch (ch) {  
                    case 1:  
                        for (Account acc : bank.accList) {
                            acc.showAccount();
                        }         
                        break;  
                    case 2:  
                        System.out.print("Enter account no. you want to search: ");  
                        String ac_no = sc.next();  
                        boolean found = bank.isAccNoExist(ac_no);  
                        
                        if (found) {  
                        	bank.selectedAcc.showAccount();
                        } else {
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }
                        
                        break;  
                    case 3:  
                        System.out.print("Enter Account no. : ");  
                        ac_no = sc.next();  
                        found = bank.isAccNoExist(ac_no);  
                        
                        if (found) {  
                        	bank.depositOption(bank.selectedAcc);
                        } else {
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }
                        
                        break;  
                    case 4:  
                        System.out.print("Enter Account no. : ");  
                        ac_no = sc.next();  
                        found = bank.isAccNoExist(ac_no);  
                        
                        if (found) {  
                        	bank.withdrawalOption(bank.selectedAcc);
                        } else {
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }
                        
                        break;  
                    case 5:  
                    	bank.openAccount();
						break;  
                    case 6:
                    	  System.out.println("See you soon...");  
                          System.exit(0);
                }  
            }  
            while (ch != 6);  
        }  
    }  