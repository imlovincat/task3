package cm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.math.*;

public class Rate {
    private CarParkKind kind;
    private BigDecimal hourlyNormalRate;
    private BigDecimal hourlyReducedRate;
    private ArrayList<Period> reduced = new ArrayList<>();
    private ArrayList<Period> normal = new ArrayList<>();

    public Rate(CarParkKind kind, BigDecimal normalRate, BigDecimal reducedRate, ArrayList<Period> reducedPeriods
            , ArrayList<Period> normalPeriods) {
        //fixed error 3
        if (kind == null) {
            throw new IllegalArgumentException("kind cannot be null");
        }
        //fixed error 2
        if (reducedPeriods == null || normalPeriods == null || !(checkPeriodsArray(reducedPeriods)) || !(checkPeriodsArray(normalPeriods))) {
            throw new IllegalArgumentException("periods cannot be null");
        }
        if (normalRate == null || reducedRate == null) {
            throw new IllegalArgumentException("The rates cannot be null");
        }
        if (normalRate.compareTo(BigDecimal.ZERO) < 0 || reducedRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("A rate cannot be negative");
        }
        //fixed error 1
        if (normalRate.compareTo(reducedRate) < 0) {
            throw new IllegalArgumentException("The normal rate cannot be less to the reduced rate");
        }
        if (!isValidPeriods(reducedPeriods) || !isValidPeriods(normalPeriods)) {
            throw new IllegalArgumentException("The periods are not valid individually");
        }
        if (!isValidPeriods(reducedPeriods, normalPeriods)) {
            throw new IllegalArgumentException("The periods overlaps");
        }
        this.kind = kind;
        this.hourlyNormalRate = normalRate;
        this.hourlyReducedRate = reducedRate;
        this.reduced = reducedPeriods;
        this.normal = normalPeriods;
    }

    /**
     * Checks if two collections of periods are valid together
     * @param periods1
     * @param periods2
     * @return true if the two collections of periods are valid together
     */
    private boolean isValidPeriods(ArrayList<Period> periods1, ArrayList<Period> periods2) {
        Boolean isValid = true;
        int i = 0;
        while (i < periods1.size() && isValid) {
            isValid = isValidPeriod(periods1.get(i), periods2);
            i++;
        }
        return isValid;
    }

    /**
     * checks if a collection of periods is valid
     * @param list the collection of periods to check
     * @return true if the periods do not overlap
     */
    private Boolean isValidPeriods(ArrayList<Period> list) {
        Boolean isValid = true;
        if (list.size() >= 2) {
            Period secondPeriod;
            int i = 0;
            int lastIndex = list.size()-1;
            while (i < lastIndex && isValid) {
                isValid = isValidPeriod(list.get(i), ((List<Period>)list).subList(i + 1, lastIndex+1));
                i++;
            }
        }
        return isValid;
    }

    /**
     * checks if a period is a valid addition to a collection of periods
     * @param period the Period addition
     * @param list the collection of periods to check
     * @return true if the period does not overlap in the collecton of periods
     */
    private Boolean isValidPeriod(Period period, List<Period> list) {
        Boolean isValid = true;
        int i = 0;
        while (i < list.size() && isValid) {
            isValid = !period.overlaps(list.get(i));
            i++;
        }
        return isValid;
    }
    public BigDecimal calculate(Period periodStay) {
        int normalRateHours = periodStay.occurences(normal);
        int reducedRateHours = periodStay.occurences(reduced);
        BigDecimal price = (this.hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours))).add(
                this.hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));

        //no "else if" for 100% branch coverage
        if (this.kind == CarParkKind.VISITOR) {
            price = visitorPrice(price);
        }
        if (this.kind == CarParkKind.MANAGEMENT) {
            price = managementPrice(price);
        }
        if (this.kind == CarParkKind.STUDENT) {
            price = studentPrice(price);
        }
        if (this.kind == CarParkKind.STAFF) {
            price = staffPrice(price);
        }
        return price;
    }

    /**
     * checks if one of period is null in the ArrayList
     * @param arrayList the Periods list
     * @return true if none of element is null in the list
     */
    public boolean checkPeriodsArray(ArrayList<Period> arrayList) {
        boolean check = true;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == null) {
                check = false;
                break;
            }
        }
        return check;
    }

    /**
     * visitor reduction rates
     * @param price the original price
     * @return the price after reduction for visitor
     */
    public BigDecimal visitorPrice(BigDecimal price) {
        //https://www.tutorialspoint.com/java/math/bigdecimal_subtract_mc.htm
        MathContext mc = new MathContext(2); // 2 precision
        BigDecimal freeFirstTen = new BigDecimal(10);
        BigDecimal fiftyPercentReduction = new BigDecimal(0.5);
        price = (price.subtract(freeFirstTen,mc));
        price = price.multiply(fiftyPercentReduction,mc);
        return price;
    }

    /**
     * management reduction rates
     * @param price the original price
     * @return the price after reduction for management
     */
    public BigDecimal managementPrice(BigDecimal price) {
        BigDecimal minimumPay = new BigDecimal(4);
        if (price.compareTo(minimumPay) < 0) {
            price = minimumPay;
        }
        return price;
    }

    /**
     * student reduction rates
     * @param price the original price
     * @return the price after reduction for student
     */
    public BigDecimal studentPrice(BigDecimal price) {
        MathContext mc = new MathContext(3); // 2 precision
        if (price.compareTo(new BigDecimal(5.5)) > 0) {
            return price.subtract(new BigDecimal(5.5)).multiply(new BigDecimal(0.75),mc).add(new BigDecimal(5.5));
        }
        return price;
    }

    /**
     * staff reduction rates
     * @param price the original price
     * @return the price after reduction for staff
     */
    public BigDecimal staffPrice(BigDecimal price) {
        BigDecimal maximumPay = new BigDecimal(16);
        if (price.compareTo(maximumPay) > 0) {
            price = maximumPay;
        }
        return price;
    }

}