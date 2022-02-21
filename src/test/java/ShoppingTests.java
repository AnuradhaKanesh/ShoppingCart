import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ShoppingTests {
    Items itemsApples, itemsMilk, itemsNewspaper;
    eWallet wallet;
    Customer customer;

    @BeforeMethod
    public void addItemsToCustomersCart() {

        itemsApples = new Apple.AppleBuilder().itemName("Apple").measurementUnit("Kg").price(20.0).quantity(3).build();
        itemsMilk = new Apple.AppleBuilder().itemName("Apple").measurementUnit("Kg").price(20.0).quantity(3).build();
        itemsNewspaper = new Apple.AppleBuilder().itemName("Apple").measurementUnit("Kg").price(20.0).quantity(3).build();

        CartServices cartServices = new CartServices();
        cartServices.addItemsToCart(itemsApples, itemsMilk, itemsNewspaper);

        wallet = eWallet.builder().walletBalance(300.0).build();

        customer = Customer.builder().name("testCustomer").cart(cartServices.getShoppingCart()).wallet(wallet).build();
    }

    @Test
    public void verifyIfBuy2LitreMilk1LitreGetsAddedToCart()
    {

    }


}
