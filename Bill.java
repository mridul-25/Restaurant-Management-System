package smart_kitchen;

import java.io.*;

class Bill {

    int qty;
    String item;
    double rate;
    int prep_time;
    Bill(int qty, String item, double rate, int prep_time)
    {
        this.qty=qty;
        this.item=item;
        this.rate=rate;
        this.prep_time=prep_time;
    }
}
