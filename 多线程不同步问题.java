package test2;

public class test11 {
    public static void main(String[] args) {
        Account account = new Account();
        User user = new User(account, 3000);
        Thread thread = new Thread(user, "客户端1");
        User user1 = new User(account, 4000);
        Thread thread1 = new Thread(user1, "客户端2");
        thread.start();
        thread1.start();
        /*
        *客户端1已消费:3000
        *客户端2已消费:4000
        *客户端1余额:2000
         *客户端2余额:-2000
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
        account.consume(Thread.currentThread().getName(), m);
    }
}
class Account {
    static int money = 5000;
    void consume(String name, int m) {
        if(money - m < 0) {
            System.out.println(name + "余额不足！");
            return;
        }
        System.out.println(name + "已消费:" + m);
        money -= m;
        System.out.println(name + "余额:" + money);
    }
}
