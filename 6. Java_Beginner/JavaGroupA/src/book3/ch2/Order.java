package book3.ch2;

public class Order
{
    private double unitPrice;
    private double quantityOrdered;

//    CONSTRUCTORS to show Overloaded methods
//    public Order(double u, double p)
//    {
//        unitPrice = u;
//        quantityOrdered = p;
//    }
//
//    public Order(double u)
//    {
//        unitPrice = u;
//        quantityOrdered = 0;
//    }

    //    GETTER for UnitPrice
    public double getUnitPrice()
    {
        return unitPrice;
    }

    //    SETTER for UnitPrice
    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    /////////////////////////////////
//    GETTER for QuantityOrdered
    public double getQuantityOrdered()
    {
        return quantityOrdered;
    }

    //    SETTER for QuantityOrdered
    public void setQuantityOrdered(double quantityOrdered)
    {
        this.quantityOrdered = quantityOrdered;
    }

    //    METHOD to get order total
    public double getOrderTotal()
    {
        return unitPrice * quantityOrdered;
    }
}
