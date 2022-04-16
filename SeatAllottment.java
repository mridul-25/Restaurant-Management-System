package smart_kitchen;

public class SeatAllottment {
    static int six_tables=4;
    static int four_tables=7;
    static int two_tables=5;
    static int extra_chairs=6;
    int sixTablesUsed=0;
    int fourTablesUsed=0;
    int twoTablesUsed=0;
    int extraChairsUsed=0;
     int members_number=0;
    SeatAllottment(int members_number)
    {
        this.members_number=members_number;

    }
    
    boolean tables_left()
    {
        int members =members_number;
        int six_tables=SeatAllottment.six_tables;
        int four_tables=SeatAllottment.four_tables;
        int two_tables=SeatAllottment.two_tables;
        int extra_chairs=SeatAllottment.extra_chairs;

        //int break_flag=0;
        if(members>=6)
        {
            if(SeatAllottment.six_tables>=1)
            {
                if((SeatAllottment.six_tables-members/6)>=0){
                six_tables=SeatAllottment.six_tables-members/6;
                members=members%6;
                }
                else
                {
                    members=members-SeatAllottment.six_tables*6;
                    six_tables=0;
                }



            }
        }
            if(members<6&&members>=4)
            if(SeatAllottment.four_tables>=1)
            {   if((SeatAllottment.four_tables-members/4)>=0){
                four_tables=SeatAllottment.four_tables-members/4;
                members=members%4;
            }
            else
                {
                    members=members-SeatAllottment.four_tables*4;
                    four_tables=0;
                }

            }
            if(members<4&&members>=2)
            if(SeatAllottment.two_tables>=1)
            {
                if((SeatAllottment.two_tables-members/2)>=0){
                two_tables=SeatAllottment.two_tables-members/2;
                members=members%2;}
                else
                {
                    members=members-SeatAllottment.two_tables*6;
                    two_tables=0;
                }
            }

            if(members==1)
            if(SeatAllottment.extra_chairs>=1)
            {
                extra_chairs=SeatAllottment.extra_chairs-members;
                members=members-1;
                
            }
            if(members>0)
            return false;
            else{
                sixTablesUsed=SeatAllottment.six_tables-six_tables;
                fourTablesUsed=SeatAllottment.four_tables-four_tables;
                twoTablesUsed=SeatAllottment.two_tables-two_tables;
                extraChairsUsed=SeatAllottment.extra_chairs-extra_chairs;
                updateTables(six_tables, four_tables, two_tables, extra_chairs);
                return true;
            }
            

    }
    void updateTables(int six_tables,int four_tables,int two_tables,int extra_chairs)
    {
        SeatAllottment.six_tables=six_tables;
                SeatAllottment.four_tables=four_tables;
                SeatAllottment.two_tables=two_tables;
                SeatAllottment.extra_chairs=extra_chairs;
                // System.out.println("six tables are"+SeatAllottment.six_tables);
                // System.out.println("four tables are"+SeatAllottment.four_tables);
                // System.out.println("two tables are"+SeatAllottment.two_tables);
                // System.out.println(" extra chairs are"+SeatAllottment.extra_chairs);
                
    }
    

   

}
