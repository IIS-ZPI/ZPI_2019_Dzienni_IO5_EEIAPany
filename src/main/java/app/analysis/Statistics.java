package app.analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Statistics {
    public static double median(ArrayList<Integer> arrayList)
    {
        Random random=new Random();
        random.setSeed(6786);
        int tym=0;
        Collections.sort(arrayList);
        if((arrayList.size()%2==0))
            tym=arrayList.size();
         else
             tym=arrayList.size()+1;
        return arrayList.get(tym/2 );
    }
    public static double dominant(ArrayList<Integer> arrayList)
    {
        Random random=new Random();
        random.setSeed(234);
        return random.nextDouble();
    }
    public static double standardDeviation(ArrayList<Integer> arrayList)
    {
        Random random=new Random();
        random.setSeed(234);
        return random.nextDouble();
    }
}
