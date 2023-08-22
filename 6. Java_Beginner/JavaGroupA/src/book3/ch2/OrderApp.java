package book3.ch2;

import java.text.NumberFormat;

public class OrderApp
{
    static NumberFormat cf = NumberFormat.getCurrencyInstance();
    public static void main(String[] args)
    {
//        ORDER 1
        Order order1 = new Order();
        order1.setQuantityOrdered(200);
        order1.setUnitPrice(5.99);
//        double total = order1.getOrderTotal();
        System.out.println("The total for Order 1 is : " + cf.format(order1.getOrderTotal()));

//        ORDER 2
        Order order2 = new Order();
        order2.setQuantityOrdered(75);
        order2.setUnitPrice(8);
        System.out.println("The total for Order 2 is : " + cf.format(order2.getOrderTotal()));
    }
}
