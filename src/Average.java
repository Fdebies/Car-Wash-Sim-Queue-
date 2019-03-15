import java.util.ArrayList;

public class Average
{
    public ArrayList<Integer> data;
    private double mean;
    public Average()
    {

        data = new ArrayList<Integer>();

        for(int i = 0; i < data.size(); i++)
        {
            System.out.print("Enter score number " + (i + 1) + ": ");
            data.get(i);
        }
    }
    public void addtoArray(int i)
    {
        data.add(i);
    }
    public double calculateMean()
    {

        int i;
        int s = 0;
        for(i = 0; i < data.size(); i++)
        {
            s = s + data.get(i);
        }

        mean = (double)s / (data.size());
        return mean;
    }

}