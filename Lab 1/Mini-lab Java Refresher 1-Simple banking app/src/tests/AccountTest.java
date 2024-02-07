package tests;

import model.Account;
import utils.TestUtils;

import java.util.Date;

public class AccountTest {

    public static void testAccountConstructor() {
        String test_account_number = "1";
        String test_username = "mike";
        String test_account_type = "Standard";
        Date test_account_opening_date = new Date(2024, 1, 1, 12, 30);

        Account testAccount = new Account(test_account_number, test_username, test_account_type, test_account_opening_date);

        if (testAccount.getAccount_number() == test_account_number)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getAccount_number-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getAccount_number-Failed: account number did not match" + TestUtils.TEXT_COLOR_RESET);

        if (testAccount.getUsername() == test_username)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getUsername-Failed: username did not match" + TestUtils.TEXT_COLOR_RESET);

        if (testAccount.getAccount_type() == test_account_type)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getAccount_type-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getAccount_type-Failed: account type did not match" + TestUtils.TEXT_COLOR_RESET);

        if (testAccount.getAccount_opening_date() == test_account_opening_date)
            System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getAccount_opening_date-Passed" + TestUtils.TEXT_COLOR_RESET);
        else
            System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getAccount_opening_date-Failed: account opening date did not match" + TestUtils.TEXT_COLOR_RESET);

        assert testAccount.getAccount_number() == test_account_number;
        assert testAccount.getUsername() == test_username;
        assert testAccount.getAccount_type() == test_account_type;
        assert testAccount.getAccount_opening_date() == test_account_opening_date;

        System.out.println(TestUtils.TEXT_COLOR_GREEN + "All Java assertions in the test suite passed (none failed)." + TestUtils.TEXT_COLOR_RESET);
    }

    public static void main(String[] args) {
        testAccountConstructor();

        Account testAccount = new Account("1", "mike", "Standard", new Date(2024, 1, 1, 12, 30));

        System.out.println(testAccount);
    }
}
