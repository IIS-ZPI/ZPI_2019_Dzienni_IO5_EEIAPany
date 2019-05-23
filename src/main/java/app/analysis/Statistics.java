package app.analysis;

import app.JSONusing.Staff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Statistics {
    public static double median(ArrayList<Staff> arrayList)
    {
        Random random=new Random();
        random.setSeed(6786);

        return random.nextDouble();
    }
    public static double dominant(ArrayList<Staff> arrayList)
    {
        Random random=new Random();
        random.setSeed(234);
        return random.nextDouble();
    }
    public static double standardDeviation(ArrayList<Staff> arrayList)
    {
        Random random=new Random();
        random.setSeed(567);
        return random.nextDouble();
    }
}
