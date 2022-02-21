import org.testng.Assert;

public class CustomerServices {

    Customer customer;
    public CustomerServices(Customer customer)
    {
        this.customer= customer;
    }
    public void payWithWalletAmount(double amountToPay) {
        Assert.assertTrue(customer.getWallet().getWalletBalance() > amountToPay, "Not enough balance");
        amountToPay = customer.getWallet().discountOver100Rs(amountToPay);
        double walletBalance = customer.getWallet().getWalletBalance();
        walletBalance -=amountToPay;
        customer.getWallet().setWalletBalance(walletBalance);
        customer.getWallet().setAmountPaid(amountToPay);
    }


}
