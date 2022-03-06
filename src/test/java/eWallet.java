import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class eWallet {
    @Setter
    private double walletBalance, amountPaid;

    public double getDiscount(double amountToPay,String discount,String price) {
        if (amountToPay >= Double.valueOf(price)) {
            double dis = amountToPay * (Double.valueOf(discount)/100.0);
            amountToPay -= dis;
        }
        return amountToPay;
    }


}
