package app.console;

import app.command.Command;
import app.command.CommandBuilder;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Console {
    private Command command;
    private Scanner scanner;
    private CommandBuilder commandBuilder;

    public int opcja;
    public Console() {
        scanner = new Scanner(System.in);
        commandBuilder = new CommandBuilder();
    }

    public void run() {

        askForOutputType();
        askForDate();
        askForCurrency();
        command = commandBuilder.build();
        System.out.println(command.getCommand());
    }

    private void askForOutputType() {
        System.out.println("Podaj typ danych:\n" +
                "1. Sesje wzrostowe, spadkowe i bez zmian.\n" +
                "2. Miary statyczne\n" +
                "3. Rozkad zmian miesięcznych");

        int x = scanner.nextInt();
        opcja=x;
        scanner.nextLine();
        switch (x){
            default:
                System.out.println("Wybrano " + x);
                break;
        }
    }

    private void askForDate() {
        System.out.println("Podaj okres:\n" +
                "1. Tydzień.\n" +
                "2. 2 tygodnie\n" +
                "3. Miesiac\n" +
                "4. Kwartal\n" +
                "5. Pol roku\n" +
                "6. Rok");

        int x = scanner.nextInt();
        scanner.nextLine();
        LocalDate today = LocalDate.now();
        switch (x){
            case 1:
                commandBuilder.setDate(today.minusWeeks(1).toString());
                break;
            case 2:
                commandBuilder.setDate(today.minusWeeks(2).toString());
                break;
            case 3:
                commandBuilder.setDate(today.minusMonths(1).toString());
                break;
            case 4:
                commandBuilder.setDate(today.minusMonths(3).toString());
                break;
            case 5:
                commandBuilder.setDate(today.minusMonths(6).toString());
                break;
            case 6:
                commandBuilder.setDate(today.minusYears(1).toString());
                break;
        }
    }

    private void askForCurrency() {
        System.out.println("Podaj walutę:");

        String currency = scanner.nextLine();
        System.out.println("Wybrano " + currency);
        commandBuilder.setCurrency(currency);
    }

    public String getCommand() {
        return command.getCommand();
    }
}
