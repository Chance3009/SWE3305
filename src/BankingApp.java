import java.util.Scanner;

public class BankingApp {
	public static void main(String arg[]) {
		Bank bank = new Bank();
		Scanner sc = new Scanner(System.in);
		int ch;
		do {
			System.out.println("\n ***Banking System Application***");
			System.out.println("-------------------------------------");
			System.out.println("Welcome, Aisyah!");
			System.out.println("1. Display all accounts details");
			System.out.println("2. Search by account number");
			System.out.println("3. Deposit an amount");
			System.out.println("4. Withdraw an amount");
			System.out.println("5. Open a new account");
			System.out.println("6. Exit");
			System.out.print("\nEnter your choice: ");

			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("-----Display All Accounts-----");
				for (Account acc : bank.accList) {
					acc.showAccount();
				}
				break;
			case 2:
				System.out.println("-----Search Account-----");
				System.out.print("Enter account no. you want to search: ");
				String ac_no = sc.next();

				if (!bank.isValidAcc(ac_no)) {
					System.out.println(
							"Your typed account number is invalid. Please ensures that it contains exactly 10 digits.");
					break;
				}
				System.out.println("-----Checking if your account exists to proceed with search-----");

				if (!bank.isAccNoExist(ac_no)) {
					System.out.println("Search failed! Account doesn't exist..!!");
					break;
				}

				bank.selectedAcc.showAccount();
				break;
			case 3:
				System.out.println("-----Deposit-----");
				System.out.print("Enter Account no. : ");
				ac_no = sc.next();

				if (!bank.isValidAcc(ac_no)) {
					System.out.println(
							"Your typed account number is invalid. Please ensures that it contains exactly 10 digits before performing deposit operation.");
					break;
				}
				System.out.println("-----Checking if your account exists to perform deposit-----");

				if (!bank.isAccNoExist(ac_no)) {
					System.out.println(
							"Search failed! Account doesn't exist..!! You can't deposit money to an account that you don't own!");
					break;
				}

				bank.depositOption(bank.selectedAcc);
				break;
			case 4:
				System.out.println("-----Withdrawal-----");
				System.out.print("Enter Account no. : ");
				ac_no = sc.next();

				if (!bank.isValidAcc(ac_no)) {
					System.out.println(
							"Your typed account number is invalid. Please ensures that it contains exactly 10 digits before performing withdrawal operation.");
					break;
				}
				System.out.println("-----Checking if your account exists to perform withdrawal-----");

				if (!bank.isAccNoExist(ac_no)) {
					System.out.println(
							"Search failed! Account doesn't exist..!! You can't withdraw money from an account that you don't own!");
					break;
				}

				bank.withdrawalOption(bank.selectedAcc);
				break;
			case 5:
				System.out.println("-----Open New Account-----");
				bank.openAccount();
				break;
			case 6:
				System.out.println("See you next time!");
				break;
			default:
				System.out.println("\nPlease enter valid option [1-6]");
			}
		} while (ch != 6);
	}
}
