/**
 * @Auther Chi Ieong Ng C00223421
 * @Date 11-03-2022
 */

package cm;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

class NgChiIeongTestTask {

    /**
     * Testcase #1
     * test negative number input
     * BigDecimal hourlyReducedRate = -1
     * Partition: hourlyReducedRate >= 0
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase1() throws IllegalAccessException {

        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(-1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        try {
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        }
        catch (Exception e) {
            assertEquals("A rate cannot be negative", e.getMessage());
        }
    }

    /**
     * Testcase #2
     * test negative number input
     * BigDecimal hourlyNormalRate = -20
     * Partition: hourlyNormalRate >= 0
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase2() throws IllegalAccessException {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(-20);
        BigDecimal hourlyReducedRate = new BigDecimal(3);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        try {
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        }
        catch (Exception e) {
            assertEquals("A rate cannot be negative", e.getMessage());
        }
    }

    /**
     * Testcase #3
     * test input 2 Rates are 0
     * BigDecimal hourlyNormalRate = 0
     * BigDecimal hourlyReducedRate = 0
     * Partition: hourlyNormalRate >= 0 and hourlyReduced >= 0
     * expert not null
     */
    @Test
    public void testcase3() throws IllegalAccessException {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal hourlyNormalRate = new BigDecimal(0);
        BigDecimal hourlyReducedRate = new BigDecimal(0);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        assertNotNull(rate);
    }

    /**
     * Testcase #4
     * test hourlyNormalRate greater than hourlyReducedRate
     * BigDecimal hourlyNormalRate = 5
     * BigDecimal hourlyReducedRate = 3
     * Partition: hourlyNormalRate >= 0 and hourlyReducedRate >= 0
     * expert not null
     */
    @Test
    public void testcase4() throws IllegalAccessException {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        assertNotNull(rate);
    }

    /**
     * Testcase #5
     * test hourlyNormalRate less than hourlyReducedRate
     * BigDecimal hourlyNormalRate = 1
     * * BigDecimal hourlyReducedRate = 2
     * Partition: hourlyNormalRate >= hourlyReducedRate
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase5() throws IllegalAccessException {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(1);
        BigDecimal hourlyReducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        try {
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        }
        catch (Exception e) {
            assertEquals("The normal rate cannot be less or equal to the reduced rate", e.getMessage());
        }
    }

    /**
     * Testcase #6
     * Test 2 Rates are positive and equal
     * BigDecimal hourlyReducedRate = 1
     * BigDecimal hourlyNormalRate = 1
     * Partition: hourlyNormalRate >= hourlyReducedRate
     * expert not null
     */
    @Test
    public void testcase6() throws IllegalAccessException {
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal hourlyReducedRate = new BigDecimal(1);
        BigDecimal hourlyNormalRate = new BigDecimal(1);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        assertNotNull(rate);
    }

    /**
     * Testcase #7
     * Test double type input
     * BigDecimal hourlyNormalRate = 3.1
     * Partition: hourlyNormalRate > hourlyReducedRate, and...
     * expert not null
     */
    @Test
    public void testcase7() throws IllegalAccessException {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(3.1);
        BigDecimal hourlyReducedRate = new BigDecimal(3);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        assertNotNull(rate);
    }

    /**
     * Testcase #8
     * test input 99 in Rate
     * BigDecimal hourlyNormalRate = 99
     * Partition: hourlyNormalRate >= 0
     * expert not null
     */
    @Test
    public void testcase8() throws IllegalAccessException {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal hourlyNormalRate = new BigDecimal(99);
        BigDecimal hourlyReducedRate = new BigDecimal(0);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(0,9),new Period(13,14),new Period(18,24));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        assertNotNull(rate);
    }

    /**
     * Testcase #9
     * test input extreme long floating-point number
     * BigDecimal hourlyNormalRate = 0.99999999999999999999999999999999999999999
     * Partition: hourlyNormalRate >= 0
     * expert not null
     */
    @Test
    public void testcase9() throws IllegalAccessException {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal hourlyNormalRate = new BigDecimal(0.99999999999999999999999999999999999999999);
        BigDecimal hourlyReducedRate = new BigDecimal(0);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(0,9),new Period(13,14),new Period(18,24));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        assertNotNull(rate);
    }

    /**
     * Testcase #10
     * test extreme long integer
     * BigDecimal hourlyNormalRate = 999999999999999999999999999999999999999999999999999999999999999999999999999999
     * Partition: Integer number too large (red line appeared)
     * test is not allowed (red line appeared)
     */
    /*
    @Test
    public void testcase10() throws IllegalAccessException {
        CarParkKind kind = new CarParkKind("VISITOR");
        BigDecimal hourlyNormalRate = new BigDecimal(999999999999999999999999999999999999999999999999999999999999999999999999999999);
        BigDecimal hourlyReducedRate = new BigDecimal(0);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(0,9),new Period(13,14),new Period(18,24));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind, hourlyReducedRate,hourlyNormalRate, reducedPeriods, normalPeriods);
        assertNotNull(rate);
    }*/

    /**
     * Testcase #11
     * test maximum limit value input
     * BigDecimal hourlyNormalRate = 999999999
     * Partition: hourlyNormalRate >= 0
     * expert not null
     */
    @Test
    public void testcase11() throws IllegalAccessException {
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal hourlyNormalRate = new BigDecimal(999999999);
        BigDecimal hourlyReducedRate = new BigDecimal(0);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(0,9),new Period(13,14),new Period(18,24));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        assertNotNull(rate);
    }

    /**
     * Testcase #12
     * test input multiply
     * BigDecimal hourlyNormalRate = 999999999*999999999
     * Partition: hourlyNormalRate >= 0
     * expert not null
     */
    @Test
    public void testcase12() throws IllegalAccessException {
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal hourlyNormalRate = new BigDecimal(999999999*999999999);
        BigDecimal hourlyReducedRate = new BigDecimal(0);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(0,9),new Period(13,14),new Period(18,24));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        assertNotNull(rate);
    }

    /**
     * Testcase #13
     * Test null input
     * BigDecimal hourlyReducedRate = null
     * Partition: hourlyReduced >= 0
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase13() throws IllegalAccessException {
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = null;
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(0,9),new Period(13,14),new Period(18,24));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        try {
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        }
        catch (Exception e) {
            assertEquals("The rates cannot be null", e.getMessage());
        }
    }



    /**
     * Testcase #14
     * test negative startHour in reducedPeriods
     * ArrayList<Period> reducedPeriods = [(-1,3)]
     * Partition: startHour >= 0 and startHour <=24
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase14() throws IllegalAccessException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(3);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(-1,3));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        }
        catch (Exception e) {
            assertEquals("start of period and end of period must be between 0 and 24", e.getMessage());
        }
    }

    /**
     * Testcase #15
     * test negative startHour in normalPeriods
     * ArrayList<Period> normalPeriods = [(-1,4)]
     * Partition: startHour >= 0 && startHour <= 24
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase15() throws IllegalAccessException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(3);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(-1,4));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        }
        catch (Exception e) {
            assertEquals("start of period and end of period must be between 0 and 24", e.getMessage());
        }
    }

    /**
     * Testcase #16
     * test input endHour > 24 in Period
     * ArrayList<Period> reducedPeriods = [(22,25)]
     * Partition: endHour >= 0 && endHour <= 24
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase16() throws IllegalAccessException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(3);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(22,25));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        }
        catch (Exception e) {
            assertEquals("start of period and end of period must be between 0 and 24", e.getMessage());
        }
    }

    /**
     * Testcase #17
     * test abnormal input in Period
     * ArrayList<Period> normalPeriods = [(22,'a')]
     * Partition: endHour >= 0 && endHour <= 24
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase17() throws IllegalAccessException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(3);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(22,'a'));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        }
        catch (Exception e) {
        assertEquals("start of period and end of period must be between 0 and 24", e.getMessage());
        }
    }

    /**
     * Testcase #18
     * test input null reducedPeriod
     * ArrayList<Period> reducedPeriods = [null,(13,14),(8,22)]
     * Partition: endHour >= 0 && endHour <= 24
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase18() throws IllegalAccessException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(3);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,null,new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        }
            catch (Exception e) {
            assertEquals("periods cannot be null", e.getMessage());
        }
    }
    /**
     * Testcase #19
     * Test input null in normalPeriods
     * ArrayList<Period> normalPeriods = null
     * Partition: endHour >= 0 && endHour <= 24
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase19() throws IllegalAccessException {
        try{
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(3);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = null;
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        }
                catch (Exception e) {
            assertEquals("periods cannot be null", e.getMessage());
        }
    }

    /**
     * Testcase #20
     * test reducedPeriods is null
     * ArrayList<Period> reducedPeriods = null
     * Partition: startHour >= 0 && startHour <= 24
     *            endHour >= 0 && endHour <= 24
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase20() throws IllegalAccessException {
        try {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);
        ArrayList<Period> reducedPeriods = null;
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        }
        catch (Exception e) {
            assertEquals("periods cannot be null", e.getMessage());
        }
    }

    /**
     * Testcase #21
     * Test startHour equal to endHour
     * ArrayList<Period> reducedPeriods = [(5,5),(13,14),(18,22)]
     * Partition: startHour < endHour
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase21() throws IllegalAccessException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(3);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,5),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        }
        catch (Exception e) {
            assertEquals("start of period cannot be later or equal to end of period", e.getMessage());
        }
    }

    /**
     * Testcase #22
     * test startHour is greater than endHour
     * ArrayList<Period> normalPeriods = [(9,13),(18,14)]
     * Partition: startHour < endHour
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase22() throws IllegalAccessException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(3);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(18,14));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        }
        catch (Exception e) {
            assertEquals("start of period cannot be later or equal to end of period", e.getMessage());
        }
    }

    /**
     * Testcase #23
     * test reducedPeriods overlaps
     * ArrayList<Period> reducedPeriods = [(5,9),(8,14),(18,22)]
     * Partition: reducedPeriods[i].overlaps(reducedPeriods[i+1])
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase23() throws IllegalAccessException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(3);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(8,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        } catch (Exception e) {
            assertEquals("The periods are not valid individually", e.getMessage());
        }
    }

    /**
     * Testcase #24
     * test normalPeriods overlaps
     * ArrayList<Period> normalPeriods = [(9,15),(14,18)]
     * Partition: normalPeriods[i].overlaps(normalPeriods[i+1])
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase24() throws IllegalAccessException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(3);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,15),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        } catch (Exception e) {
            assertEquals("The periods are not valid individually", e.getMessage());
        }
    }

    /**
     * Testcase #25
     * test 2 collections of periods overlaps
     * ArrayList<Period> reducedPeriods = [(5,9),(13,14),(18,22)]
     * ArrayList<Period> normalPeriods = [(8,13),(14,18)]
     * Partition: normalPeriods[i].overlaps(reducedPeriods[j])
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase25() throws IllegalAccessException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(3);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(8,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        } catch (Exception e) {
            assertEquals("The periods overlaps", e.getMessage());
        }
    }

    /**
     * Testcase #26
     * test 2 collections overlaps in other way
     * ArrayList<Period> reducedPeriods = [(5,9),(13,14),(17,22)]
     * ArrayList<Period> normalPeriods = [(8,13),(14,18)]
     * Partition: normalPeriods[i].overlaps(reducedPeriods[j])
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase26() throws IllegalAccessException {
        try {
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(3);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(17,22));
            Collections.addAll(normalPeriods,new Period(8,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        } catch (Exception e) {
            assertEquals("The periods overlaps", e.getMessage());
        }
    }

    /**
     * Testcase #27
     * test kind as null
     * CarParkKind kind = null
     * Partition: Kind's enum = STAFF or STUDENT or MANAGEMENT or VISITOR
     * my expert: Error
     * actual test in dummy class: passed
     */
    @Test
    public void testcase27() throws IllegalAccessException {
        CarParkKind kind = null;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        assertNotNull(rate);
    }

    /**
     * Testcase #28
     * test input lowercase
     * CarParkKind kind = "staff"
     * Partition: Kind's enum = STAFF or STUDENT or MANAGEMENT or VISITOR
     * my expect: Error
     * Actual: test is not allowed(red line appeared)
     */
    /*
    @Test
    public void testcase28() throws IllegalAccessException {
        CarParkKind kind = CarParkKind.staff;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        assertNotNull(rate);
    }*/

    /**
     * Testcase #29
     * test abnormal kind
     * CarParkKind kind = "STUDENT" + 1
     * Partition: Kind's enum = STAFF or STUDENT or MANAGEMENT or VISITOR
     * my expect: Error
     * Actual: Test is not allowed
     */
    /*
    @Test
    public void testcase29() throws IllegalAccessException {
        CarParkKind kind = CarParkKind.STUDENT + 1;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(3);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);
        assertNotNull(rate);
    }*/

    /**
     * Testcase #30
     * test all parameters as null
     * CarParkKind kind = null
     * BigDecimal hourlyNormalRate = null
     * BigDecimal hourlyReducedRate = null
     * ArrayList<Period> reducedPeriods = null;
     * ArrayList<Period> normalPeriods = null;
     * Partition: hourlyNormalRate >= 0 and hourlyReducedRate >= 0,
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase30() throws IllegalAccessException {
        try {
            Rate rate = new Rate(null,null,null,null,null);
        } catch (Exception e) {
            assertEquals("periods cannot be null", e.getMessage());
        }
    }

    /**
     * Testcase #31
     * test startHour as 0 in periodStay
     * Period periodStay = new Period(0,5);
     * Partition: startHour >= 0 && startHour <= 24
     * expert: return 0
     */
    @Test
    public void testcase31() throws IllegalAccessException {
        //precondition
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);

        //test calculate()
        Period periodStay = new Period(0,5);
        assertEquals(new BigDecimal(0),rate.calculate(periodStay));
    }

    /**
     * Testcase #32
     * test negative startHour in periodStay
     * Period periodStay = new Period(-1,5);
     * Partition: startHour >= 0 && startHour <= 24,
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase32() throws IllegalAccessException {
        try {
            //precondition
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods, new Period(5, 9), new Period(13, 14), new Period(18, 22));
            Collections.addAll(normalPeriods, new Period(9, 13), new Period(14, 18));
            Rate rate = new Rate(kind, hourlyNormalRate, hourlyReducedRate, reducedPeriods, normalPeriods);

            //test calculate()
            Period periodStay = new Period(-1, 5);
            BigDecimal cost = rate.calculate(periodStay);
        } catch (Exception e) {
            assertEquals("start of period and end of period must be between 0 and 24", e.getMessage());
        }

    }
    /**
     * Testcase #33
     * test endHour is greater than 24 in periodStay
     * Period periodStay = new Period(0,25);
     * Partition: startHour >= 0 && startHour <= 24,
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase33() throws IllegalAccessException {
        try {
            //precondition
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);

            //test calculate()
            Period periodStay = new Period(0,25);
            BigDecimal cost = rate.calculate(periodStay);
        } catch (Exception e) {
            assertEquals("start of period and end of period must be between 0 and 24", e.getMessage());
        }
    }
    /**
     * Testcase #34
     * test startHour is greater than endHour in periodStay
     * Period periodStay = new Period(23,6);
     * Partition: startHour < endHour
     * expect to throw IllegalAccessException
     */
    @Test
    public void testcase34() throws IllegalAccessException {
        try {
            //precondition
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);

            //test calculate()
            Period periodStay = new Period(23,6);
            BigDecimal cost = rate.calculate(periodStay);
        } catch (Exception e) {
            assertEquals("start of period cannot be later or equal to end of period", e.getMessage());
        }
    }
    /**
     * Testcase #35
     * test startHour is equal to endHour in periodStay
     * Period periodStay = new Period(1,1);
     * Partition: startHour < endHour
     * export to throw IllegalAccessException
     */
    @Test
    public void testcase35() throws IllegalAccessException {
        try {
            //precondition
            CarParkKind kind = CarParkKind.STUDENT;
            BigDecimal hourlyNormalRate = new BigDecimal(5);
            BigDecimal hourlyReducedRate = new BigDecimal(2);
            ArrayList<Period> reducedPeriods = new ArrayList<Period>();
            ArrayList<Period> normalPeriods = new ArrayList<Period>();
            Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
            Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
            Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);

            //test calculate()
            Period periodStay = new Period(1,1);
            BigDecimal cost = rate.calculate(periodStay);
        } catch (Exception e) {
            assertEquals("start of period cannot be later or equal to end of period", e.getMessage());
        }
    }

    /**
     * Testcase #36
     * Period periodStay = new Period(0,24);
     * Partition: startHour >= 0 && startHour <= 24, and
     *            endHour >= 0 && endHour <= 24, then
     *            startHour < endHour
     * expect: return 58
     */
    @Test
    public void testcase36() throws IllegalAccessException {
        //precondition
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);

        //test calculate()
        Period periodStay = new Period(0,24);
        assertEquals(new BigDecimal(58),rate.calculate(periodStay));
    }

    /**
     * Testcase #37
     * test in a random time in periodStay
     * Period periodStay = new Period(6,15);
     * Partition: startHour >= 0 && startHour <= 24, and
     *            endHour >= 0 && endHour <= 24, then
     *            startHour < endHour
     * expect: return 33
     */
    @Test
    public void testcase37() throws IllegalAccessException {
        //precondition
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);

        //test calculate()
        Period periodStay = new Period(6,15);
        assertEquals(new BigDecimal(33),rate.calculate(periodStay));
    }

    /**
     * Testcase #38
     * test in a reducedRate Hour
     * Period periodStay = new Period(13,14);
     * Partition: startHour >= 0 && startHour <= 24, and
     *            endHour >= 0 && endHour <= 24, then
     *            startHour < endHour
     * expect: return 2
     */
    @Test
    public void testcase38() throws IllegalAccessException {
        //precondition
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);

        //test calculate()
        Period periodStay = new Period(13,14);
        assertEquals(new BigDecimal(2),rate.calculate(periodStay));
    }

    /**
     * Testcase #39
     * test in a normalRate Hour
     * Period periodStay = new Period(17,18);
     * Partition: startHour >= 0 && startHour <= 24, and
     *            endHour >= 0 && endHour <= 24, then
     *            startHour < endHour
     * expect: return 5
     */
    @Test
    public void testcase39() throws IllegalAccessException {
        //precondition
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);

        //test calculate()
        Period periodStay = new Period(17,18);
        assertEquals(new BigDecimal(5),rate.calculate(periodStay));
    }

    /**
     * Testcase #40
     * test in a free hour
     * Period periodStay = new Period(0,1);
     * Partition: startHour >= 0 && startHour <= 24, and
     *            endHour >= 0 && endHour <= 24, then
     *            startHour < endHour
     * expect: return 0
     */
    @Test
    public void testcase40() throws IllegalAccessException {
        //precondition
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(5);
        BigDecimal hourlyReducedRate = new BigDecimal(2);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(5,9),new Period(13,14),new Period(18,22));
        Collections.addAll(normalPeriods,new Period(9,13),new Period(14,18));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);

        //test calculate()
        Period periodStay = new Period(0,1);
        assertEquals(new BigDecimal(0),rate.calculate(periodStay));
    }

    /**
     * Testcase #41
     * test in a maximum value rate
     * BigDecimal hourlyNormalRate = 999999999
     * Period periodStay = new Period(0,24);
     * Partition: startHour >= 0 && startHour <= 24, and
     *            endHour >= 0 && endHour <= 24, then
     *            startHour < endHour
     * expect: return 0
     */
    @Test
    public void testcase41() throws IllegalAccessException {
        //precondition
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(999999999);
        BigDecimal hourlyReducedRate = new BigDecimal(0);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(0,1));
        Collections.addAll(normalPeriods,new Period(23,24));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);

        //test calculate()
        Period periodStay = new Period(0,24);
        assertEquals(new BigDecimal(999999999),rate.calculate(periodStay));
    }

    /**
     * Testcase #42
     * test in a multiply value input
     * BigDecimal hourlyNormalRate = 999999999*999999999
     * Period periodStay = new Period(0,24);
     * Partition: startHour >= 0 && startHour <= 24, and
     *            endHour >= 0 && endHour <= 24, then
     *            startHour < endHour
     * expect: return 9.99999998e+17
     * actual: return 808348673
     */
    @Test
    public void testcase42() throws IllegalAccessException {
        //precondition
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(999999999*999999999);
        BigDecimal hourlyReducedRate = new BigDecimal(0);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(0,1));
        Collections.addAll(normalPeriods,new Period(23,24));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);

        //test calculate()
        Period periodStay = new Period(0,24);
        assertEquals(new BigDecimal(999999999*999999999),rate.calculate(periodStay));
    }

    /**
     * Testcase #43
     * test in more extreme multiply value
     * BigDecimal hourlyNormalRate = 999999999*999999999*999999999
     * Period periodStay = new Period(0,24);
     * Partition: startHour >= 0 && startHour <= 24, and
     *            endHour >= 0 && endHour <= 24, then
     *            startHour < endHour
     * expect: return incalculable numbers
     * actual: Error
     */
    @Test
    public void testcase43() throws IllegalAccessException {
        //precondition
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal hourlyNormalRate = new BigDecimal(999999999*999999999*999999999);
        BigDecimal hourlyReducedRate = new BigDecimal(0);
        ArrayList<Period> reducedPeriods = new ArrayList<Period>();
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        Collections.addAll(reducedPeriods,new Period(0,1));
        Collections.addAll(normalPeriods,new Period(23,24));
        Rate rate = new Rate(kind,hourlyNormalRate,hourlyReducedRate,reducedPeriods,normalPeriods);

        //test calculate()
        Period periodStay = new Period(0,24);
        assertEquals(new BigDecimal(999999999*999999999*999999999),rate.calculate(periodStay));
    }

    @Test
    void calculate() {
    }
}