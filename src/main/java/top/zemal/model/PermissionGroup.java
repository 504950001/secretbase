package top.zemal.model;

import javax.persistence.*;
import java.util.Set;

/**
 * @author zemal-tan
 * @description
 * @create 2017-04-06 16:28
 **/
@Entity
@Table(name = "permission_group_tmp")
public class PermissionGroup {

    @Id
    @GeneratedValue
    @Column(name = "permission_group_id")
    private Integer permissionGroupId;

    @Column(name = "permission_group_name", unique = true)
    private String permissionGroupName;

    @Column(name = "permission_group_description")
    private String permissionGroupDescription;

    @ManyToMany(mappedBy = "permissionGroups")
    private Set<UserGroup> userGroups;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "permission_to_permission_group_tmp",
            joinColumns = {@JoinColumn(name = "from_permission_group_id", referencedColumnName = "permission_group_id")},
            inverseJoinColumns = {@JoinColumn(name = "from_permission_id", referencedColumnName = "permission_id")})
    private Set<Permission> permissions;

    public PermissionGroup() {
    }

    public Integer getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(Integer permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
    }

    public String getPermissionGroupName() {
        return permissionGroupName;
    }

    public void setPermissionGroupName(String permissionGroupName) {
        this.permissionGroupName = permissionGroupName;
    }

    public String getPermissionGroupDescription() {
        return permissionGroupDescription;
    }

    public void setPermissionGroupDescription(String permissionGroupDescription) {
        this.permissionGroupDescription = permissionGroupDescription;
    }

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
