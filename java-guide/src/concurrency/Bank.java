package concurrency;

public class Bank{
    double amount;
    int maxAccountId;

    public Bank(int maxAccountId, double amount) {
        this.amount = amount;
        this.maxAccountId = maxAccountId;
    }

    public void transfer(int from,int to,double amount){
        System.out.println( Thread.currentThread().getThreadGroup().getName() + "from " + from + " to " + to + ", amount: " + amount);
    }
}