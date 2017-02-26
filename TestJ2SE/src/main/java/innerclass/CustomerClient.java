package innerclass;

import lambda.pojos.Person;

/**
 * Description:
 * Created by lvhw on 2016/11/21 23:23.
 */
public class CustomerClient {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1, 100000000, null);
        Person lvhw = new Person("lv", "hongwei", "engineer", "man", 28, 10000);
        BankAccount.Permissions perm = account.permissionsFor(lvhw);


        String accountInfo = perm.printAccountInfo(account);
        System.out.println(accountInfo);
    }
}
