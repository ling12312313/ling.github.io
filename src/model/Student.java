package model;

public class Student {
    private  int stu_id;
    private String name;
    private String gender;
    private int age;
    private int class_id;
    private int dor_id;
    private String class_name;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private  String phone;

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getManage() {
        return manage;
    }

    public void setManage(int manage) {
        this.manage = manage;
    }

    private String password;
    private int manage;

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getDor_id() {
        return dor_id;
    }

    public void setDor_id(int dor_id) {
        this.dor_id = dor_id;
    }

    public Student(String password,int stu_id, String name, String gender, int age, int class_id, int dor_id) {
        this.stu_id = stu_id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.class_id = class_id;
        this.dor_id = dor_id;
        this.password = password;
    }

    public Student() {
    }
}
