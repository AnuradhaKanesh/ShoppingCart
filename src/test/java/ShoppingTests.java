import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.Collectors;


public class ShoppingTests {
    Items itemsApples, itemsMilk, itemsNewspaper;
    eWallet wallet;
    Customer customer;
    CartServices cartServices;

    @BeforeMethod
    public void addItemsToCustomersCart() {

        itemsApples = Apple.builder().itemName("Apple").measurementUnit("Kg").price(20.0).quantity(2).build();
        itemsMilk =  Milk.builder().itemName("Milk").measurementUnit("liter").price(30.0).quantity(3).build();
        itemsNewspaper = Newspaper.builder().itemName("Newspaper").measurementUnit("number").price(10.0).quantity(1).build();

        cartServices = new CartServices();
        cartServices.addItemsToCart(itemsApples, itemsMilk, itemsNewspaper);

        wallet = eWallet.builder().walletBalance(300.0).build();
        customer = Customer.builder().name("testCustomer").cart(cartServices.getShoppingCart()).wallet(wallet).build();
    }

    @Test
    public void verifyIfBuy2LitreMilk1LitreGetsAddedToCart()
    {

        cartServices.add1LiterMilkOn2LiterMilk(customer);
        Assert.assertEquals(customer.getCart().getItems().stream()
                .filter(items -> items.getItemName().equalsIgnoreCase("Milk"))
                .collect(Collectors.toList()).stream().mapToInt(Items::getQuantity).sum(),4);
    }
    @Test
    public void verifyAfterBuy2LitreMilk1LitreGetsAddedToCartPriceDoNotChange()
    {
        Double cartPriceBefore = cartServices.calculateTotalCartPrice(customer);
        cartServices.add1LiterMilkOn2LiterMilk(customer);
        Double cartPriceAfter= cartServices.calculateTotalCartPrice(customer);
        Assert.assertEquals(cartPriceAfter,cartPriceBefore);
    }

    @Test
    public void shouldGet5percentOver100TotalPrice()
    {
        double amountToPay = cartServices.calculateTotalCartPrice(customer);
        new CustomerServices(customer).payWithWalletAmount(amountToPay);
        Assert.assertEquals(customer.getWallet().getAmountPaid(),133);
        Assert.assertEquals(customer.getWallet().getWalletBalance(),167);

    }

}
