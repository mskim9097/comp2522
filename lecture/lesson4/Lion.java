interface Moveable
{
    void move();
    default void whatever()
    {
        System.out.println("I CAN MOVE");
    }
}

interface Speakable
{
    void speak();
    default void whatever()
    {
        System.out.println("I CAN SPEAK");
    }
}

class Lion
    implements Moveable,
        Speakable
{

    @Override
    public void move()
    {
        System.out.println("RUN");
    }

    @Override
    public void speak()
    {
        System.out.println("ROAR");
    }

    @Override
    public void whatever()
    {
        Speakable.super.whatever();
        Moveable.super.whatever();
        System.out.println(":)");
    }

    public static void main(final String[] args)
    {
        final Lion lion;
        lion = new Lion();
        lion.whatever();
    }
}
