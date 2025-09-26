public class Helicopter
    implements Flyable
{
    @Override
    public void fly() {
       System.out.println("Flying");
    }

    @Override
    public void land() {
        System.out.println("Landing");
    }

    @Override
    public int getMaxHeightFeet() {
        return 5000;
    }
}
