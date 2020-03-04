package listSolution;

import java.math.BigDecimal;

public class USDRatesTable {
    String date;
    BigDecimal bid;
    BigDecimal ask;
    BigDecimal bidDifference;
    BigDecimal askDifference;

    USDRatesTable(String date, BigDecimal bid, BigDecimal ask, BigDecimal bidDifference, BigDecimal askDifference) {
        this.date = date;
        this.bid = bid;
        this.ask = ask;
        this.bidDifference = bidDifference;
        this.askDifference = askDifference;
    }

    @Override
    public String toString() {
        return date + "    " + bid + "       " + ask + "       " + bidDifference + "                  " + askDifference;
    }

}
