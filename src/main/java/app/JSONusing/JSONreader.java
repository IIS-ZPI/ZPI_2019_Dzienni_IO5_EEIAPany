package app.JSONusing;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class JSONreader {
    public static BigStaff parseJSON(String json) throws FileNotFoundException {
        Gson gson = new Gson();
        BigStaff bigStaff = new BigStaff();
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        bigStaff.table = jsonObject.get("table").toString();
        bigStaff.currency = jsonObject.get("currency").toString();
        bigStaff.code = jsonObject.get("code").toString();
        JsonArray jsonArray = jsonObject.get("rates").getAsJsonArray();
        ArrayList<Staff> arrayList = new ArrayList<Staff>();
        for(int i = 0; i < jsonArray.size(); i++){
            String str1 = jsonArray.get(i).getAsJsonObject().get("no").toString();
            String str2 = jsonArray.get(i).getAsJsonObject().get("effectiveDate").toString();
            Double dbl = Double.parseDouble(jsonArray.get(i).getAsJsonObject().get("mid").toString());
            arrayList.add(new Staff(str1, str2, dbl));
        }
        bigStaff.rates = arrayList;
        return bigStaff;
    }

    public static void main(String[] args) {//test
        try {
            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/A/usd/2019-04-03/2019-05-22/?format=json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println(JSONreader.parseJSON(content.toString()));
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
