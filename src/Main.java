import Account.Account;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Account account = new Account("Joana Costa", 4512586, 15.90);
        account.deposit(26.80);
        System.out.println(account.getBalance());


    }
}