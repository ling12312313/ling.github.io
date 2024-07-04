package model;

public class User {
       private  String user;
       private String password;
       private int  user_id;
       private  int manage ;

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int  user_id) {
      this.user_id = user_id;
    }

    public void setManage(int manage) {
        this.manage = manage;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public int  getId() {
        return user_id;
    }

    public int getManage() {
        return manage;
    }

    public User() {
    }

    public User(String user, String password, int user_id, int manage) {
        this.user = user;
        this.password = password;
        this.user_id = user_id;
        this.manage = manage;
    }
}
