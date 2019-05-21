package app;

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
            System.out.println(content);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
