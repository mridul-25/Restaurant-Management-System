package smart_kitchen;


import java.util.*;
import java.text.*;

public class CookState {
    static boolean tables_left = true;
    static ArrayList<Integer> cook = new ArrayList<Integer>(5);
    ArrayList<Integer> item_time = new ArrayList<Integer>(60);
    ArrayList<Integer> hrs = new ArrayList<Integer>(1000);
    ArrayList<Integer> mins = new ArrayList<Integer>(1000);
    static ArrayList<Integer> min_prep_time = new ArrayList<Integer>(1000);
    //static int[] start_time = new int[] { 10, 0 };
    //static int[] prev_order_time = new int[2];
    //static int[] new_order_time = new int[2];
    int order_number;
    int qty;
    String item;
    double rate;
    int finalPrepTime;
    int[] order_time = new int[2];
    Order O;
    final int eatingTime=15;

    CookState() { // cook and time till when the chef will be occupied
        cook.add(0);
        cook.add(0);
        cook.add(0);
        cook.add(0);
        cook.add(0);
    }
    CookState(Order O) {
        this.O = O;
        
    }

    public String check() {// checking state
        Date date = new Date();
        DateFormat fmt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String date_string = fmt.format(date);
        int currentHrs = Integer
                .parseInt(date_string.substring(date_string.indexOf(' ') + 1, date_string.indexOf(':')));
        int currentMin = Integer
                .parseInt(date_string.substring(date_string.indexOf(':') + 1, date_string.lastIndexOf(':')));
        // assigns calendar to given date
        int order_hour = O.orderHrs;
        int order_mins = O.orderMin;
        if (currentHrs * 60 + currentMin - order_hour * 60 - order_mins > O.minPrepTime) {
            return "Served";
        } else if (((min_prep_time.get(O.orderID - 1) <= currentHrs * 60 + currentMin - order_hour * 60 - order_mins)
                && (currentHrs * 60 + currentMin - order_hour * 60 - order_mins <O.minPrepTime))) {
            return "Preparing";
        } else {
            // else if ((1 >= current_hrs * 60 + current_mins - order_hour * 60 +
            // order_mins)) {
            return "Order Taken";
        }
    }

    public int cook_time_allocate() {
        Date date=new Date();
        DateFormat fmt=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String date_string=fmt.format(date);
        int currentHrs=Integer.parseInt(date_string.substring(date_string.indexOf(' ')+1,date_string.indexOf(':')));
        int currentMin=Integer.parseInt(date_string.substring(date_string.indexOf(':')+1,date_string.lastIndexOf(':')));
// assigns calendar to given date
        //hrs.add(calendar.get(Calendar.HOUR_OF_DAY));
        //mins.add(calendar.get(Calendar.MINUTE));
        int time_elapsed=0;
        if(Main.ListOfOrders.size()==1)
        {
            time_elapsed=0;
        }
        else{
        int prevHr=Main.ListOfOrders.get(Main.ListOfOrders.size()-2).orderHrs;
        int prevMin=Main.ListOfOrders.get(Main.ListOfOrders.size()-2).orderMin;
        //System.out.println("The previous hr ="+prevHr);
        //System.out.println("The previous min="+prevMin);
         time_elapsed=(currentHrs-prevHr)*60+ currentMin-prevMin;
        }

        int number_of_items = O.order.size();
        int prep_time_final;
        for (int count = 0; count < number_of_items; count++) {
            item_time.add(O.order.get(count).prep_time);
        }
        Collections.sort(item_time);

        //System.out.println("Itemtime"+item_time.toString());
        //System.out.println("time elapsed"+time_elapsed);
        //System.out.println("Cook times before for loop"+cook.toString());
        int final_prep_time = 0;
        Collections.sort(cook);
        min_prep_time.add(cook.get(0));
        for (int count = 0; count < number_of_items; count++) {
            Collections.sort(cook);
            //System.out.println("COok sarray"+cook.toString());
            int time_initial = cook.get(0);
            int timeAdded;
            if(time_initial==0)
            {
             timeAdded=time_initial + item_time.get(number_of_items - 1 - count);
            }
            else{
                timeAdded=time_initial + item_time.get(number_of_items - 1 - count)-time_elapsed;
            }
            //System.out.println("TimeAdded"+timeAdded);
            if(timeAdded<0)
            cook.set(0, 0);
            else
            cook.set(0,timeAdded);
            if(time_initial==0)
            prep_time_final = time_initial + item_time.get(number_of_items - 1 - count);
            else
            prep_time_final = time_initial + item_time.get(number_of_items - 1 - count)-time_elapsed;
            if (prep_time_final > final_prep_time) {
                final_prep_time = prep_time_final;
            }

        }
        finalPrepTime=final_prep_time;
        return final_prep_time;

    }
    int time_left()
    {
        Date date=new Date();
            DateFormat fmt=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String date_string=fmt.format(date);
            int hrs=Integer.parseInt(date_string.substring(date_string.indexOf(' ')+1,date_string.indexOf(':')));
            int min=Integer.parseInt(date_string.substring(date_string.indexOf(':')+1,date_string.lastIndexOf(':')));
            
            return this.finalPrepTime+eatingTime-(hrs-O.orderHrs-1)*60+(min-O.orderMin+60);
    }

}
