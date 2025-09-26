public interface Flyable
{
    public static final int MAX_KM_PER_SEC = 300000;

    void fly();
    void land();
    int getMaxHeightFeet();

    default void crash()
    {
        System.out.println("ouch");
    }

}
