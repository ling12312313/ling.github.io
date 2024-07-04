package model;

public class Dormitories {
    private  int  dor_id;
    private String dor_node;
    private int  dor_num;
    private String dor_addr;

    public String getDor_addr() {
        return dor_addr;
    }

    public void setDor_addr(String dor_addr) {
        this.dor_addr = dor_addr;
    }



    public int  getDor_id() {
        return dor_id;
    }

    public void setDor_id(int dor_id) {
        this.dor_id = dor_id;
    }

    public String getDor_node() {
        return dor_node;
    }

    public void setDor_node(String dor_name) {
        this.dor_node = dor_name;
    }

    public int  getDor_num() {
        return dor_num;
    }

    public void setDor_num(int  dor_num) {
        this.dor_num = dor_num;
    }

    public Dormitories(int  dor_id, String dor_node, int dor_num,String dor_addr) {
        this.dor_id = dor_id;
        this.dor_node = dor_node;
        this.dor_num = dor_num;
        this.dor_addr = dor_addr;
    }

    public Dormitories() {
    }
}
