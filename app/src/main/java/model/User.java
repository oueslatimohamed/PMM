package model;

public class User {
    private int id;
    private String mName;
    private String mLastname;
    private String mAge;
    private String mLogin;
    private String mPassword;

    public User(int id, String mName, String mLastname, String mAge, String mLogin, String mPassword) {
        this.id = id;
        this.mName = mName;
        this.mLastname = mLastname;
        this.mAge = mAge;
        this.mLogin = mLogin;
        this.mPassword = mPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmLastname() {
        return mLastname;
    }

    public void setmLastname(String mLastname) {
        this.mLastname = mLastname;
    }

    public String getmAge() {
        return mAge;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }

    public String getmLogin() {
        return mLogin;
    }

    public void setmLogin(String mLogin) {
        this.mLogin = mLogin;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
