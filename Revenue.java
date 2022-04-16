package smart_kitchen;

public class Revenue {
    static double revenue=7000;
    static double expenses=3000;
    void addRevenue(double revenue)
    {
        Revenue.revenue+=revenue;
    }
    void getProfit()
    {
        System.out.println("The profit up till now is, "+(revenue-expenses));
    }

}
