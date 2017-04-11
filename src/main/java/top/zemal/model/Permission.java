package top.zemal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zemal-tan
 * @description
 * @create 2017-04-06 16:27
 **/
@Entity
@Table(name = "permission_tmp")
public class Permission {

    @Id
    @GeneratedValue
    @Column(name = "permission_id")
    private Integer permissionId;

    @Column(name = "permission_name", unique = true)
    private String permissionName;

    @Column(name = "permission_description")
    private String permissionDescription;

    @JsonIgnore
    @ManyToMany(mappedBy = "permissions")
    private Set<PermissionGroup> permissionGroups = new HashSet<PermissionGroup>();

    public Permission() {
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDescription() {
        return permissionDescription;
    }

    public void setPermissionDescription(String permissionDescription) {
        this.permissionDescription = permissionDescription;
    }

    public Set<PermissionGroup> getPermissionGroups() {
        return permissionGroups;
    }

    public void setPermissionGroups(Set<PermissionGroup> permissionGroups) {
        this.permissionGroups = permissionGroups;
    }
}
