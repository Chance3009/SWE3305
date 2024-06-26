import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bank {

	public List<Account> accList = new ArrayList<>();
	public Account selectedAcc;

	public void openAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Account No: ");
		String accNo = sc.next();

		if (!isValidAcc(accNo)) {
			System.out.println("Invalid account number: " + accNo
					+ ". Account number should be a 10-digit number that does not start with 0.");
			return;
		} else if (isAccNoExist(accNo)) {
			System.out.println("Invalid account number: " + accNo + ". Account already exists.");
			return;
		}

		System.out.print("Enter Account type ([C]urrent | [S]avings): ");
		String accTypeOption = sc.next();
		Account.AccountType accType = Account.AccountType.CURRENT;

		switch (accTypeOption.charAt(0)) {
		case 'C':
			accType = Account.AccountType.CURRENT;
			break;
		case 'S':
			accType = Account.AccountType.SAVINGS;
			break;
		default:
			System.out.println(
					"Invalid account type: " + accTypeOption + ". Account type can only be current or savings.");
			return;
		}

		accList.add(new Account(accNo, accType, 0));
	}

	public void depositOption(Account acc) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount you want to deposit: RM");
		long amt = sc.nextLong();

		if (amt < 0) {
			System.out.println("Invalid amount: " + amt + ". The deposit amount cannot be a negative number.");
			return;
		} else if (amt > 10000) {
			System.out.println("Invalid amount: " + amt + ". The deposit amount should not exceed RM10000.");
			return;
		}

		acc.deposit(amt);
		acc.showAccount();
	}

	public void withdrawalOption(Account acc) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount you want to withdraw: ");
		long amt = sc.nextLong();

		if (amt < 0) {
			System.out.println("Invalid amount: " + amt + ". The withdrawal amount cannot be negative.");
			return;
		} else if (acc.balance <= amt) {
			System.out.println("Your balance is less than RM" + amt + ". Transaction failed...!!");
			return;
		}

		acc.withdraw(amt);
		acc.showAccount();
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