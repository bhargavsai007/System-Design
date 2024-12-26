public interface BankAPI {

    double getBalance(String accountNumber);

    boolean sendMoney(String fromAccount, String toAccount, double amount);
}
