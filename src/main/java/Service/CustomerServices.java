package Service;

import Shopping.Customer;

public class CustomerServices {

    public Customer customer;
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

}
