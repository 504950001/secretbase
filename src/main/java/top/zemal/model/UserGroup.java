package top.zemal.model;

import javax.persistence.*;
import java.util.HashSet;
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
    private Set<User> users = new HashSet<User>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_group_to_permission_group_tmp",
            joinColumns = {@JoinColumn(name = "from_user_group_id", referencedColumnName = "user_group_id")},
            inverseJoinColumns = {@JoinColumn(name = "from_permission_group_id", referencedColumnName = "permission_group_id")})
    private Set<PermissionGroup> permissionGroups = new HashSet<PermissionGroup>();

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

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user){
        if (!this.users.contains(user)){
            this.users.add(user);
            user.setUserGroups((Set<UserGroup>) this);
        }
    }

    /**
     * 删除用户
     * @param user
     */
    public void removeUser(User user){
        if (this.users.contains(user)){
            user.setUserGroups(null);
            this.users.remove(user);
        }
    }

    /**
     * 添加权限组
     * @param permissionGroup
     */
    public void addPermissionGroup(PermissionGroup permissionGroup){
        if (!this.permissionGroups.contains(permissionGroup)){
            this.permissionGroups.add(permissionGroup);
            permissionGroup.setUserGroups((Set<UserGroup>) this);
        }
    }

    /**
     * 删除权限组
     * @param permissionGroup
     */
    public void removePermissionGroup(PermissionGroup permissionGroup){
        if (this.permissionGroups.contains(permissionGroup)){
            permissionGroup.setUserGroups(null);
            this.permissionGroups.remove(permissionGroup);
        }
    }
}
