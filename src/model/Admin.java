package model;

public class Admin {
    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private int admin_id;
    private String password;

    public Admin(int admin_id, String password) {
        this.admin_id = admin_id;
        this.password = password;
    }

    public Admin() {
    }
}
