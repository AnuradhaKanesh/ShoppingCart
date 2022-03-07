package Service;

import Shopping.Customer;
import Shopping.Items;
import Shopping.ShoppingCart;

import java.util.Arrays;
import java.util.List;

public class CartServices {

    private ShoppingCart shoppingCart;

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

}
