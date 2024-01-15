package threading;

class SN1 extends Thread {

    @Override
    public void run() {
        if (account.bal >= 60)
            account.withdraw(60);
    }

    SynchronisedThread account;
    public SN1(SynchronisedThread account) {
        this.account = account;
    }

}

public class SynchronisedThread {
    int bal;
    public SynchronisedThread(int bal) {
        this.bal = bal;
    }

    public static void main(String[] args) {
        SynchronisedThread account = new SynchronisedThread(100);
        SN1 sn1 = new SN1(account);
        SN1 sn2 = new SN1(account);

        sn1.run();
        sn2.run();

        System.out.println("Bal:" + account.bal);
    }

    public synchronized void withdraw(int amt) {
        this.bal = this.bal - amt;
    }
}
