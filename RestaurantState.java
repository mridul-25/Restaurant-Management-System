package smart_kitchen;
import java.util.*;



import java.text.*;


public class RestaurantState implements Runnable{
    
    Thread thread;
    String state="open";
    

    public void run()
    {
        synchronized(this){
            Scanner ob=new Scanner(System.in);
        Date date=new Date();
        DateFormat fmt=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String date_string=fmt.format(date);
        int hrs=Integer.parseInt(date_string.substring(date_string.indexOf(' ')+1,date_string.indexOf(':')));
        int min=Integer.parseInt(date_string.substring(date_string.indexOf(':')+1,date_string.lastIndexOf(':')));

        //System.out.println("Hrs ="+hrs);
        //System.out.println("Min ="+min);
        //System.out.println(date_string);
        try{
        if(hrs<12)
        {

        state="close";
        long time_left=((60-min)+(11-hrs)*60)*60*1000;
        System.out.println("Restaurant is closed, will open after 12pm.");
        Thread.sleep(time_left);
        }
        else {
            state="open";
        System.out.println("Input the number of members");
        int members=ob.nextInt();
        SeatAllottment st=new SeatAllottment(members);
        if(!st.tables_left())
        {
            if(SeatAllottment.six_tables!=0||SeatAllottment.four_tables!=0||SeatAllottment.two_tables!=0)
            {
                System.out.println("There are no required number of seats for you right now");
                state="openButFullForYou";
            }
            else
            {
            state="full";
            ArrayList<Integer> orderTimes=new ArrayList<Integer>();
            int numOrders=Main.ListOfOrders.size();
            for(int i=0;i<numOrders;i++)
            {
                orderTimes.add(Main.ListOfCookStates.get(i).time_left());
            }
            Collections.sort(orderTimes);
            int timeLeft=orderTimes.get(0);
            Thread.sleep(timeLeft);
            
            

        }}
        else{
            state="open";
            //System.out.println("in rstate"+st);
            DisplayServed dse=new DisplayServed(st);
            
        }

        }    

       
    }
    catch(InterruptedException e)
    {
        System.out.println("Exception caught");
    }
            

}}
    }
