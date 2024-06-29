import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankingAppTest {

	private ByteArrayOutputStream actualOutput;

	@BeforeEach
	public void setUp() {
		BankingApp bankingApp = new BankingApp();
		actualOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(actualOutput));
		BankingApp.bank.accList = new ArrayList<>(
				Arrays.asList(new Account("1234567890", Account.AccountType.SAVINGS, 9000)));
	}

	@Test
	public void TC_02_001() {
		String userInput = "2\n12345\n6\n";

		String expectedOutput = "Your typed account number is invalid. Please ensures that it contains exactly 10 digits.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_02_002() {
		String userInput = "2\n1234567890\n6\n";

		String expectedOutput = "-----Checking if your account exists to proceed with search-----";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_02_003() {
		String userInput = "2\n12345678901\n6\n";

		String expectedOutput = "Your typed account number is invalid. Please ensures that it contains exactly 10 digits.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_02_004() {
		String userInput = "2\nABCDE12345\n6\n";

		String expectedOutput = "Your typed account number is invalid. Please ensures that it contains exactly 10 digits.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_02_005() {
		String userInput = "2\n1234567890\n6\n";

		String expectedOutput = "Account no.: 1234567890\r\nAccount type: Savings\r\nBalance: RM9000";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_02_006() {
		String userInput = "2\n9876543210\n6\n";

		String expectedOutput = "Search failed! Account doesn't exist..!!";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_03_001() {
		String userInput = "3\n12345\n6\n";

		String expectedOutput = "Your typed account number is invalid. Please ensures that it contains exactly 10 digits before performing deposit operation";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_03_002() {
		String userInput = "3\n1234567890\n0\n6\n";

		String expectedOutput = "-----Checking if your account exists to perform deposit-----";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_03_003() {
		String userInput = "3\n12345678901\n6\n";

		String expectedOutput = "Your typed account number is invalid. Please ensures that it contains exactly 10 digits before performing deposit operation.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_03_004() {
		String userInput = "3\nABCDE12345\n6\n";

		String expectedOutput = "Your typed account number is invalid. Please ensures that it contains exactly 10 digits before performing deposit operation.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_03_005() {
		String userInput = "3\n1234567890\n-1\n6\n";
		String expectedOutput = "Enter the amount you want to deposit: RM";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_03_006() {
		String userInput = "3\n9876543210\n6\n";

		String expectedOutput = "Search failed! Account doesn't exist..!! You can't deposit money to an account that you don't own!";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_03_007() {
		String setupUserInput = "3\n1234567890\n-100\n6\n";
		String expectedOutput = "Invalid amount: -100. The deposit amount cannot be a negative number.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(setupUserInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_03_008() {
		String userInput = "3\n1234567890\n8000\n6\n";

		String expectedOutput = "You have successfully deposit RM8000 to account 1234567890\r\nAccount no.: 1234567890\r\nAccount type: Savings\r\nBalance: RM17000";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_03_009() {
		String userInput = "3\n1234567890\n15000\n6\n";

		String expectedOutput = "Invalid amount: 15000. The deposit amount should not exceed RM10000.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_04_001() {
		String userInput = "4\n12345\n6\n";

		String expectedOutput = "Your typed account number is invalid. Please ensures that it contains exactly 10 digits before performing withdrawal operation.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_04_002() {
		String userInput = "4\n1234567890\n0\n6\n";

		String expectedOutput = "-----Checking if your account exists to perform withdrawal-----";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_04_003() {
		String userInput = "4\n12345678901\n6\n";

		String expectedOutput = "Your typed account number is invalid. Please ensures that it contains exactly 10 digits before performing withdrawal operation.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_04_004() {
		String userInput = "4\nABCDE12345\n6\n";

		String expectedOutput = "Your typed account number is invalid. Please ensures that it contains exactly 10 digits before performing withdrawal operation.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_04_005() {
		String userInput = "4\n1234567890\n-1\n6\n";

		String expectedOutput = "Enter the amount you want to withdraw: RM";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_04_006() {
		String userInput = "4\n9876543210\n6\n";

		String expectedOutput = "Search failed! Account doesn't exist..!! You can't withdraw money from an account that you don't own!";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_04_007() {
		String userInput = "4\n1234567890\n-100\n6\n";
		String expectedOutput = "Invalid amount: -100. The withdrawal amount cannot be negative.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_04_008() {
		String userInput = "4\n1234567890\n5000\n6\n";

		String expectedOutput = "You have successfully withdraw RM5000 from account 1234567890\r\nAccount no.: 1234567890\r\nAccount type: Savings\r\nBalance: RM4000";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_04_009() {
		String userInput = "4\n1234567890\n20000\n6\n";

		String expectedOutput = "Your balance is less than RM20000. Withdrawal failed...!!";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_05_001() {
		String userInput = "5\n12345\n6\n";

		String expectedOutput = "Invalid account number: 12345. Account number should be a 10-digit number that does not start with 0.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));

	}

	@Test
	public void TC_05_002() {
		String userInput = "5\n1234567890\n6\n";

		String expectedOutput = "-----Checking if your account exists to perform account opening-----";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_05_003() {
		String userInput = "5\n12345678901\n6\n";

		String expectedOutput = "Invalid account number: 12345678901. Account number should be a 10-digit number that does not start with 0.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_05_004() {
		String userInput = "5\nABCDE12345\n6\n";

		String expectedOutput = "Invalid account number: ABCDE12345. Account number should be a 10-digit number that does not start with 0.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_05_005() {
		String userInput = "5\n1234567890\n6\n";

		String expectedOutput = "Invalid account number: 1234567890. Account already exists.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_05_006() {
		String userInput = "5\n9876543210\nC\n6\n";

		String expectedOutput = "Enter Account type ([C]urrent | [S]avings):";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_05_007() {
		String userInput = "5\n9876543210\nS\n6\n";

		String expectedOutput = "Opening a savings account...";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_05_008() {
		String userInput = "5\n9876543210\nP\n6\n";

		String expectedOutput = "Invalid account type: P. Account type can only be current or savings.";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_07_001() {
		String userInput = "1\n1234567890\n6\n";

		String expectedOutput = "-----Display All Accounts-----";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_07_002() {
		String userInput = "2\n1234567890\n6\n";
		String expectedOutput = "-----Search Account-----";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_07_003() {
		String userInput = "3\n123456789\n6\n";
		String expectedOutput = "-----Deposit-----";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_07_004() {
		String userInput = "4\n123456789\n6\n";
		String expectedOutput = "-----Withdrawal-----";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_07_005() {
		String userInput = "5\n19\n6\n";
		String expectedOutput = "-----Open New Account-----";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_07_006() {
		String userInput = "6\n";
		String expectedOutput = "See you next time!";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

	@Test
	public void TC_07_007() {
		String userInput = "7\n6\n";
		String expectedOutput = "Please enter valid option [1-6]";

		ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(inputStream);

		BankingApp.main(new String[0]);

		assertTrue(actualOutput.toString().contains(expectedOutput));
	}

}
