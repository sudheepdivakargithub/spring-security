package com.sdtech.learning.SpringSecurity;

public class AuthenticationRequest
{
    private String userName;

    public AuthenticationRequest()
    {
        super();
    }

    public AuthenticationRequest( String userName,
        String password )
    {
        super();
        this.userName = userName;
        this.password = password;
    }

    private String password;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName( String userName )
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }
}
