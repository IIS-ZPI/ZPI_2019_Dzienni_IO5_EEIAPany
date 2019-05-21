package app.command;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Command {
    private String date;
    private String currency;

    Command(String date, String currency) {
        this.date = date;
        this.currency = currency;
    }

    public String getCommand() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();

        return "http://api.nbp.pl/api/exchangerates/rates/A/" + currency + "/" + date + "/" + dateFormat.format(today) + "/?format=json";
    }
}
