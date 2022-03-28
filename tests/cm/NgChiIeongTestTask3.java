package cm;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class NgChiIeongTestTask3 {

    /**
     * Testcase #44
     * test reducedPeriod is Null
     * ArrayList<Period> reducedPeriods = null;
     * Partition: reducedPeriod = null
     * return IllegalAccessException "periods cannot be null"
     */
    @Test
    public void reducedPeriodisNull() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> reducedPeriods = null;
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,18);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("periods cannot be null", e.getMessage());
        }
    }

    /**
     * Testcase #45
     * test normalPeriod is Null
     * ArrayList<Period> normalPeriods = null;
     * Partition: normalPeriod = null
     * return IllegalAccessException "periods cannot be null"
     */
    @Test
    public void normalPeriodisNull() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = null;
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,18);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("periods cannot be null", e.getMessage());
        }
    }

    /**
     * Testcase #46
     * test normalRate is Null
     * BigDecimal hourlyNormalRate = null;
     * Partition: normalRate = null
     * return IllegalAccessException "The rates cannot be null"
     */
    @Test
    public void normalRateIsNull() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = null;
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,18);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("The rates cannot be null", e.getMessage());
        }
    }

    /**
     * Testcase #47
     * test reducedRate is Null
     * BigDecimal hourlyReducedRate = null;
     * Partition: reducedRate = null
     * return IllegalAccessException "The rates cannot be null"
     */
    @Test
    public void reducedRateisNull() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = null;
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,18);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("The rates cannot be null", e.getMessage());
        }
    }

    /**
     * Testcase #48
     * test normalRate is negative
     * BigDecimal hourlyNormalRate = -1;
     * Partition: normalRate < 0
     * return IllegalAccessException "A rate cannot be negative"
     */
    @Test
    public void normalRateisNegative() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(-1);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,18);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("A rate cannot be negative", e.getMessage());
        }
    }

    /**
     * Testcase #49
     * test reducedRate is negative
     * BigDecimal hourlyReducedRate = -1;
     * Partition: reducedRate < 0
     * return IllegalAccessException "A rate cannot be negative"
     */
    @Test
    public void reducedRateisNegative() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(-1);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,18);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("A rate cannot be negative", e.getMessage());
        }
    }

    /**
     * Testcase #50
     * test normal rate is equal or less than reduced rate
     * BigDecimal hourlyNormalRate = new BigDecimal(2);
     * BigDecimal hourlyReducedRate = new BigDecimal(3);
     * Partition: normalRate.compareTo(reducedRate) <= 0
     * return IllegalAccessException "The normal rate cannot be less or equal to the reduced rate"
     */
    @Test
    public void reducedRateIsEqualOrLessThenNormalRate() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(2);
            BigDecimal hourlyReducedRate = new BigDecimal(3);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,18);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("The normal rate cannot be less or equal to the reduced rate", e.getMessage());
        }
    }

    /**
     * Testcase #51
     * test reducedPeriods is not valid
     * ArrayList<Period> reducedPeriods = [(5,9),(13,19),(18,22)]
     * Partition: !isValidPeriods(reducedPeriods)
     * return IllegalAccessException "The periods are not valid individually"
     */
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

    /**
     * Testcase #52
     * test normalPeriods is not valid
     * ArrayList<Period> normalPeriods = [(9,15),(14,18)]
     * Partition: !isValidPeriods(normalPeriods)
     * return IllegalAccessException "The periods are not valid individually"
     */
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

    /**
     * Testcase #53
     * test 2 collections overlaps
     * ArrayList<Period> normalPeriods = [(9,12)]
     * ArrayList<Period> reducedPeriods = [(11,14)]
     * Partition: !isValidPeriods(reducedPeriods, normalPeriods)
     * return IllegalAccessException "The periods overlaps"
     */
    @Test
    public void normalPeriodsAndReducedPeriodsOverlaps() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(11,14));
            Collections.addAll(normalPeriods,new Period(9,12));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(17,18);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("The periods overlaps", e.getMessage());
        }
    }

    /**
     * Testcase #54
     * test 100% branch coverage
     * Partition: all
     * return 5
     */
    @Test
    public void test100PercentageCoverage() throws IllegalArgumentException {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        Period periodStay = new Period(17,18);
        BigDecimal cost = rate.calculate(periodStay);
        assertEquals(new BigDecimal(5),cost);
    }

    /**
     * Testcase #55
     * test calculate 24 hours parking
     * Partition: all
     * return 58
     */
    @Test
    public void calculate24HoursParking() throws IllegalArgumentException {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        Period periodStay = new Period(0,24);
        BigDecimal cost = rate.calculate(periodStay);
        assertEquals(new BigDecimal(58),cost);
    }
    /**
     * Testcase #56
     * test periodStay is null
     * Partition: all
     * expect return IllegalArgumentException
     * actual return NullPointerException instead of IllegalArgumentException
     */
    @Test
    public void periodStayIsNull() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = null;
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (NullPointerException e) {
            assertNotNull(e.getMessage());
        }
    }

    /**
     * Testcase #57
     * test periodStay's startHour is equal or greater than endHour
     * Period periodStay = new Period(14,13);
     * Partition: startHour >= endHour
     * return IllegalArgumentException "start of period cannot be later or equal to end of period"
     */
    @Test
    public void periodStayStartHourIsEqualOrGreaterThanEndHour() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(14,13);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("start of period cannot be later or equal to end of period", e.getMessage());
        }
    }

    /**
     * Testcase #58
     * test periodStay's startHour is negative
     * Period periodStay = new Period(-1,13);
     * Partition: startHour < 0
     * return IllegalArgumentException "start of period and end of period must be between 0 and 24"
     */
    @Test
    public void periodStayStartHourIsNegative() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(-1,13);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("start of period and end of period must be between 0 and 24", e.getMessage());
        }
    }

    /**
     * Testcase #59
     * test periodStay's endHour is greater than 24
     * Period periodStay = new Period(23,25);
     * Partition: startHour > 24
     * return IllegalArgumentException "start of period and end of period must be between 0 and 24"
     */
    @Test
    public void periodStayEndHourIsGreaterThan24() throws IllegalArgumentException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
            Period periodStay = new Period(23,25);
            BigDecimal cost = rate.calculate(periodStay);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("start of period and end of period must be between 0 and 24", e.getMessage());
        }
    }

    /**
     * Testcase #60
     * test periodStay in free rate
     * ArrayList<Period> reducedPeriods = [(5,9),(13,14),(18,22)];
     * ArrayList<Period> normalPeriods = [(9,13),(14,18)];
     * Period periodStay = new Period(4,5);
     * Partition: all
     * return 0
     */
    @Test
    public void periodStayInFreeRate() throws IllegalArgumentException {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        Period periodStay = new Period(4,5);
        BigDecimal cost = rate.calculate(periodStay);
        assertEquals(new BigDecimal(0),cost);
    }

    /**
     * Testcase #61
     * test periodStay in normal rate
     * ArrayList<Period> reducedPeriods = [(5,9),(13,14),(18,22)];
     * ArrayList<Period> normalPeriods = [(9,13),(14,18)];
     * Period periodStay = new Period(9,10);
     * Partition: all
     * return 5
     */
    @Test
    public void periodStayInNormalRate() throws IllegalArgumentException {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        Period periodStay = new Period(9,10);
        BigDecimal cost = rate.calculate(periodStay);
        assertEquals(new BigDecimal(5),cost);
    }

    /**
     * Testcase #62
     * test periodStay in normal rate
     * ArrayList<Period> reducedPeriods = [(5,9),(13,14),(18,22)];
     * ArrayList<Period> normalPeriods = [(9,13),(14,18)];
     * Period periodStay = new Period(5,6);
     * Partition: all
     * return 2
     */
    @Test
    public void periodStayInReducedRate() throws IllegalArgumentException {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        Period periodStay = new Period(5,6);
        BigDecimal cost = rate.calculate(periodStay);
        assertEquals(new BigDecimal(2),cost);
    }

    /**
     * Testcase #63
     * test periodStay in long periods
     * ArrayList<Period> reducedPeriods = [(5,9),(13,14),(18,22)];
     * ArrayList<Period> normalPeriods = [(9,13),(14,18)];
     * Period periodStay = new Period(7,20);
     * Partition: all
     * reduced Periods 7-8, 8-9, 13-14, 18-19, 19-29 = (5 hours * €2 = €10)
     * normal Periods 9-10, 10-11, 11-12, 12-13, 14-15, 15-16, 16-17, 17-18 = (8 hours * €5 = €40)
     * return 50
     */
    @Test
    public void periodStayInLongPeriods() throws IllegalArgumentException {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        Period periodStay = new Period(7,20);
        BigDecimal cost = rate.calculate(periodStay);
        assertEquals(new BigDecimal(50),cost);
    }

    /**
     * Testcase #64
     * test periodStay in long periods
     * ArrayList<Period> reducedPeriods = [(5,9),(13,14),(18,22)];
     * ArrayList<Period> normalPeriods = [(9,13),(14,18)];
     * Period periodStay = new Period(17,21);
     * Partition: all
     * reduced Periods 18-19, 19,20, 20,21 = (3 hours * €2 = €6)
     * normal Periods 17-18 = (1 hours * €5 = €5)
     * return 11
     */
    @Test
    public void periodStayInShortPeriods() throws IllegalArgumentException {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        Period periodStay = new Period(17,21);
        BigDecimal cost = rate.calculate(periodStay);
        assertEquals(new BigDecimal(11),cost);
    }

    /**
     * Testcase #65
     * test 2 array of periods overlaps individually
     * ArrayList<Period> reducedPeriods = [(10,12),(11,12),(14,16)];
     * ArrayList<Period> normalPeriods = [(9,11),(8,13),(10,14)];
     * Partition: !isValidPeriods(reducedPeriods) || !isValidPeriods(normalPeriods)
     * return IllegalArgumentException "The periods are not valid individually"
     */
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

    /**
     * Testcase #66
     * test 24hours overlaps other
     * ArrayList<Period> reducedPeriods = [(0,24)];
     * ArrayList<Period> normalPeriods = [(0,1),(2,8),(9,10)];
     * Partition: !isValidPeriods(reducedPeriods, normalPeriods)
     * return IllegalArgumentException "The periods overlaps"
     */
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

    /**
     * add new test to fix bug
     * issue: normalRate has to be greater or equal to the reducedRate
     * expert: pass
     * actual throw exception
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
     * add new test to fix bug
     * issue: one of the element is null in period array
     * expert: throw illegalArgumentException
     * actual throw nullPointerException
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

}
