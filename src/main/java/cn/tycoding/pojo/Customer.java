package cn.tycoding.pojo;

import java.io.Serializable;

/**
 * 客户信息的JavaBean
 * @author tycoding
 * @date 18-4-7下午7:27
 */
public class Customer implements Serializable {

    //客户的id
    private int c_id;
    //客户的姓名
    private String c_name;
    //客户的电话
    private String c_telephone;
    //客户的住址
    private String c_address;
    //客户备注
    private String c_remark;

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_telephone() {
        return c_telephone;
    }

    public void setC_telephone(String c_telephone) {
        this.c_telephone = c_telephone;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getC_remark() {
        return c_remark;
    }

    public void setC_remark(String c_remark) {
        this.c_remark = c_remark;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "c_id='" + c_id + '\'' +
                ", c_name='" + c_name + '\'' +
                ", c_telephone='" + c_telephone + '\'' +
                ", c_address='" + c_address + '\'' +
                ", c_remark='" + c_remark + '\'' +
                '}';
    }
}
