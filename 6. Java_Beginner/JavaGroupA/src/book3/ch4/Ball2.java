package book3.ch4;

public class Ball2
{
    public double weight;
    public double diameter;

    public Ball2(double weight, double diameter)
    {
        this.weight = weight;
        this.diameter = diameter;
        System.out.println("\nHello from the BALL constructor.");
    }

    public Ball2(double weight)
    {
        this.weight = weight;
        this.diameter = 5;
        System.out.println("\nHello from the BALL constructor.");
    }

    public Ball2()
    {
        this.weight = 3;
        this.diameter = 3;
        System.out.println("\nHello from the BALL constructor.");
    }

    @Override
    public String toString()
    {
        return "Ball weight: " + this.weight + " and diameter: " + this.diameter;
    }
}

class BaseBall2 extends Ball2
{
    // It will first call the constructor of the superclass then its own constructor.
    public BaseBall2(double weight)
    {
        // super MUST BE THE VERY FIRST THING YOU CALL OR YOU WILL GET AN ERROR!
        super(weight);
        System.out.println("Howdy from the BASEBALL constructor.");
    }

    public BaseBall2()
    {
        super(5);
    }
}

class SoftBall2 extends Ball2
{

    public SoftBall2(double weight, double diameter)
    {
        super(weight, diameter);
        System.out.println("Hey from the SOFTBALL constructor.");
    }

    public SoftBall2(double weight)
    {
        super(weight);
        System.out.println("Hey from the SOFTBALL constructor.");
    }

    public SoftBall2()
    {
        // super MUST BE THE VERY FIRST THING YOU CALL OR YOU WILL GET AN ERROR!
        super(2);
        System.out.println("Hey from the SOFTBALL constructor.");
    }
}

class BallApp2
{
    public static void main(String[] args)
    {
        BaseBall2 bb = new BaseBall2(5.125);
        System.out.println(bb.toString());

        System.out.println();

        SoftBall2 sf1 = new SoftBall2(1.95, 2.5);
        System.out.println(sf1.toString());


        SoftBall2 sf2 = new SoftBall2(2.321);
        System.out.println(sf2.toString());

        System.out.println();

        SoftBall2 sf3 = new SoftBall2();
        System.out.println(sf3.toString());

        System.out.println();
        Ball2 b1 = new Ball2();
        System.out.println(b1.toString());
    }
}


