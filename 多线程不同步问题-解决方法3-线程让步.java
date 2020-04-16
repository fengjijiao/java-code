package test2;

public class test11 {
    public static void main(String[] args) {
        Account account = new Account();
        Account account1 = new Account();
        User user = new User(account, 3000);
        Thread thread = new Thread(user, "客户端1");
        User user1 = new User(account1, 4000);
        Thread thread1 = new Thread(user1, "客户端2");
        thread.start();
        thread1.start();
        /*
        *客户端1已消费:3000
        *客户端1余额:2000
         *客户端2余额不足！
        */
    }
}
class User implements Runnable {
    static Thread thread;
    Account account;
    int m;
    User(Account account, int m) {
        this.account = account;
        this.m = m;
    }
    @Override
    public void run() {
        /**这种方式必须保证synchronized作用对象相同例如，都作用于thread
         */
        if(Thread.currentThread().getName().equals("客户端1")) {
            thread = Thread.currentThread();
            synchronized (thread) {
                try {
                    thread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        account.consume(Thread.currentThread().getName(), m);
        if(Thread.currentThread().getName().equals("客户端2")) {
            synchronized (thread) {
                thread.notify();
            }
        }
    }
}
class Account {
    static int money = 5000;//注意这里必须是类变量
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
