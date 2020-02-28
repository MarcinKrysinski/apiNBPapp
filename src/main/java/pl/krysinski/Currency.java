package pl.krysinski;


import java.util.List;

public class Currency {
    public String table;
    public String currency;
    public String code;
    List<Rate> rates;

    public List<Rate> getRates() {
        return rates;
    }

}
