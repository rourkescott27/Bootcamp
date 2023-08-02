package book2.ch2;

public class Examples {

    public static void main(String[] args)
    {
            int taxRate = 10;
        double subTotal = 100;
        double total = 1000;
        double taxAmount = 0;
        if (taxRate > 0)
        {

            taxAmount = subTotal * taxRate;
            total = subTotal + total;
        }
        System.out.println(taxAmount);// no access when taxAmount is in IF block
        System.out.println(total);

//        int xInt;
//        long yLong;
//        xInt = 32;
//        yLong = xInt;
//
//        yLong = 32;
//        xInt = yLong;

//        long xLong1 = 58473882;
//        long xLong2 = 58_473_882;

//        char code = 'X';
//        System.out.println(code);


//        class Ball {
//            int speed;
//
//            void setSpeed(int speed) {
//                this.speed = speed;
//            }
//
//        }
//        Ball b1 = new Ball();
//        Ball b2 = b1;
//        b2.setSpeed(100);
//        b1.setSpeed(50);
//        System.out.println(b1.speed);
//        int x2 = 5;
//        String s2 = Integer.toString(10);
//        System.out.println(s2);

//        String s = "10";
//        int x = Integer.parseInt(s);
//        float x2 = Float.parseFloat(s);
//        double x3 = Double.parseDouble(s);
//
//        System.out.println(x);
//        System.out.println(x2);
//        System.out.println(x3);

//        double pi = 3.1314;
//        int iPi;
//        iPi = (int) pi;
//        System.out.println(iPi);

//        int i = 64;
//        int j = 23;
//        System.out.println(j);
//        System.out.print(" and ");
//        System.out.print(i);

    }


}
