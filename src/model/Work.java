package model;


import java.sql.Date;

public class Work {
   private int  work_id;
   private int stu_id;
   private int dor_id;
   private String style;
   private String date;
   private String description;

    public int  getWork_id() {
        return work_id;
    }

    public void setWork_id(int word_id) {
        this.work_id = word_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getDor_id() {
        return dor_id;
    }

    public void setDor_id(int dor_id) {
        this.dor_id = dor_id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Work(int stu_id, int dor_id, String style, String date, String description) {
        this.stu_id = stu_id;
        this.dor_id = dor_id;
        this.style = style;
        this.date = date;
        this.description = description;
    }
    public Work(){}
}
