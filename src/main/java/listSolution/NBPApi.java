package listSolution;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.net.URL;

class NBPApi {

     static Currency fromJsonToObject(String startDate, String endDate) {

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            Currency usdCurrency = objectMapper.readValue(new URL("http://api.nbp.pl/api/exchangerates/rates/c/usd/" + startDate + "/" + endDate + "/?format=json"), Currency.class);
            return usdCurrency;

        } catch (IOException e) {
            System.err.println("Failed to get content from URL due to exception: " + e.getMessage() + "\nSomething goes wrong!");
            return null;
        }
    }
}
