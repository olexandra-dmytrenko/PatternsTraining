package tdd;

/**
 * Created by olexandra on 11/6/17.
 */
public class TaxCalculator {
    double withNDS(double price) {
        return NDSResolver.getInstance().getNds() * 1.2;
    }
}

