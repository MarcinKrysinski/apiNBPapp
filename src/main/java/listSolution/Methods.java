package listSolution;



import java.util.Scanner;
import java.util.regex.Pattern;


class Methods {
    static boolean exit = true;
    private Scanner scanner = new Scanner(System.in);
    Lists list = new Lists();

    void menu() {

        System.out.println("### The program shows the price of buy and sell rates in USD from a given date to the current date along with the difference in value (buy and sell) between days.### \nDo you want to start program? (y/n) ");
        String action = scanner.nextLine().toLowerCase();
        Pattern pattern = Pattern.compile("((?:y)|(?:n))");

        if (pattern.matcher(action).matches()) {
            switch (action) {

                case "y":
                    program();
                    break;
                case "n":
                    exit();
                    break;
            }
        } else {
            System.out.println("Bad command. Try again.");
        }
    }


    void program() {

        System.out.println("Date format [yyyy-mm-dd]");

        System.out.println("From date: ");
        String startDate = scanner.nextLine();
        System.out.println("To date: ");
        String endDate = scanner.nextLine();

        boolean datePattern = isCorrectDatePattern(startDate, endDate);

        if(datePattern){
            Currency usdCurrency = NBPApi.fromJsonToObject(startDate, endDate);
            if(!(usdCurrency ==null)) {
                list.fillList(usdCurrency);
                list.printList(list.tableList);
            }else{
                System.out.println();
            }
        }else{
            System.out.println("Wrong date format!");
        }
    }


    boolean isCorrectDatePattern(String startDate, String endDate) {
        return isPattern(startDate) && isPattern(endDate);
    }


    private boolean isPattern(String inputDate) {
        Pattern pattern = Pattern.compile("^[0-9]{4}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$");
        return pattern.matcher(inputDate).matches();
    }


    private void exit() {
        exit = false;
    }

}
