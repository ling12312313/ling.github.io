package model;

public class Water {
    private int dor_id;
    private int water_id;

    public int getDor_id() {
        return dor_id;
    }

    public void setDor_id(int dor_id) {
        this.dor_id = dor_id;
    }

    public int getWater_id() {
        return water_id;
    }

    public void setWater_id(int water_id) {
        this.water_id = water_id;
    }

    public int getWater_num() {
        return water_num;
    }

    public void setWater_num(int water_num) {
        this.water_num = water_num;
    }

    private int water_num;

    public Water(int dor_id,int water_num) {
        this.dor_id = dor_id;
        this.water_num = water_num;
    }
    public Water(){}
}
