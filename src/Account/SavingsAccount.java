package Account;

import java.text.NumberFormat;

public class SavingsAccount extends Account{
    private final double accountTax;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    public SavingsAccount(String name, int accountNumber, double balance) {
        super(name, accountNumber, balance);
        this.accountTax = (this.getBalance() * 0.8) / 100;
    }

    public double getAccountTax() {
        return accountTax;
    }

    public void yieldTax() {
        if (this.getBalance() > 100) {
            this.setBalance(this.getBalance() + this.getAccountTax());
            System.out.println("Sua conta rendeu " + formatter.format(this.getAccountTax()) + " e seu saldo atual é " + formatter.format(this.getBalance()) + ".");
        } else {
            System.out.println("Infelizmente, sua conta ainda não rendeu nenhum valor.");
        }
    }

}
