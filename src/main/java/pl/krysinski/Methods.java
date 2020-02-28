package pl.krysinski;


import java.util.Scanner;
import java.util.regex.Pattern;

class Methods extends Currency {

    static boolean exit = true;
    private Scanner scanner = new Scanner(System.in);


    void menu() {

        System.out.println("### The program shows the price of buy and sell rates in USD from a given date to the current date along with the difference in value (buy and sell) between days.###\n### Only max. 93 results ### \nDo you want to start program? (y/n) ");
        String action = scanner.nextLine().toLowerCase();
        Pattern pattern = Pattern.compile("((?:y)|(?:n))");

        if (pattern.matcher(action).matches()) {
            switch (action) {

                case "y":
                    showTheTableOfBuyAndSellRatesInUSD();
                    break;
                case "n":
                    exit();
                    break;
            }
        } else {
            System.out.println("Bad command. Try again.");
        }


    }

    private void showTheTableOfBuyAndSellRatesInUSD() {
        while (true) {
            Pattern pattern = Pattern.compile("^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$");

            System.out.println("Date format [yyyy-mm-dd]");
            System.out.println("Write start date: ");
            String startDate = scanner.nextLine();
            System.out.println("Write end date: ");
            String endDate = scanner.nextLine();

            if (pattern.matcher(startDate).matches() && pattern.matcher(endDate).matches()) {
                Currency usdCurrency = NBPApi.fromJsonToObject(startDate, endDate);

                assert usdCurrency != null;
                final Object[][] table = new String[usdCurrency.rates.size() + 1][];
                table[0] = new String[]{"Date", "Bid price", "Ask price", "Bid price difference", "Ask price difference"};
                int j = 0;

                for (int i = 0; i < usdCurrency.rates.size(); i++) {
                    String date = usdCurrency.getRates().get(i).effectiveDate;
                    double bidPrice = usdCurrency.getRates().get(i).bid;
                    double askPrice = usdCurrency.getRates().get(i).ask;

                    double bidPriceDifference = usdCurrency.getRates().get(i).bid - usdCurrency.getRates().get(j).bid;
                    double askPriceDifference = usdCurrency.getRates().get(i).ask - usdCurrency.getRates().get(j).ask;


                    table[i + 1] = new String[]{date, String.valueOf(bidPrice), String.valueOf(askPrice), String.valueOf(round(bidPriceDifference)), String.valueOf(round(askPriceDifference))};
                    j = i;
                }

                for (final Object[] row : table) {
                    System.out.format("%-15s%-15s%-15s%-25s%-25s\n", row);
                }

                break;

            } else {
                System.out.println("Wrong date format. Try again.");
            }
        }
    }


    private static void exit() {
        exit = false;
    }


    private static double round(double f) {
        double roundNumber = (float) (f * (Math.pow(10, 4)));

        roundNumber = (Math.round(roundNumber));

        roundNumber = roundNumber / (int) (Math.pow(10, 4));

        return roundNumber;

    }

}
