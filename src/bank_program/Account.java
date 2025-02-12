package bank_program;

public class Account {
    public String accountNumber;
    public String owner;
    public double balance;

    public Account(String accountNumber, String owner, double balance){
        this.accountNumber=accountNumber;
        this.owner=owner;
        this.balance=balance;
    }

    public void deposit(double money){
        balance+=money;
        System.out.println(money+"원이 입금되었습니다. 현재 잔액:"+balance);
    }

    public void withdraw(double money){
        if (balance>=money){
            balance-=money;
            System.out.println(money+"원이 출금되었습니다. 현재 잔액:"+balance);
        }
        else{
            System.out.println("잔액이 부족합니다.");
        }
    }

    public void checkBalance(){
        System.out.println("현재 고객님의 잔액은 "+balance+"원 입니다.");
    }

}
