package app.command;

import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CommandBuilderTest {
    private Command command;
    private DateFormat dateFormat;
    private Date today;

    @Before
    public void setUp() throws Exception {
        CommandBuilder commandBuilder = new CommandBuilder();

        commandBuilder.setCurrency("gbp");
        commandBuilder.setDate("2018-11-11");
        command = commandBuilder.build();

        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        today = new Date();
    }

    @Test
    public void testIfReturnsGivenParameters() {
        assertThat("http://api.nbp.pl/api/exchangerates/rates/A/gbp/2018-11-11/" + dateFormat.format(today) + "/?format=json", is(command.getCommand()));
    }

    @Test
    public void faultyTest() {
        assertThat("http://api.nbp.pl/api/exchangerates/rates/A/gbp/2018-11-12/" + dateFormat.format(today) + "/?format=json", is(command.getCommand()));
    }
}