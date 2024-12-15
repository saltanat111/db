package com.example.app.user;

public class user {
    protected String userName;
    public String password;
    
    

    @Override
    public String toString() {
        return "user [userName=" + userName + 
                ", password=" + password + "]";
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    //1 admin
    //2 teacher
    //3 student
    //4 parent

}
