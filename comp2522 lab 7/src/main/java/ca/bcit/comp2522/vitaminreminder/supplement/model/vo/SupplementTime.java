package ca.bcit.comp2522.vitaminreminder.supplement.model.vo;

import java.sql.Time;

public class SupplementTime
{
    private int timeId;
    private int userId;
    private int supplementId;
    private Time localTime;

    public SupplementTime(){}

    public SupplementTime(final int timeId,
                          final int userId,
                          final int supplementId,
                          final Time localTime)
    {
        this.timeId = timeId;
        this.userId = userId;
        this.supplementId = supplementId;
        this.localTime = localTime;
    }

    public int getTimeId()
    {
        return timeId;
    }

    public void setTimeId(final int timeId)
    {
        this.timeId = timeId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(final int userId)
    {
        this.userId = userId;
    }

    public int getSupplementId()
    {
        return supplementId;
    }

    public void setSupplementId(final int supplementId)
    {
        this.supplementId = supplementId;
    }

    public Time getLocalTime()
    {
        return localTime;
    }

    public void setLocalTime(final Time localTime)
    {
        this.localTime = localTime;
    }

    @Override
    public String toString()
    {
        return "SupplementTime [timeId=" + timeId + ", userId=" + userId + ", supplementId=" + supplementId + ", localTime=" + localTime + "]";
    }

}
