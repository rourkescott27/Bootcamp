package book3.ch2;

public class Actor
{
    String fName;
    String lName;
    boolean isGreat;

    public Actor(String first, String last)
    {
        this.fName = first;
        this.lName = last;
    }

    public Actor(String first, String last, boolean isGreat)
    {
        this.fName = first;
        this.lName = last;
        this.isGreat = isGreat;
    }

    public void printObject()
    {
        System.out.println(this);
    }

    @Override
    public String toString()
    {
        return "Actor{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", isGreat=" + isGreat +
                '}';
    }

}
