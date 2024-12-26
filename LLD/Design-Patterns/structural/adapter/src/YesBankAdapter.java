public class YesBankAdapter implements BankAPI {

    private YesBankAPI yesBankAPI = new YesBankAPI();

    @Override
    public double getBalance(String accountNumber) {
        return 0;
    }

    @Override
    public boolean sendMoney(String fromAccount, String toAccount, double amount) {
        System.out.println("Yes Bank API is sending money of " + amount + " from " + fromAccount + " to " + toAccount);
        return false;
    }
}
