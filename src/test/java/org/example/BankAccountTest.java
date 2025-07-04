package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private ArrayList<BankAccount> bankAccounts;
    private BankAccount bankAccount;

    @BeforeEach
    void setup(){
        String accountNumber = "123456";
        String accountName = "";
        double accountBalance = 0;
        bankAccount = new BankAccount(accountNumber, accountName, accountBalance);
    }

    @Test
    void shouldDepositValidAmount(){
        double actual = bankAccount.depositMoney(800);
        assertEquals(800, actual, 0.01);
    }

    @Test
    void shouldNotDepositInvalidAmount(){
        double actual = bankAccount.depositMoney(0);
        assertEquals(0, actual, 0.01);
    }

    @Test
    void shouldWithdrawValidAmount(){
        double actual = bankAccount.withdrawMoney(100);
        assertEquals(100, actual, 0.01);
    }

    @Test
    void shouldNotWithdrawInvalidAmount(){
        double actual = bankAccount.withdrawMoney(0);
        assertEquals(0, actual, 0.01);
    }

    @Test
    void shouldNotWithdrawMoreThanBalance(){
        double actual = bankAccount.withdrawMoney(0);
        assertEquals(0, actual, 0.01);
    }

    @Test
    void shouldGetAccountNumber(){
        String actual = bankAccount.getAccountNumber();
        assertEquals("123456", actual);
    }

    @Test
    void shouldNotCreateBankAccountWithoutDeposit(){
        double actual = bankAccount.createAccount(0);
        assertEquals(0, actual, 0.01);
    }
}
