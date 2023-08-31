package book3.ch5;

public interface Dealable {

    default void  shuffleCard()
    {

    }

    void deal(int cards);
}
