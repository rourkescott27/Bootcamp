package book3.ch4;

public class Game
{
    public void play()
    {
        System.out.println("Playing!");
    }
}

// OVERRIDING THE PLAY METHOD OF THE GAME CLASS
class Chess extends Game
{
    public void play()
    {
        System.out.println("Playing Chess");
        super.play();
    }
}
