package model;

import java.util.Date;

public class Account {
    String account_number;
    String username; // email
    String account_type; // Standard OR Saving
    Date account_opening_date;

    public Account(String account_number, String username, String account_type, Date account_opening_date) {
        this.account_number = account_number;
        this.username = username;
        this.account_type = account_type;
        this.account_opening_date = account_opening_date;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public Date getAccount_opening_date() {
        return account_opening_date;
    }

    public void setAccount_opening_date(Date account_opening_date) {
        this.account_opening_date = account_opening_date;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_number='" + account_number + '\'' +
                ", username='" + username + '\'' +
                ", account_type='" + account_type + '\'' +
                ", account_opening_date=" + account_opening_date +
                '}';
    }
}
