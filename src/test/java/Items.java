import java.security.SecureRandom;

public interface Items {

    Double getPrice(Double price);
    int getQuantity(int quantity);
    String getMeasurementUnit(String measurementUnit);
    String getItemName(String itemName);
    //Double getTotalPriceOfItemPurchased(int quantity);
}
