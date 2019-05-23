package app.JSONusing;

import java.util.ArrayList;

public class BigStaff {
    public String table;
    public String currency;
    public String code;
    public ArrayList<Staff> rates;

    @Override
    public String toString() {
        return "BigStaff:\n" +
                "table = " + table + '\n' +
                "currency = " + currency + '\n' +
                "code = " + code + '\n' +
                "rates = " + rates + '\n';
    }

}
