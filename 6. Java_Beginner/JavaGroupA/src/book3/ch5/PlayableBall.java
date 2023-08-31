package book3.ch5;

interface ThrowableBall
{
    void throwBall();
    void catchBall();
}
interface KickableBall
{
    void kickBall();
    void catchBall();
}
public interface PlayableBall
        extends ThrowableBall, KickableBall
{
    void dropBall();
}