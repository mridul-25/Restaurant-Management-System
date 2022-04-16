package smart_kitchen;

public class DisplayServed implements Runnable{
    Thread t;
    long sleepingTime;
    int orderID;
    static SeatAllottment st;
    DisplayServed(SeatAllottment st)
    {
        DisplayServed.st=st;
        //System.out.println(this.st);
    }
    DisplayServed(int time,int orderID/*,SeatAllottment st*/)
    {
        this.sleepingTime=time*60*1000;
        this.orderID=orderID;
        
    }
    public void run(){
        try{
            //System.out.println("In the thread");
        Thread.sleep(sleepingTime);
        System.out.println("The order having order ID "+this.orderID+" is served. Pls collect it");
        }
        catch(InterruptedException E)
        {
            System.out.println("Exception occured");
        }
        SeatUnoccupied seat=new SeatUnoccupied(DisplayServed.st);
        Thread additionThread=new Thread(seat);
        additionThread.start();

        
         

    }
}
