package smart_kitchen;
import java.util.*;
import java.util.stream.Stream;
 class Menu
{
    
    private static Map<Integer,String> items=new HashMap<Integer, String>();
    private static Map<Integer,Double> price=new HashMap<Integer, Double>();
    private static Map<Integer,Integer> prep_time=new HashMap<Integer,Integer>();
    Menu()
    {
        // 101,102 etc. are the codes which will act as a key for the information of a particular item.
    items.put(101,"Veg. Cheese Burger");
    items.put(102,"Chicken Burger");
    items.put(103,"French Fries");
    items.put(104,"Veg. Grilled Sandwich");
    items.put(105,"Chilli Chicken Sandwich");
    items.put(106,"Cheese Margherita Pizza");
    items.put(107,"Corn Mushroom Pizza");
    items.put(108,"Cheese Burst Pizza");
    items.put(109,"Pepper Barbecue Chicken Pizza");
    items.put(110,"Chicken Tikka Pizza");
    items.put(111,"Chilli Paneer");
    items.put(112,"Chilli Honey Potato");
    items.put(113,"Chilli Chicken");
    items.put(114,"Chilli Garlic Noodles");
    items.put(115,"Veg. Manchurian");
    items.put(116,"Veg. Fried Rice");
    items.put(117,"Veg. Schezwan Rice");
    items.put(118,"Masala Dosa");
    items.put(119,"Veg. Uttapam");
    items.put(120,"Pav Bhaji");
    items.put(121,"Paneer Tikka");
    items.put(122,"Mirch Vada");
    items.put(123,"Vada Pav");
    items.put(124,"Chhola Bhatura");
    items.put(125,"Hyderabadi Biryani");
    items.put(126,"Veg. Kebab Rolls");
    items.put(127,"Red Sauce Pasta");
    items.put(128,"White Sauce Pasta");
    items.put(129,"Mexican Tacos");
    items.put(130,"Garlic Bread");
    items.put(131,"Chocolate Milk Shake");
    items.put(132,"Banana Milk Shake");
    items.put(133,"Black Current Milk Shake");
    items.put(134,"Butterscotch Milk Shake");
    items.put(135,"Choice of Soft Drink");
    items.put(136,"Gulab Jamum");
    items.put(137,"Chocolate Fudge");
    items.put(138,"Chocolate Brownie");
    items.put(139,"Pineapple Pastry");
    items.put(140,"Black Forest Pastry");
    items.put(141,"Dahi Jalebi");

    price.put(101,100.00);
    price.put(102,120.00);
    price.put(103,80.00);
    price.put(104,100.00);
    price.put(105,120.00);
    price.put(106,150.00);
    price.put(107,200.00);
    price.put(108,250.00);
    price.put(109,250.00);
    price.put(110,270.00);
    price.put(111,175.00);
    price.put(112,175.00);
    price.put(113,200.00);
    price.put(114,200.00);
    price.put(115,200.00);
    price.put(116,175.00);
    price.put(117,200.00);
    price.put(118,130.00);
    price.put(119,140.00);
    price.put(120,120.00);
    price.put(121,175.00);
    price.put(122,80.00);
    price.put(123,100.00);
    price.put(124,130.00);
    price.put(125,200.00);
    price.put(126,120.00);
    price.put(127,200.00);
    price.put(128,200.00);
    price.put(129,150.00);
    price.put(130,100.00);
    price.put(131,70.00);
    price.put(132,70.00);
    price.put(133,70.00);
    price.put(134,70.00);
    price.put(135,40.00);
    price.put(136,50.00);
    price.put(137,80.00);
    price.put(138,150.00);
    price.put(139,70.00);
    price.put(140,100.00);
    price.put(141,110.00);

    //The preparation time is in minutes.Assumption is that the preparation time is the time for a bulk of that item.
    prep_time.put(101,10);
    prep_time.put(102,10);
    prep_time.put(103,5);
    prep_time.put(104,7);
    prep_time.put(105,8);
    prep_time.put(106,11);
    prep_time.put(107,12);
    prep_time.put(108,20);
    prep_time.put(109,15);
    prep_time.put(110,15);
    prep_time.put(111,15);
    prep_time.put(112,15);
    prep_time.put(113,13);
    prep_time.put(114,12);
    prep_time.put(115,15);
    prep_time.put(116,10);
    prep_time.put(117,12);
    prep_time.put(118,5);
    prep_time.put(119,7);
    prep_time.put(120,5);
    prep_time.put(121,15);
    prep_time.put(122,7);
    prep_time.put(123,5);
    prep_time.put(124,8);
    prep_time.put(125,15);
    prep_time.put(126,8);
    prep_time.put(127,15);
    prep_time.put(128,15);
    prep_time.put(129,10);
    prep_time.put(130,7);
    prep_time.put(131,5);
    prep_time.put(132,5);
    prep_time.put(133,5);
    prep_time.put(134,5);
    prep_time.put(135,1);
    prep_time.put(136,2);
    prep_time.put(137,2);
    prep_time.put(138,2);
    prep_time.put(139,1);
    prep_time.put(140,1);
    prep_time.put(141,10);

    }
    // void show()
    // {
    //     System.out.println(items.get(101));
    //     System.out.println(price.get(101));
    //     System.out.println(prep_time.get(101));
    // }

    String getItem(int code)
    {
      return items.get(code);  
    }
    int getPrepTime(int code)
    {
        return prep_time.get(code);
    }
    double getPrice(int code)
    {
        return price.get(code);
    }

    void setPrice(int code,double changedprice)
    {
        price.put(code,changedprice);
    }
    void addItem(String item,double newPrice,int prep){
        int new_code=101+items.size();
        items.put(new_code,item);
        price.put(new_code,newPrice);
        prep_time.put(new_code,prep);
    }
    //Limitation is that as soon as the code stops running, the newly added item gets erased, it does not get saved.
    public static void simpleTable() {

        /*
         * leftJustifiedRows - If true, it will add "-" as a flag to format string to
         * make it left justified. Otherwise right justified.
         */
        boolean leftJustifiedRows = false;

        /*
         * Table to print in console in 2-dimensional array. Each sub-array is a row.
         */
        String[][] table = new String[items.size()+1][4];
        // { { "id", "First Name", "Last Name", "Age" },
        // { "1", "John", "Johnson", "45" }, { "2", "Tom", "", "35" }, { "3", "Rose",
        // "Johnson", "22" },
        // { "4", "Jimmy", "Kimmel", "" } };
        table[0][0] = "Code Number";
        table[0][1] = "Item Name";
        table[0][2] = "Price";
        table[0][3] = "Preparation Time";
        for (int row_count = 1; row_count < items.size()+1; row_count++) {
            table[row_count][0] = Integer.toString(row_count+100);
            table[row_count][1] = items.get(row_count + 100);
            table[row_count][2] = Double.toString(price.get(row_count + 100));
            table[row_count][3] = Integer.toString(prep_time.get(row_count + 100));
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
        // System.out.println("columnLengths = " + columnLengths);

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
        Stream.iterate(0, (i -> i < table.length), (i -> ++i))
                .forEach(a -> System.out.printf(formatString.toString(), table[a]));

    }

}