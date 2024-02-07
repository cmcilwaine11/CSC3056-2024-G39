package tests;

import model.Transaction;
import utils.TestUtils;

import java.util.Date;

public class TransactionTest {

    public static void testTransactionConstructor() {
        String test_account_number = "1";
        double test_transaction_amount = 100;
        Date test_transaction_date = new Date(2024, 2, 1, 12, 30);

        Transaction testTransaction = new Transaction(test_account_number, test_transaction_amount, test_transaction_date);

        if (testTransaction.getAccount_number() == test_account_number)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getAccount_number-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getAccount_number-Failed: account number did not match" + TestUtils.TEXT_COLOR_RESET);

        if (testTransaction.getTransaction_amount() == test_transaction_amount)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getTransaction_amount-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getTransaction_amount-Failed: transaction amount did not match" + TestUtils.TEXT_COLOR_RESET);

        if (testTransaction.getTransaction_date() == test_transaction_date)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getTransaction_date-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getTransaction_date-Failed: transaction date did not match" + TestUtils.TEXT_COLOR_RESET);

        assert testTransaction.getAccount_number() == test_account_number;
        assert testTransaction.getTransaction_amount() == test_transaction_amount;
        assert testTransaction.getTransaction_date() == test_transaction_date;

        System.out.println(TestUtils.TEXT_COLOR_GREEN + "All Java assertions in the test suite passed (none failed)." + TestUtils.TEXT_COLOR_RESET);
    }

    public static void main(String[] args) {
        testTransactionConstructor();

        Transaction testTransaction = new Transaction("1", 100, new Date(2024, 2, 1, 12, 30));

        System.out.println(testTransaction);
    }
}
