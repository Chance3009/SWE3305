import java.util.Scanner;

public class BankingApp {
	public static void main(String arg[]) {
		Bank bank = new Bank();
		Scanner sc = new Scanner(System.in);

		int ch;
		do {
			System.out.println("\n ***Banking System Application***");
			System.out.println("1. Display all accounts details");
			System.out.println("2. Search by account number");
			System.out.println("3. Deposit the amount");
			System.out.println("4. Withdraw the amount");
			System.out.println("5. Open a new account");
			System.out.println("6. Exit");

			System.out.print("\nEnter your choice: ");

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
				System.out.println("See you next time!");
				sc.close();
				System.exit(0);
			default:
				System.out.println("\nPlease enter valid option [1-6]");
			}
		} while (ch != 6);
	}
}
