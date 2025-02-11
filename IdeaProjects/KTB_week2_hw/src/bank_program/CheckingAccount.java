package bank_program;

public class CheckingAccount extends Account{
    public double fee=500;
    public CheckingAccount(String accountNumber, String owner, double balance) {
        super(accountNumber, owner, balance);

    }

    @Override
    public void withdraw(double money){
        double totalAmount=money+fee;
        if (balance >= totalAmount) {
            balance -= totalAmount;
            System.out.println(money + "원이 출금되었습니다. 수수료: " + fee + "원. 현재 잔액: " + balance);
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }
}
