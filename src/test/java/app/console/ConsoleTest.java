package app.console;

import app.command.Command;
import app.command.CommandBuilder;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ConsoleTest {
    private CommandBuilder commandBuilder;
    private Command command;
    private Console console;
    private LocalDate today;

    @Before
    public void setUp() throws Exception {
        console = new Console();
        today = LocalDate.now();

        commandBuilder = new CommandBuilder();
        commandBuilder.setCurrency("USD");
        commandBuilder.setDate(today.minusYears(1).toString());
        command = commandBuilder.build();
    }

    @Test
    public void shouldReturnTrue() {
        assertThat(command.getCommand(), is("http://api.nbp.pl/api/exchangerates/rates/A/USD/" + today.minusYears(1) + "/" + today + "/?format=json"));
    }
}