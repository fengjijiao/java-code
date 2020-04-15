package test2;

public class test11 {
    public static void main(String[] args) {
        Account account = new Account();
        Account account1 = new Account();
        User user = new User(account, 3000);
        Thread thread = new Thread(user);
        User user1 = new User(account1, 3000);
        Thread thread1 = new Thread(user1);
        thread.start();
        thread1.start();
        /*
        *余额:2000
        *余额不足！
        *Thread-0已消费:3000
        *Thread-1已消费:3000
        */
    }
}
class User implements Runnable {
    Account account;
    int m;
    User(Account account, int m) {
        this.account = account;
        this.m = m;
    }
    @Override
    public void run() {
        account.consume(m);
        System.out.println(Thread.currentThread().getName() + "已消费:" + m);
    }
}
class Account {
    static int money = 5000;
    void consume(int m) {
        if(money - m < 0) {
            System.out.println("余额不足！");
            return;
        }
        money -= m;
        System.out.println("余额:" + money);
    }
}
