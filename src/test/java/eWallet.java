import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
@Builder
public class eWallet {
    @Setter
    private double walletBalance, amountPaid;

    public double discountOver100Rs(double amountToPay) {
        if (amountToPay >= 100.0) {
            double discount = amountToPay * .05;
            amountToPay -= discount;
        }
        return amountToPay;
    }


}
