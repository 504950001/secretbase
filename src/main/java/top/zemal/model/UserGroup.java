package top.zemal.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author zemal-tan
 * @description
 * @create 2017-04-06 11:44
 **/
@Entity
@Table(name = "user_group_tmp")
public class UserGroup {
    @Id
    @GeneratedValue
    @Column(name = "user_group_id")
    private Integer userGroupId;

    @Column(name = "user_group_name", unique = true)
    private String userGroupName;  // 用英文命名，方便以后

    @Column(name = "user_group_description")
    private String userGroupDescription;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_group_to_user_tmp",
            joinColumns = {@JoinColumn(name = "from_user_group_id_tmp", referencedColumnName = "user_group_id")},
            inverseJoinColumns = {@JoinColumn(name = "from_user_id", referencedColumnName = "user_id")})
    private Set<User> users;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_group_to_permission_group_tmp",
            joinColumns = {@JoinColumn(name = "from_user_group_id", referencedColumnName = "user_group_id")},
            inverseJoinColumns = {@JoinColumn(name = "from_permission_group_id", referencedColumnName = "permission_group_id")})
    private Set<PermissionGroup> permissionGroups;

    public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public String getUserGroupDescription() {
        return userGroupDescription;
    }

    public void setUserGroupDescription(String userGroupDescription) {
        this.userGroupDescription = userGroupDescription;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<PermissionGroup> getPermissionGroups() {
        return permissionGroups;
    }

    public void setPermissionGroups(Set<PermissionGroup> permissionGroups) {
        this.permissionGroups = permissionGroups;
    }
}
