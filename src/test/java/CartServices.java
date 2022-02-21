import java.util.Arrays;
import java.util.List;

public class CartServices {

    ShoppingCart shoppingCart;

    public CartServices() {
        shoppingCart = new ShoppingCart();
    }

    public List<Items> addItemsToCart(Items... items) {
        shoppingCart.getItems().addAll(Arrays.asList(items));
        return shoppingCart.getItems();
    }

    public Double calculateTotalCartPrice() {
        Double totPrice = shoppingCart.getItems().stream().mapToDouble(items -> items.getPrice()).sum();
        shoppingCart.setTotalCartValue(totPrice);
        return totPrice;
    }

    public ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }
}
