package old;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Jacob on 2015-6-7.
 */
public class TaxiFeeCalculatorTest {


    @Test
    public void morningIn3() {
        assertEquals((float) 14, getPrice(5, 3), 0.1f);

        assertEquals((float) 14, getPrice(22, 3), 0.1f);
    }

    @Test
    public void morningOver3In10() {
        assertEquals((float) (14 + 1 * 2.4), getPrice(5, 4), 0.1f);
        assertEquals((float) (14 + 7 * 2.4), getPrice(22, 10), 0.1f);
    }

    @Test
    public void morningOver10() {
        assertEquals((float) 14 + 7 * 2.4 + 1 * 3.6, getPrice(5, 11), 0.1f);
        assertEquals((float) 14 + 7 * 2.4 + 90 * 3.6, getPrice(22, 100), 0.1f);
    }

    @Test
    public void EveningIn3() {
        assertEquals((float) 18, getPrice(4, 3), 0.1f);
        assertEquals((float) 18, getPrice(23, 1), 0.1f);
    }

    @Test
    public void EveninggOver3In10() {
        assertEquals((float) 18 + 1 * 3.1, getPrice(4, 4), 0.1f);
        assertEquals((float) 18 + 7 * 3.1, getPrice(23, 10), 0.1f);

    }

    @Test
    public void EveninggOver10() {
        assertEquals((float) 18 + 7 * 3.1 + 1 * 4.7, getPrice(4, 11), 0.1f);
        assertEquals((float) 18 + 7 * 3.1 + 90 * 4.7, getPrice(23, 100), 0.1f);
    }

    private float getPrice(int hour, int miles) {
        return new TaxiFeeCalculator(hour, miles).getPrice();
    }

    // todo: this is a bug.
//    @Test
    public void wrongParameterTest() {
        assertEquals(-1f, getPrice(10, -1), 0.0f);
        assertEquals(-1f, getPrice(-1, 10), 0.0f);
        assertEquals(-1f, getPrice(-1, -1), 0.0f);
    }
}
