package top.zemal.model;

import javax.persistence.*;

/**
 * @author zemal-tan
 * @description
 * @create 2017-03-31 17:48
 **/
@Entity
@Table(name = "user_tmp")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private Integer userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserName() {
        return userName;
    }

    public void setUserName(Integer userName) {
        this.userName = userName;
    }
}
