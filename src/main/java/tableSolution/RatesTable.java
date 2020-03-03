package tableSolution;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RatesTable {

    void createNameLine(Object[][] table) {
        table[0] = new String[]{"Date", "Bid price", "Ask price", "Bid price difference", "Ask price difference"};
    }


    void fillTable(Object[][] table, Currency usdCurrency) {
        int j = 0;
        for (int i = 0; i < usdCurrency.rates.size(); i++) {
            String date = usdCurrency.rates.get(i).effectiveDate;
            BigDecimal bidPrice = BigDecimal.valueOf(usdCurrency.rates.get(i).bid).setScale(4, RoundingMode.HALF_UP);
            BigDecimal bidPriceSubtracted = BigDecimal.valueOf(usdCurrency.rates.get(j).bid).setScale(4, RoundingMode.HALF_UP);
            BigDecimal bidSubtract = bidPrice.subtract(bidPriceSubtracted).setScale(4, RoundingMode.HALF_UP);
            BigDecimal askPrice = BigDecimal.valueOf(usdCurrency.rates.get(i).ask).setScale(4, RoundingMode.HALF_UP);//usdCurrency.rates.get(i).ask);
            BigDecimal askPriceSubtracted = BigDecimal.valueOf(usdCurrency.rates.get(j).ask).setScale(4, RoundingMode.HALF_UP);
            BigDecimal askSubtract = askPrice.subtract(askPriceSubtracted).setScale(4, RoundingMode.HALF_UP);


            table[i + 1] = new String[]{date, String.valueOf(bidPrice), String.valueOf(askPrice), String.valueOf(bidSubtract), String.valueOf(askSubtract)};
            j = i;
        }
    }


    void printTable(Object[][] table) {
        createNameLine(table);
        for (final Object[] row : table) {
            System.out.format("%-15s%-15s%-15s%-25s%-25s\n", row);
        }
    }
}
