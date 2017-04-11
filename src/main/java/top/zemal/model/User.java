package top.zemal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zemal-tan
 * @description
 * @create 2017-03-31 17:48
 **/
@Entity
@Table(name = "user_tmp")
public class User {

    @Id     //@GeneratedValue  这儿不需要主键自增长策略
    @Column(name = "user_id")
    private Integer userId;

//    @JsonIgnore
    @ManyToMany(mappedBy = "users", fetch=FetchType.LAZY)
    private Set<UserGroup> userGroups = new HashSet<UserGroup>();

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }
}
