package listSolution;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Lists {
    List<TitlesColumns> titleLine = new ArrayList<>();
    List<USDRatesTable> tableList = new ArrayList<>();

    void fillList(Currency usdCurrency){
        fillTitlesColumns();

        int j =0;
        for (int i = 0; i < usdCurrency.rates.size(); i++) {
            String date = usdCurrency.rates.get(i).effectiveDate;
            BigDecimal bidPrice = BigDecimal.valueOf(usdCurrency.rates.get(i).bid).setScale(4, RoundingMode.HALF_UP);
            BigDecimal bidPriceSubtracted = BigDecimal.valueOf(usdCurrency.rates.get(j).bid).setScale(4, RoundingMode.HALF_UP);
            BigDecimal bidSubtract = bidPrice.subtract(bidPriceSubtracted).setScale(4, RoundingMode.HALF_UP);
            BigDecimal askPrice = BigDecimal.valueOf(usdCurrency.rates.get(i).ask).setScale(4, RoundingMode.HALF_UP);//usdCurrency.rates.get(i).ask);
            BigDecimal askPriceSubtracted = BigDecimal.valueOf(usdCurrency.rates.get(j).ask).setScale(4, RoundingMode.HALF_UP);
            BigDecimal askSubtract = askPrice.subtract(askPriceSubtracted).setScale(4, RoundingMode.HALF_UP);

            tableList.add(new USDRatesTable(date, bidPrice, askPrice, bidSubtract, askSubtract));
            j=i;
        }
    }


    void fillTitlesColumns(){
        titleLine.add(new TitlesColumns("Date", "Bid price", "Ask price", "Bid price difference", "Ask price difference"));
    }

    void printList(List<USDRatesTable> list){
        TitlesColumns titles = titleLine.get(0);
        System.out.println(titles);

        for (USDRatesTable rates : list) {
            System.out.println(rates);
        }
    }

}
