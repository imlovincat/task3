package cm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NgChiIeongTestTask3 {

    /**
     * add new test to fix bug
     * issue: normalRate has to be greater or equal to the reducedRate
     * expert: pass
     * actual throw exception
     */

    @Test
    public void normalRateAndReducedRateAreEqual() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(1);
        BigDecimal hourlyReducedRate = new BigDecimal(1);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        Collections.addAll(normalPeriods,new Period(9,13), new Period(14,18));
        Collections.addAll(reducedPeriods,new Period(7,9),new Period(13,14),new Period(18,22));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        Period periodStay = new Period(9,10);
        BigDecimal cost = rate.calculate(periodStay);
        assertEquals(new BigDecimal(1),cost);
    }

}
