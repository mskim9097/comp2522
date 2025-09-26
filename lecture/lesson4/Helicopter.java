public class Helicopter
    implements Flyable
{

    @Override
    public void fly()
    {
        System.out.println("spin rotors");
    }

    @Override
    public void land()
    {
        System.out.println("land on skids");
    }

    @Override
    public int getMaxHeightFeet()
    {
        return 5000;
    }
}
