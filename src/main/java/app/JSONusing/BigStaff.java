package app.JSONusing;

import java.util.ArrayList;

public class BigStaff {
    String table;
    String currency;
    String code;
    ArrayList<Staff> rates;

    @Override
    public String toString() {
        return "BigStaff:\n" +
                "table = " + table + '\n' +
                "currency = " + currency + '\n' +
                "code = " + code + '\n' +
                "rates = " + rates + '\n';
    }
}
