package bank_program;

public class StudentAccount extends SavingAccount{
    public StudentAccount(String accountNumber, String owner, double balance) {
        super(accountNumber, owner, balance);
    }

    @Override
    public void withdraw(double money){
        if (money>=50000){
            System.out.println("청소년은 5만원 미만으로 출금 가능합니다.");
        }
        else{
            super.withdraw(money);
        }
    }
}
