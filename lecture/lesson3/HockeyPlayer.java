import java.util.Objects;

class HockeyPlayer
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
        if(o == null || getClass() != o.getClass())
        {
            return false;
        }
        final HockeyPlayer that = (HockeyPlayer) o;
        return Objects.equals(teamName, that.teamName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(teamName);
    }
}
