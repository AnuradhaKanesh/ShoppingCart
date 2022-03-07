import Service.CartServices;
import Service.CustomerServices;
import Service.Offers;
import Shopping.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class ShoppingTests {
    Items itemsApples, itemsMilk, itemsNewspaper;
    eWallet wallet;
    Customer customer;
    CartServices cartServices;

    @Test(dataProvider = "ItemsDetails")
    public void TC01_AddItemsToCustomersCart(String appleQuantity, String milkQuantity, String newspaperQuantity) {

        itemsApples = Items.builder().itemName(AvailableItem.Item.Apple).measurementUnit("Kg").price(20.0).quantity(2).availableQuantity(Integer.parseInt(appleQuantity)).build();
        itemsMilk = Items.builder().itemName(AvailableItem.Item.Milk).measurementUnit("liter").price(30.0).quantity(3).availableQuantity(Integer.parseInt(milkQuantity)).build();
        itemsNewspaper = Items.builder().itemName(AvailableItem.Item.Newspaper).measurementUnit("number").price(10.0).quantity(1).availableQuantity(Integer.parseInt(newspaperQuantity)).build();

        cartServices = new CartServices();

        Assert.assertTrue(itemsApples.getAvailableQuantity()>itemsApples.getQuantity(),"Adding more quantity than available Apples");
        Assert.assertTrue(itemsMilk.getAvailableQuantity()>itemsMilk.getQuantity(),"Adding more quantity than available Milk");
        Assert.assertTrue(itemsNewspaper.getAvailableQuantity()>itemsNewspaper.getQuantity(),"Adding more quantity than available Newspaper");


        cartServices.addItemsToCart(itemsApples, itemsMilk, itemsNewspaper);

        wallet = eWallet.builder().walletBalance(300.0).build();
        customer = Customer.builder().name("testCustomer").cart(cartServices.getShoppingCart()).wallet(wallet).build();
    }

    @Test
    public void TC02_VerifyIfBuy2LitreMilk1LitreGetsAddedToCart() {

        new Offers().add1LiterMilkOn2LiterMilk(cartServices);
        Assert.assertEquals(customer.getCart().getItems().stream()
                .filter(items -> items.getItemName().name().equalsIgnoreCase("Milk"))
                .collect(Collectors.toList()).stream().mapToInt(Items::getQuantity).sum(), 4);
    }

    @Test
    public void TC03_VerifyAfterBuy2LitreMilk1LitreGetsAddedToCartPriceDoNotChange() {
        Double cartPriceBefore = cartServices.calculateTotalCartPrice(customer);
        new Offers().add1LiterMilkOn2LiterMilk(cartServices);
        Double cartPriceAfter = cartServices.calculateTotalCartPrice(customer);
        Assert.assertEquals(cartPriceAfter, cartPriceBefore);
    }

    @Test(dataProvider = "discountDetails")
    public void TC04_ShouldGet5percentOver100TotalPrice(String discount, String priceOver) {

        double amountToPay = cartServices.calculateTotalCartPrice(customer);
        Assert.assertTrue(customer.getWallet().getWalletBalance() > amountToPay, "Not enough balance");

        amountToPay = customer.getWallet().getDiscount(amountToPay,discount,priceOver);

        new CustomerServices(customer).payWithWalletAmount(amountToPay);

        Assert.assertEquals(customer.getWallet().getAmountPaid(), 133);
        Assert.assertEquals(customer.getWallet().getWalletBalance(), 167);

    }

    @DataProvider(name = "discountDetails")
    public static Object[][] readDiscountCsv() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/discount.csv"));
        List<String[]> csvData = csvReader.readAll();
        Object[][] csvDataObject = new Object[csvData.size()-1][2];
        for (int i = 1; i < csvData.size(); i++) {
            csvDataObject[i-1] = csvData.get(i);
        }
        return csvDataObject;
    }
    @DataProvider(name = "ItemsDetails")
    public static Object[][] readItemsCsv() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(System.getProperty("user.dir") + "/src/test/resources/quantityAvailableForItems.csv"));
        List<String[]> csvData = csvReader.readAll();
        Object[][] csvDataObject = new Object[csvData.size()-1][2];
        for (int i = 1; i < csvData.size(); i++) {
            csvDataObject[i-1] = csvData.get(i);
        }
        return csvDataObject;
    }

}
