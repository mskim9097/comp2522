package ca.bcit.comp2522.vitaminreminder.supplement.model.vo;

import java.util.Date;

public class Supplement
{
    private int supplementId;
    private int userId;
    private String supplementName;
    private String supplementDosage;
    private Date createdAt;

    public Supplement(){}

    public Supplement(final int supplementId,
                      final int userId,
                      final String supplementName,
                      final String supplementDosage,
                      final Date createdAt)
    {
        this.supplementId = supplementId;
        this.userId = userId;
        this.supplementName = supplementName;
        this.supplementDosage = supplementDosage;
        this.createdAt = createdAt;
    }

    public int getSupplementId()
    {
        return supplementId;
    }

    public void setSupplementId(final int supplementId)
    {
        this.supplementId = supplementId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(final int userId)
    {
        this.userId = userId;
    }

    public String getSupplementName()
    {
        return supplementName;
    }

    public void setSupplementName(final String supplementName)
    {
        this.supplementName = supplementName;
    }

    public String getSupplementDosage()
    {
        return supplementDosage;
    }

    public void setSupplementDosage(final String supplementDosage)
    {
        this.supplementDosage = supplementDosage;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(final Date createdAt)
    {
        this.createdAt = createdAt;
    }


}
