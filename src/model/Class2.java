package model;

public class Class2 {
    private int  class_id;
    private String class_name;

    public String getClass_teacher() {
        return class_teacher;
    }

    public void setClass_teacher(String class_teacher) {
        this.class_teacher = class_teacher;
    }

    private String class_teacher;
    public int  getClass_id() {
        return class_id;
    }

    public void setClass_id(int  class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Class2( String class_name,String class_teacher) {
        this.class_name = class_name;
        this.class_teacher = class_teacher;
    }
    public Class2(){}
}
