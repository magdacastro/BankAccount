package Account;

import java.util.Scanner;

public class CurrentAccount extends Account{
    private final double loanLimit;
    Scanner scan = new Scanner(System.in);

    public CurrentAccount(String name, int accountNumber, double balance) {
        super(name, accountNumber, balance);
        this.loanLimit = this.getBalance() * 1.8;
    }

    @Override
    public void withdraw(double value) {

        if(this.isApplyForLoan()){
            System.out.println("Você tem " + formatter.format(this.getLoanLimit()) + " para pegar emprestado. Gostaria de realizar o empréstimo? \n");
            System.out.println("1 - SIM\n");
            System.out.println("2 - NÃO\n");
            int option = Integer.parseInt(scan.nextLine());

            if (option == 1) {
                this.makeLoan();
                System.out.println("Gostaria de sacar o valor de " + formatter.format(value) + "? \n");
                System.out.println("1 - SIM\n");
                System.out.println("2 - NÃO\n");
                int opt = Integer.parseInt(scan.nextLine());

                switch (opt) {
                    case 1:
                        this.setBalance(this.getBalance() - value);
                        System.out.println("Saldo realizado com sucesso!");
                        break;
                    case 2:
                        System.out.println("Encerrando sua sessão. Obrigado!");
                        break;
                }
            } else if (option == 2) {
                System.out.println("Estamos processando seu saque. Aguarde...");
                this.setBalance(this.getBalance() - value);
                System.out.println("Saque de " + formatter.format(value) + " realizado com sucesso!");
            }
        } else if (value > 0 && value <= this.getBalance()) {
            this.setBalance(this.getBalance() - value);
            System.out.println("Saque de " + formatter.format(value) + " realizado com sucesso!");
        } else {
            System.out.println("Você não possui saldo suficiente.");
        }
    }

    public void checkLoan(){
        if(this.isApplyForLoan()){
            System.out.println("Você possui " + this.getLoanLimit() + " para pegar de empréstimo. Gostaria de realizá-lo?");
            System.out.println("1 - SIM\n");
            System.out.println("2 - NÃO\n");
            int option = Integer.parseInt(scan.nextLine());

            if (option == 1) {
                this.makeLoan();
            } else if (option == 2) {
                System.out.println("Estamos encerrando sua sessão. Obrigado.");
            }

        } else {
            System.out.println("Infelizmente, não foi liberado empréstimo a você. Mas não se preocupe. Continue usando sua conta que logo será liberado.");
        }
    }

    private void makeLoan(){
        this.setBalance(this.getBalance() + loanLimit);
        System.out.println("Seu saldo atual é " + formatter.format(this.getBalance()));
    }

    private boolean isApplyForLoan() {
        return this.getBalance() >= 350;
    }

    public double getLoanLimit() {
        return loanLimit;
    }

}
