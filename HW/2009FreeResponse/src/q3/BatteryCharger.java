package q3;

/**
 * @author Joey Bloom
 * 2009 Free Response Question 3
 *
 */
public class BatteryCharger
{
    private final int[] rateTable;

    public BatteryCharger(int[] rates)
    {
        rateTable = rates;
        assert rateTable.length == 24;
    }

    private int getChargingCost(int startHour, int chargeTime)
    {
        int count = 0;
        for(int i = 0; i < chargeTime; i++)
        {
            count += rateTable[(startHour+i)%24];
        }
        return count;
    }

    public int getChargeStartTime(int chargeTime)
    {
        int minHour = 0;
        int minCost = getChargingCost(0,chargeTime);
        for(int i = 1; i < 24; i++)
        {
            int x = getChargingCost(i,chargeTime);
            if(x < minCost)
            {
                minCost = x;
                minHour = i;
            }
        }
        return minHour;
    }

    //tester
    public static void main(String[] args)
    {
        BatteryCharger charger = new BatteryCharger(new int[]{50,60,160,60,80,100,100,120,150,150,150,200,40,240,220,220,200,200,180,180,140,100,80,60});
        System.out.println(charger.getChargingCost(12,1));
        System.out.println(charger.getChargingCost(0, 2));
        System.out.println(charger.getChargingCost(22,7));
        System.out.println(charger.getChargingCost(22, 30));

        System.out.println();
        System.out.println(charger.getChargeStartTime(1));
        System.out.println(charger.getChargeStartTime(2));
        System.out.println(charger.getChargeStartTime(7));
        System.out.println(charger.getChargeStartTime(30));
    }
}
