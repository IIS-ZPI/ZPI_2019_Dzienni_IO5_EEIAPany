package app;

import app.JSONusing.JSONreader;
import app.analysis.Distribution;
import app.analysis.Session;
import app.analysis.Statistics;
import app.console.Console;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {
    private Console console;

    public App() {
        console = new Console();
    }

    public void run() {
        console.run();
        printResult();
    }

    private void printResult() {
        try {
            URL url = new URL(console.getCommand());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            switch (console.opcja){
                case 1:{
                    System.out.println("Sesje wzrostowe: "+Session.countOfGrowth(JSONreader.parseJSON(content.toString()).rates));
                    System.out.println("Sesje spadkowe: "+Session.countOfFall(JSONreader.parseJSON(content.toString()).rates));
                    System.out.println("Sesje stale: "+Session.countOfStatic(JSONreader.parseJSON(content.toString()).rates));
                    break;
                }
                case 2:{
                    System.out.println("Miary statyczne");
                    System.out.println("Mediana: "+Statistics.median(JSONreader.parseJSON(content.toString()).rates));
                    System.out.println("Dominanta: "+Statistics.dominant(JSONreader.parseJSON(content.toString()).rates));
                    System.out.println("Odchylenie: "+Statistics.standardDeviation(JSONreader.parseJSON(content.toString()).rates));
                    break;
                }
                case 3:{
                    System.out.println("Rokzład zmian miesiecznych:");
                    System.out.println(Distribution.count("ss","ss","ss"));
                    break;
                }
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
