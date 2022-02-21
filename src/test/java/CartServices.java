import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CartServices {

    ShoppingCart shoppingCart;

    public CartServices() {
        shoppingCart = new ShoppingCart();
    }

    public List<Items> addItemsToCart(Items... items) {
        shoppingCart.getItems().addAll(Arrays.asList(items));
        return shoppingCart.getItems();
    }

    public Double calculateTotalCartPrice(Customer customer) {
        Double totPrice = customer.getCart().getItems().stream().mapToDouble(items -> items.getPrice() * items.getQuantity()).sum();
        shoppingCart.setTotalCartValue(totPrice);
        return totPrice;
    }

    public ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }
    public ShoppingCart add1LiterMilkOn2LiterMilk(Customer customer) {
        List<Items> milkItems = customer.getCart().getItems().stream()
                .filter(items -> items.getItemName() == "Milk").collect(Collectors.toList());

        int milkToAdd = (milkItems.stream().mapToInt(Items::getQuantity).sum()) / 2;
        while (milkToAdd > 0) {
            addItemsToCart(Milk.builder().itemName("Milk").measurementUnit("litre").quantity(1).price(0.0).build());
            milkToAdd--;
        }
        return shoppingCart;
    }
}
