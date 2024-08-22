package Account;

import java.text.NumberFormat;

public class Account {
    protected int accountNumber;
    protected String name;
    protected double balance;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public Account(String name, int accountNumber, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }

        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    public void deposit(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Você precisa depositar um valor.");
        }
        this.setBalance(this.getBalance() + value);
        System.out.println("Depósito realizado com sucesso!");
    }

    public void withdraw(double value) {

        if (value > 0 && value <= this.getBalance()) {
            this.setBalance(this.getBalance() - value);
            System.out.println("Saque de " + formatter.format(value) + " realizado com sucesso!");
        }
        System.out.println("Você não possui saldo suficiente.");
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
