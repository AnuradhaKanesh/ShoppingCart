package Service;

import Service.CartServices;
import Shopping.AvailableItem;
import Shopping.Items;
import Shopping.ShoppingCart;

import java.util.List;
import java.util.stream.Collectors;

public class Offers{

    public ShoppingCart add1LiterMilkOn2LiterMilk(CartServices cartServices) {
        List<Items> milkItems = cartServices.getShoppingCart().getItems().stream()
                .filter(items -> items.getItemName().name().equalsIgnoreCase("Milk")).collect(Collectors.toList());

        int milkToAdd = (milkItems.stream().mapToInt(Items::getQuantity).sum()) / 2;
        while (milkToAdd > 0) {
            cartServices.addItemsToCart(Items.builder().itemName(AvailableItem.Item.Milk).measurementUnit("litre").quantity(1).price(0.0).availableQuantity(1).build());
            milkToAdd--;
        }
        return cartServices.getShoppingCart();
    }
}
