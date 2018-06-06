package cn.tycoding.pojo;

import java.io.Serializable;

/**
 * 这是用户登录的JavaBean
 * @author tycoding
 * @date 18-4-7下午7:28
 */
public class User implements Serializable {

    //用户id
    private int uid;
    //用户登录名
    private String username;
    //用户密码
    private String password;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
