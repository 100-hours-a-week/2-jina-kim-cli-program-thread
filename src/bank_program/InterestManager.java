package bank_program;

import java.util.HashMap;

public class InterestManager implements Runnable {
    private final HashMap<String, Account> accounts;

    public InterestManager(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("이자 지급 스레드가 중단되었습니다.");
                return;
            }
            synchronized (accounts) {
                for (Account account : accounts.values()) {
                    if (account instanceof SavingAccount) {
                        ((SavingAccount) account).applyInterest();
                    }
                }
            }
        }
    }
}
