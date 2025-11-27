package ca.bcit.comp2522.vitaminreminder.doselog.model.vo;

import java.util.Date;

public class DoseLog
{
    private int logId;
    private int userId;
    private int supplementId;
    private Date scheduledAt;
    private Date takenAt;
    private String status;

    public DoseLog(){}

    public DoseLog(final int logId,
                   final int userId,
                   final int supplementId,
                   final Date scheduledAt,
                   final Date takenAt,
                   final String status)
    {
        this.logId = logId;
        this.userId = userId;
        this.supplementId = supplementId;
        this.scheduledAt = scheduledAt;
        this.takenAt = takenAt;
        this.status = status;
    }

    public int getLogId()
    {
        return logId;
    }

    public void setLogId(final int logId)
    {
        this.logId = logId;
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

    public Date getScheduledAt()
    {
        return scheduledAt;
    }

    public void setScheduledAt(final Date scheduledAt)
    {
        this.scheduledAt = scheduledAt;
    }

    public Date getTakenAt()
    {
        return takenAt;
    }

    public void setTakenAt(final Date takenAt)
    {
        this.takenAt = takenAt;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(final String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "DoseLog [logId=" + logId + ", userId=" + userId + ", supplementId=" + supplementId + ", scheduledAt="
                + scheduledAt + ", takenAt=" + takenAt + ", status=" + status + "]";
    }

}
