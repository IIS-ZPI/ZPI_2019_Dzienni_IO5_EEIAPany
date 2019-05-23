package app.analysis;

import java.util.ArrayList;
import java.util.Random;

public class Distribution {
    public static ArrayList<Double> count(String period, String currencyOne, String currencyTwo){
        ArrayList<Double> arrayList=new ArrayList<Double>();
        Random random=new Random();
        for(int i=0;i<40;i++)
            arrayList.add(random.nextDouble());
        return arrayList;
    }
}
