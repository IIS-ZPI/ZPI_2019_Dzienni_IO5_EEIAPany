package app.JSONusing;

public class Staff {
    String no;
    String effectiveDate;
    Double mid;

    public Staff(String no, String effectiveDate, Double mid) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "Staff:\n" +
                "no = " + no + '\n' +
                "effectiveDate = " + effectiveDate + '\n' +
                "mid = " + mid + '\n';
    }
}
