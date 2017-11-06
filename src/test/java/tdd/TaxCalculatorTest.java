package tdd;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by olexandra on 11/6/17.
 */
public class TaxCalculatorTest {
    @Test
    public void withNDS() throws Exception {
        TaxCalculator calculator = new TaxCalculator();
        double withNds = calculator.withNDS(20);
        Assert.assertEquals(24, withNds, 0.00001);
    }

}