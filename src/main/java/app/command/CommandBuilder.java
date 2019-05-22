package app.command;

public class CommandBuilder {
    private String date;
    private String currency;

    public CommandBuilder(String date, String currency) {
        this.date = date;
        this.currency = currency;
    }

    public CommandBuilder(){

    }

    public CommandBuilder setDate(String date) {
        this.date = date;
        return this;
    }

    public CommandBuilder setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Command build() {
        return new Command(date, currency);
    }
}
