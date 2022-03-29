package cm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class NgChiIeongTestTask3 {


    /**
     * test to fix error 1
     * issue: normalRate has to be greater or equal to the reducedRate
     * expert: pass
     * actual throw exception
     * fixed
     */

    @Test
    public void fixedNormalRateAndReducedRateAreEqual() throws IllegalArgumentException {

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

    /**
     * test to fix error 2
     * issue: one of the element is null in period array
     * expert: throw illegalArgumentException
     * actual throw nullPointerException
     * fixed
     */

    @Test
    public void fixedPeriodArrayWithNull() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(1);
            BigDecimal hourlyReducedRate = new BigDecimal(1);
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            Collections.addAll(normalPeriods, new Period(9, 13), new Period(14, 18));
            Collections.addAll(reducedPeriods, null, new Period(13, 14), new Period(18, 22));
            Rate rate = new Rate(kind, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);
            Period periodStay = new Period(9, 10);
            BigDecimal cost = rate.calculate(periodStay);
            fail();

        } catch (IllegalArgumentException e) {
            assertEquals("periods cannot be null", e.getMessage());
        }
    }

    /**
     * test to fix error 3
     * issue: CarParkKind can not be null
     * expert: throw illegalArgumentException
     * actual passed
     * fixed
     */

    @Test
    public void carParkKindCannotBeNULL() throws IllegalArgumentException {
        try {
            CarParkKind kind = null;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            Collections.addAll(normalPeriods, new Period(9, 13), new Period(14, 18));
            Collections.addAll(reducedPeriods,new Period(7,9),new Period(13,14),new Period(18,22));
            Rate rate = new Rate(kind, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);
            Period periodStay = new Period(9, 10);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("kind cannot be null", e.getMessage());
        }
    }

    /**
     * Specification Update
     * Incremental Change:
     * the Rate calculate method should take into account the kind of rate using the following reduction rates:
     * VISITOR: first 10.00 is free, 50% reduction above that
     * e.g total calculated cost was 15.00, after reduction only 2.50 needs to be paid (i.e. 50% of (15.00-10.00))
     * MANAGEMENT: minimum payable is 4.00
     * STUDENT: 25% reduction on any amount above 5.50
     * STAFF: maximum payable is 16.00 per day
     */

    @Test
    public void specificationUpdateVisitor() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        Collections.addAll(normalPeriods,new Period(9,13), new Period(14,18));
        Collections.addAll(reducedPeriods,new Period(7,9),new Period(13,14),new Period(18,22));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        Period periodStay = new Period(5,15);
        BigDecimal cost = rate.calculate(periodStay);
        assertEquals(new BigDecimal(12),cost);
    }

    @Test
    public void specificationUpdateManagement() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        Collections.addAll(normalPeriods,new Period(9,13), new Period(14,18));
        Collections.addAll(reducedPeriods,new Period(7,9),new Period(13,14),new Period(18,22));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        Period periodStay = new Period(7,8);
        BigDecimal cost = rate.calculate(periodStay);
        assertEquals(new BigDecimal(4),cost);
    }

    @Test
    public void specificationUpdateStudent() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        Collections.addAll(normalPeriods,new Period(9,13), new Period(14,18));
        Collections.addAll(reducedPeriods,new Period(7,9),new Period(13,14),new Period(18,22));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        Period periodStay = new Period(8,12);
        BigDecimal cost = rate.calculate(periodStay);
        assertEquals(new BigDecimal(14.88,new MathContext(4)),cost);
    }

    @Test
    public void specificationUpdateStaff() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        Collections.addAll(normalPeriods,new Period(9,13), new Period(14,18));
        Collections.addAll(reducedPeriods,new Period(7,9),new Period(13,14),new Period(18,22));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        Period periodStay = new Period(0,24);
        BigDecimal cost = rate.calculate(periodStay);
        assertEquals(new BigDecimal(16),cost);
    }

    /**
     * reuse test case from task 2 to achieve 100% branch coverage
     */

    @Test
    public void achieve100percentBranchCoverage1() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            ArrayList<Period> reducedPeriods = null;
            Collections.addAll(normalPeriods,new Period(10,12),new Period(11,12), new Period(14,16));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,21);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("periods cannot be null", e.getMessage());
        }
    }

    @Test
    public void achieve100percentBranchCoverage2() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> normalPeriods = null;
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(9,11),new Period(8,13),new Period(10,14));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,21);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("periods cannot be null", e.getMessage());
        }
    }

    @Test
    public void achieve100percentBranchCoverage3() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            Collections.addAll(normalPeriods,new Period(10,12),new Period(11,12), new Period(14,16));
            Collections.addAll(reducedPeriods,null,new Period(8,13),new Period(10,14));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,21);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("periods cannot be null", e.getMessage());
        }
    }

    @Test
    public void achieve100percentBranchCoverage4() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            Collections.addAll(normalPeriods,null,new Period(11,12), new Period(14,16));
            Collections.addAll(reducedPeriods,new Period(9,11),new Period(8,13),new Period(10,14));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,21);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("periods cannot be null", e.getMessage());
        }
    }

    @Test
    public void achieve100percentBranchCoverage5() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = null;
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            Collections.addAll(normalPeriods,new Period(10,12),new Period(11,12), new Period(14,16));
            Collections.addAll(reducedPeriods,new Period(9,11),new Period(8,13),new Period(10,14));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,21);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("The rates cannot be null", e.getMessage());
        }
    }

    @Test
    public void achieve100percentBranchCoverage6() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = null;
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            Collections.addAll(normalPeriods,new Period(10,12),new Period(11,12), new Period(14,16));
            Collections.addAll(reducedPeriods,new Period(9,11),new Period(8,13),new Period(10,14));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,21);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("The rates cannot be null", e.getMessage());
        }
    }

    @Test
    public void achieve100percentBranchCoverage7() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(-1);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            Collections.addAll(normalPeriods,new Period(10,12),new Period(11,12), new Period(14,16));
            Collections.addAll(reducedPeriods,new Period(9,11),new Period(8,13),new Period(10,14));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,21);
            BigDecimal cost = rate.calculate(periodStay);
            assertEquals(new BigDecimal(11),cost);
        } catch (IllegalArgumentException e) {
            assertEquals("A rate cannot be negative", e.getMessage());
        }
    }

    @Test
    public void achieve100percentBranchCoverage8() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(-1);
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            Collections.addAll(normalPeriods,new Period(10,12),new Period(11,12), new Period(14,16));
            Collections.addAll(reducedPeriods,new Period(9,11),new Period(8,13),new Period(10,14));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,21);
            BigDecimal cost = rate.calculate(periodStay);
            assertEquals(new BigDecimal(11),cost);
        } catch (IllegalArgumentException e) {
            assertEquals("A rate cannot be negative", e.getMessage());
        }
    }

    @Test
    public void achieve100percentBranchCoverage9() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(6);
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            Collections.addAll(normalPeriods,new Period(10,12),new Period(11,12), new Period(14,16));
            Collections.addAll(reducedPeriods,new Period(9,11),new Period(8,13),new Period(10,14));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,21);
            BigDecimal cost = rate.calculate(periodStay);
            assertEquals(new BigDecimal(11),cost);
        } catch (IllegalArgumentException e) {
            assertEquals("The normal rate cannot be less to the reduced rate", e.getMessage());
        }
    }

    @Test
    public void oachieve100percentBranchCoverage10() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            Collections.addAll(normalPeriods,new Period(10,12),new Period(11,12), new Period(14,16));
            Collections.addAll(reducedPeriods,new Period(9,11),new Period(8,13),new Period(10,14));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,21);
            BigDecimal cost = rate.calculate(periodStay);
            assertEquals(new BigDecimal(11),cost);
        } catch (IllegalArgumentException e) {
            assertEquals("The periods are not valid individually", e.getMessage());
        }
    }

    @Test
    public void oachieve100percentBranchCoverage11() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            Collections.addAll(normalPeriods,new Period(10,12),new Period(11,12), new Period(14,16));
            Collections.addAll(reducedPeriods,new Period(9,11),new Period(8,13),new Period(10,14));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,21);
            BigDecimal cost = rate.calculate(periodStay);
            assertEquals(new BigDecimal(11),cost);
        } catch (IllegalArgumentException e) {
            assertEquals("The periods are not valid individually", e.getMessage());
        }
    }

    @Test
    public void overlapsInSomePeriods() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            Collections.addAll(normalPeriods,new Period(10,12),new Period(11,12), new Period(14,16));
            Collections.addAll(reducedPeriods,new Period(9,11),new Period(8,13),new Period(10,14));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,21);
            BigDecimal cost = rate.calculate(periodStay);
            assertEquals(new BigDecimal(11),cost);
        } catch (IllegalArgumentException e) {
            assertEquals("The periods are not valid individually", e.getMessage());
        }
    }

    @Test
    public void overlaps24hours() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            Collections.addAll(normalPeriods,new Period(0,24));
            Collections.addAll(reducedPeriods,new Period(0,1),new Period(2,8),new Period(9,10));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            //Period periodStay = new Period(17,21);
            //BigDecimal cost = rate.calculate(periodStay);
            //assertEquals(new BigDecimal(11),cost);
        } catch (IllegalArgumentException e) {
            assertEquals("The periods overlaps", e.getMessage());
        }
    }

    @Test
    public void reducedPeriodsIsNotValid() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,19),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,13));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,18);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("The periods are not valid individually", e.getMessage());
        }
    }

    @Test
    public void normalPeriodsIsNotValid() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,15),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,18);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("The periods are not valid individually", e.getMessage());
        }
    }


    @Test
    public void specificationUpdateManagement2() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        Collections.addAll(normalPeriods,new Period(9,13), new Period(14,18));
        Collections.addAll(reducedPeriods,new Period(7,9),new Period(13,14),new Period(18,22));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        Period periodStay = new Period(7,9);
        BigDecimal cost = rate.calculate(periodStay);
        assertEquals(new BigDecimal(6),cost);
    }

    @Test
    public void specificationUpdateStaff2() throws IllegalArgumentException {

        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        Collections.addAll(normalPeriods,new Period(9,13), new Period(14,18));
        Collections.addAll(reducedPeriods,new Period(7,9),new Period(13,14),new Period(18,22));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        Period periodStay = new Period(9,10);
        BigDecimal cost = rate.calculate(periodStay);
        assertEquals(new BigDecimal(5),cost);
    }



}
