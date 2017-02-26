package innerclass;

import lambda.pojos.Person;

/**
 * Description:Java静态嵌套类、内部类测试
 * Created by lvhw on 2016/11/21 23:08.
 */
public class BankAccount {

    private long number; // account number
    private long balance; // current balance
    private Action lastAction; // last action performed


    public BankAccount(long number, long balance, Action action) {
        this.number = number;
        this.balance = balance;
        this.lastAction = action;
    }

    public Permissions permissionsFor(Person who) {
        Permissions permissions = new Permissions();
        permissions.canDeposit = this.canDeposit(who);
        permissions.canWithdraw = this.canWithdraw(who);
        permissions.canClose = this.canClose(who);
        return permissions;
    }

    public void deposit(long amount) {
        balance += amount;
        //this.lastAction = new Action("deposit", amount);
        this.lastAction = this.new Action("deposit", amount);
        //this.lastAction.toString();
    }

    public void withdraw(long amount) {
        balance -= amount;
        this.lastAction = new Action("withdraw", amount);
    }

    public void transfer(BankAccount other, long amount) {
        other.withdraw(amount);
        other.lastAction = other.new Action("transfer", amount);

        this.deposit(amount);
        this.lastAction = this.new Action("transfer", amount);
    }

    private boolean canDeposit(Person person) {
        return true;
    }

    private boolean canWithdraw(Person person) {
        return true;
    }

    private boolean canClose(Person person) {
        return false;
    }

    /**
     * 静态嵌套类，权限类
     */
    public static class Permissions {
        private boolean canDeposit;
        private boolean canWithdraw;
        private boolean canClose;

        public String printAccountInfo(BankAccount account) {
            return "account number is:" + account.number + ", and current balance is:" + account.balance;
        }
    }

    /**
     * 内部类，操作类
     */
    private class Action {
        private String act;
        private long amount;

        public Action(String act, long amount) {
            this.act = act;
            this.amount = amount;
        }

        @Override
        public String toString() {
            // account's action info
            //return number + ": " + act + " " + amount;
            return BankAccount.this.number + ": " + act + " " + amount;
        }
    }
}
