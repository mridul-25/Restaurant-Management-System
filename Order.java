package smart_kitchen;

import java.util.*;
import java.io.*;
import java.util.stream.*;

class Order extends Menu /*implements Serializable*/ {
    ArrayList<Bill> order=new ArrayList<Bill>();
    int orderID;
    int minPrepTime;
    int orderHrs;
    int orderMin;

    final double cgst=0.025; //tax
    final double sgst=0.025; //tax
    //Here order number is to be added will add later on.
    Order(int orderID,int hrs,int min)
    {
        this.orderID=orderID;
        this.orderHrs=hrs;
        this.orderMin=min;
    }
    void interact()
    {
        Scanner ob=new Scanner(System.in);
        
        while(true)
        {
            
            System.out.println("Pls enter the item code for adding the item to your order");
            System.out.println("In order to exit from ordering, press 0");
            int code=ob.nextInt();
            if(code>=101&&code<=141 ||code==0)
            {
            if(code==0)
            break;
            else
            {
                System.out.println("Pls enter the quantity");
                int qty=ob.nextInt();
                order.add(new Bill(qty,getItem(code),getPrice(code),getPrepTime(code)));
            }
            }
            else
            System.out.println("Enter a valid code");

            
        }
        

    }

    
    public void order_print() {
        int number_of_items = order.size();
        double final_amount = final_bill_calculation();
        System.out.println("Order number:" + orderID);
        /*
         * leftJustifiedRows - If true, it will add "-" as a flag to format string to
         * make it left justified. Otherwise right justified.
         */
        boolean leftJustifiedRows = false;
        String[][] table = new String[number_of_items+1][5];
        table[0][0] = "Serial Number";
        table[0][1] = "Item Name";
        table[0][2] = "Quantity";
        table[0][3] = "Price";
        table[0][4]="Amount";

        for (int row_count = 1; row_count < number_of_items+1; row_count++) {
            table[row_count][0] = Integer.toString(row_count);
            table[row_count][1] = order.get(row_count-1).item;
            table[row_count][2] = Integer.toString(order.get(row_count-1).qty);
            table[row_count][3] = Double.toString(order.get(row_count-1).rate);
            table[row_count][4]=Double.toString(Double.parseDouble(table[row_count][3])*Integer.parseInt(table[row_count][2]));
        }

        /*
         * Calculate appropriate Length of each column by looking at width of data in
         * each column.
         * 
         * Map columnLengths is <column_number, column_length>
         */
        Map<Integer, Integer> columnLengths = new HashMap<>();
        Arrays.stream(table).forEach(a -> Stream.iterate(0, (i -> i < a.length), (i -> ++i)).forEach(i -> {
            if (columnLengths.get(i) == null) {
                columnLengths.put(i, 0);
            }
            if (columnLengths.get(i) < a[i].length()) {
                columnLengths.put(i, a[i].length());
            }
        }));

        /*
         * Prepare format String
         */
        final StringBuilder formatString = new StringBuilder("");
        String flag = leftJustifiedRows ? "-" : "";
        columnLengths.entrySet().stream().forEach(e -> formatString.append("| %" + flag + e.getValue() + "s "));
        formatString.append("|\n");
        // System.out.println("formatString = " + formatString.toString());

        /*
         * Print table
         */
        Stream.iterate(0, (i -> i < table.length), (i -> ++i)).forEach(a -> System.out.printf(formatString.toString(), table[a]));

        System.out.println("Preparation_time:" + minPrepTime);
        System.out.println("Final amount:" + final_amount);
    }

    double revenue_calculation()
    {
        double revenue_from_order=0.0;
        int size=order.size();
        for(int i=0;i<size;i++)
        {
            Bill bill=order.get(i);
            revenue_from_order= revenue_from_order + bill.qty*bill.rate;
        }
        Revenue r=new Revenue();
        r.addRevenue(revenue_from_order);
        return revenue_from_order;
    }
    double final_bill_calculation()
    {
        return (this.revenue_calculation())*(1+sgst+cgst);
    }
    public String toString()
    {
        String str= "The revenue amount is"+this.revenue_calculation()+"and the bill amount is"+this.final_bill_calculation();
        return str;
    }
    
}
