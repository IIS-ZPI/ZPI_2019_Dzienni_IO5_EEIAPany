package app.command;

import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CommandBuilderTest {
    private CommandBuilder commandBuilder;

    @Before
    public void setUp() throws Exception {
        commandBuilder = new CommandBuilder();
    }

    @Test
    public void testIfReturnsGivenParameters() {
        commandBuilder.setCurrency("gbp");
        commandBuilder.setDate("2018-11-11");
        Command command = commandBuilder.build();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();

        assertThat("http://api.nbp.pl/api/exchangerates/rates/A/gbp/2018-11-11/" + dateFormat.format(today) + "/?format=json", is(command.getCommand()));
    }
}