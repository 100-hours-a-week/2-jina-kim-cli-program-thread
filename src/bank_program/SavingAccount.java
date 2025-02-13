package bank_program;

public class SavingAccount extends Account {
    public double interestRate=0.02;
    private int maxWithdrawals = 3;
    private int withdrawalCount = 0;
    private double lastBalance; // 마지막으로 확인된 잔액

    public SavingAccount(String accountNumber, String owner, double balance) {
        super(accountNumber, owner, balance);
        this.lastBalance=balance;
    }

    public void applyInterest(){
        double interest=balance*interestRate;
        balance+=interest;
    }

    @Override
    public void checkBalance() {
        System.out.println("현재 고객님의 잔액은 " + balance + "원 입니다.");
        if (balance > lastBalance) {
            System.out.println("(이자가 지급되었습니다.)");
            lastBalance = balance;
        }
    }

    @Override
    public void deposit(double money) {
        super.deposit(money);
        System.out.println("이자는 10초마다 지급됩니다.");
    }


    @Override
    public void withdraw(double money) {
        if (withdrawalCount >= maxWithdrawals) {
            System.out.println("출금 횟수가 초과되었습니다. 더 이상 출금할 수 없습니다.");
            return;
        }

        if (money <= 0) {
            System.out.println("출금 금액은 0보다 커야 합니다.");
            return;
        }

        if (balance >= money) {
            super.withdraw(money);
            withdrawalCount++;
            System.out.println("출금이 완료되었습니다. 현재 출금 횟수: " + withdrawalCount + "/" + maxWithdrawals);
            return;
        }

        System.out.println("잔액이 부족합니다.");
    }

}
