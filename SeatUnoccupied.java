package smart_kitchen;

public class SeatUnoccupied implements Runnable{
    Thread t;
    SeatAllottment st;
    SeatUnoccupied(SeatAllottment st)
    {
        this.st=st;
        // System.out.println("hello");
        // System.out.println(this.st);
    }
    void seatAdd(int sixTablesUsed,int fourTablesUsed,int twoTablesUsed, int extraChairsUsed)
    {
        SeatAllottment.six_tables+=sixTablesUsed;
        SeatAllottment.four_tables+=fourTablesUsed;
        SeatAllottment.two_tables+=twoTablesUsed;
        SeatAllottment.extra_chairs+=extraChairsUsed;
    }
    public void run()
    {
        try{
            Thread.sleep(15*60*1000);
            seatAdd(st.sixTablesUsed,st.fourTablesUsed,st.twoTablesUsed,st.extraChairsUsed);
            System.out.println("One of the group of customers is finished eating");
        }
        catch(InterruptedException e)
        {
            System.out.println("Exception occured in SeatUnoccupied Class");
        }
        
    }
}
