package listSolution;

public class TitlesColumns {
    String date;
    String bid;
    String ask;
    String bidDifference;
    String askDifference;
    String space = "    ";

    TitlesColumns(String date, String bid, String ask, String bidDifference, String askDifference) {
        this.date = date;
        this.bid = bid;
        this.ask = ask;
        this.bidDifference = bidDifference;
        this.askDifference = askDifference;
    }

    @Override
    public String toString() {
        return date + "          " + bid + space + ask + space + bidDifference + space + askDifference;
    }
}
