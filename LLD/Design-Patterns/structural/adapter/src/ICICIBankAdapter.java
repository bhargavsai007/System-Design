public class ICICIBankAdapter implements BankAPI {

    private ICICIBankAPI iciciBankAPI = new ICICIBankAPI();

    @Override
    public double getBalance(String accountNumber) {
        return 0;
    }

    @Override
    public boolean sendMoney(String fromAccount, String toAccount, double amount) {
        System.out.println("ICICI Bank API is sending money of " + amount + " from " + fromAccount + " to " + toAccount);
        return false;
    }
}
