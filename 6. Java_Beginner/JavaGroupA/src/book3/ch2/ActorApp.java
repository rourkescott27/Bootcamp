package book3.ch2;

public class ActorApp
{
    public static void main(String[] args)
    {
        Actor actor1 = new Actor("Arnold", " van Graaf");
        Actor actor2 = new Actor("Brad", " Pitt", true);
        System.out.println(actor1.fName + actor1.lName + " is a great actor " + actor1.isGreat);
        System.out.println(actor2.fName + actor2.lName + " is a great actor " + actor2.isGreat);
        /* Address of the specific actor object #1 */
        actor1.printObject();
        /* Address of the specific actor object #2 */
        actor2.printObject();
    }
}
