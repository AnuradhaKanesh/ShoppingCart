import org.testng.Assert;

public class CustomerServices {

    Customer customer;
    public CustomerServices(Customer customer)
    {
        this.customer= customer;
    }

    public void payWithWalletAmount(double amountToPay) {
        double walletBalance = customer.getWallet().getWalletBalance();
        walletBalance -=amountToPay;
        customer.getWallet().setWalletBalance(walletBalance);
        customer.getWallet().setAmountPaid(amountToPay);
    }


    public void payWithWalletAmount(double amountToPay, String discount, String priceOver) {



    }
}
