package smart_kitchen;

 class Admin extends Menu {
    void update(String item,double price,int prep_time)
    {
        addItem(item,price,prep_time);
    }
    void updatePrice(int code, double price)
    {
        setPrice(code, price);
    }
    

}
