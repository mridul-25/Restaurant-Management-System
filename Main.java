package smart_kitchen;

import java.util.*;
import java.io.IOException;
import java.text.*;
public class Main extends Menu
{
    private static String passwordAdmin="Hello@123";
    static ArrayList<Order>ListOfOrders;
    static ArrayList<CookState> ListOfCookStates;
    static Thread servingThreads[];
    static int orderID =0;
    public static void main(String[] args)throws InterruptedException {
        
        Main m=new Main();
        servingThreads=new Thread[200];
        ListOfOrders=new ArrayList<Order>();
        ListOfCookStates=new ArrayList<CookState>();
        
       // System.out.println(hrs);
        //System.out.println(date_string); 
       /* while(hrs>=12&&hrs<=23)
        {

            Order_save obj1=new Order_save(date_string,++order_number);
            //Order_retrieval obj2=new Order_retrieval();
            obj1.save();
           // obj2.retrieve();

        }*/
        Scanner sc=new Scanner(System.in);
        CookState cookstate=new CookState();
        while(true)
        {
        System.out.println("If you are a customer press 1. If you are a part of admin press 2.");
        
        int choiceOfUser=sc.nextInt();
        switch(choiceOfUser)
        {
            case 2:
            System.out.println("Enter password");
            String str=sc.next();
            if(str.equals(passwordAdmin))
            {                
                System.out.println("For knowing revenue press 1.");
                System.out.println("For adding items to the previous menu press 2.");
                System.out.println("For price change press 3.");
                System.out.println("In order to exit press 0");
                int choiceAdmin=sc.nextInt();
                switch(choiceAdmin)
                {
                    case 1:
                    Revenue revenueObj=new Revenue();
                    System.out.println("Revenue is "+Revenue.revenue);
                    revenueObj.getProfit();
                    break;
                    case 2:
                    System.out.println("Enter item name");
                    String item_name=sc.next();
                    System.out.println("Enter price");
                    double price=sc.nextDouble();
                    System.out.println("Enter the preparation time");
                    int prep_time=sc.nextInt();
                    Admin admin=new Admin();
                    admin.update(item_name,price,prep_time);
                    System.out.println("Updated!!. You can have a look");
                    Menu.simpleTable();
                    break;
                    case 3:
                    System.out.println("Enter the code");
                    int code=sc.nextInt();
                    System.out.println("Enter the new price");
                    double updatedprice=sc.nextDouble();
                    Admin admin1= new Admin();
                    admin1.updatePrice(code, updatedprice);
                    break;
                    


                }
            }
            else
            System.out.println("Wrong password");
            break;
            case 1:
            System.out.println("If you want to put new order press 1.");
            System.out.println("If you want to know the remaining time and the state of your order press 2.");
            int customerChoice=sc.nextInt();
            switch(customerChoice){
            
                case 1:
            synchronized(m){
            RestaurantState rst=new RestaurantState();
            Thread t =new Thread(rst,"state");
            t.start();
            t.join();

            if(rst.state.equals("open"))
            {
                Menu.simpleTable();
                orderID++;
            Date date=new Date();
            DateFormat fmt=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String date_string=fmt.format(date);
            int hrs=Integer.parseInt(date_string.substring(date_string.indexOf(' ')+1,date_string.indexOf(':')));
            int min=Integer.parseInt(date_string.substring(date_string.indexOf(':')+1,date_string.lastIndexOf(':')));

            Order order=new Order(orderID,hrs,min);
            
            order.interact();
            ListOfOrders.add(order);
            
            cookstate=new CookState(order);

            ListOfCookStates.add(cookstate);
            order.minPrepTime=cookstate.cook_time_allocate();
            DisplayServed ds=new DisplayServed(order.minPrepTime, orderID);
            servingThreads[orderID-1]=new Thread(ds);
                servingThreads[orderID-1].start();
                //servingThreads.add(servingThread);

            //order.minPrepTime=cookstate.method();
            //ListOfOrders.add(order);
            order.order_print();
            //System.out.println("Arraylits"+CookState.cook.toString());
            
            //Demo d=new Demo(order);
            //d.display();
            //System.out.println(order);
            //System.out.println("enter any integer");
            //System.out.println(sc.nextInt());
            }}
            break;
            
            case 2:
            System.out.println("Enter the order ID as printed on your bill");
            int inputtedOrderID=sc.nextInt();
            try{
            Order previousOrder=ListOfOrders.get(inputtedOrderID-1);
            CookState getCookState=ListOfCookStates.get(inputtedOrderID-1);
           // System.out.println(getCookState.hrs.get(0));
            String cookingState=getCookState.check();
            System.out.println(cookingState);
            }
            catch(Exception e)
            {
                System.out.println("There is no such order");
            }
            break;
            
            

            
            }
            
        }}


    }
}
