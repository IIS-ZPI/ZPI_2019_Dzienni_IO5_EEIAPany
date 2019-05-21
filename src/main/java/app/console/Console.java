package app.console;

import app.command.Command;
import app.command.CommandBuilder;

import java.util.Scanner;

public class Console {
    private Command command;
    private Scanner scanner;
    private CommandBuilder commandBuilder;

    public Console() {
        scanner = new Scanner(System.in);
        commandBuilder = new CommandBuilder();
    }

    public void run() {

        askForOutputType();
        askForCurrency();
        askForDate();
        command = commandBuilder.build();
        System.out.println(command.getCommand());
    }

    private void askForOutputType() {
        System.out.println("Podaj typ danych:\n" +
                "1. Sesje wzrostowe, spadkowe i bez zmian.\n" +
                "2. Miary statyczne\n" +
                "3. Rozkad zmian miesięcznych");

        int x = scanner.nextInt();
        scanner.nextLine();
        switch (x){
            default:
                System.out.println("Wybrano " + x);
                break;
        }
    }

    private void askForCurrency() {
        System.out.println("Podaj walutę:");

        String currency = scanner.nextLine();
        System.out.println("Wybrano " + currency);
        commandBuilder.setCurrency(currency);
    }

    private void askForDate() {
        System.out.println("Podaj datę  RRRR-MM-DD:");

        String date = scanner.nextLine();
        System.out.println("Wybrano " + date);
        commandBuilder.setDate(date);
    }

    public String getCommand() {
        return command.getCommand();
    }
}
