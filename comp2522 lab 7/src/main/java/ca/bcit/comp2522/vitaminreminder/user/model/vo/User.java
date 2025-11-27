package ca.bcit.comp2522.vitaminreminder.user.model.vo;

import java.util.Date;

/**
 * Represents a user.
 *
 * @author Minsu Kim
 *
 * @version 1.0.0
 */
public class User
{
    private int    userId;
    private String email;
    private String password;
    private String fName;
    private String lName;
    private String userTimeZone;
    private Date createdAt;

    public User(){}

    public User(final int userId,
                final String email,
                final String password,
                final String fName,
                final String lName,
                final String userTimeZone,
                final Date createdAt)
    {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.userTimeZone = userTimeZone;
        this.createdAt = createdAt;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(final int userId)
    {
        this.userId = userId;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }

    public String getfName()
    {
        return fName;
    }

    public void setfName(final String fName)
    {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(final String lName)
    {
        this.lName = lName;
    }

    public String getUserTimeZone()
    {
        return userTimeZone;
    }

    public void setUserTimeZone(final String userTimeZone)
    {
        this.userTimeZone = userTimeZone;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(final Date createdAt)
    {
        this.createdAt = createdAt;
    }

    @Override
    public String toString()
    {
        return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", fName=" + fName + ", lName=" + lName + ", userTimeZone=" + userTimeZone + ", createdAt=" + createdAt + "]";
    }
}
