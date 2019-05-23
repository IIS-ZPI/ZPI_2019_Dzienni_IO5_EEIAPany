package app.analysis;

import app.JSONusing.Staff;

import java.util.ArrayList;
import java.util.Random;

public class Session {
    public static int countOfGrowth(ArrayList<Staff> arrayList)
    {
        Random random=new Random();
        random.setSeed(567);
        return Math.abs(random.nextInt(60));
    }
    public static int countOfFall(ArrayList<Staff> arrayList)
    {
        Random random=new Random();
        random.setSeed(67);
        return Math.abs(random.nextInt(50));
    }
    public static int countOfStatic(ArrayList<Staff> arrayList)
    {
        Random random=new Random();
        random.setSeed(5667);
        return Math.abs(random.nextInt(30));
    }

}
