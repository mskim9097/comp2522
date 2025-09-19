import java.util.Objects;

public class HockeyPlayer
{
    private final int yearBorn;
    private final String teamName;

    HockeyPlayer(final int yearBorn,
                 final String teamName)
    {
        this.yearBorn = yearBorn;
        this.teamName = teamName;
    }


    @Override
    public boolean equals(final Object o)
    {
        if(o == null)
        {
            return false;
        }

        if(o == this)
        {
            return true;
        }

        if(!o.getClass().getSimpleName().equals(this.getClass().getSimpleName()))
        {
            return false;
        }

        final HockeyPlayer p;
        p = (HockeyPlayer)o;

        return this.teamName.equalsIgnoreCase(p.teamName) && this.yearBorn == p.yearBorn;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(teamName);
    }

//    @Override
//    public boolean equals(final Object that)
//    {
//        if(that == null)
//        {
//            return false;
//        }
//
//        if(that == this)
//        {
//            return true;
//        }
//
//        if(!(that instanceof HockeyPlayer))
//        {
//            return false;
//        }
//
//        final HockeyPlayer h;
//        h = (HockeyPlayer)that;
//
//        return this.yearBorn == h.yearBorn;
//    }
//
//    @Override
//    public int hashCode()
//    {
//        // equal objects must return equal hashcodes
//        return yearBorn;
//        // return yearBorn
//    }
}
