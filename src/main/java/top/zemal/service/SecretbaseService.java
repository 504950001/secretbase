package top.zemal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zemal.content.ResponseConstants;
import top.zemal.content.Responses;
import top.zemal.dao.*;
import top.zemal.model.Permission;
import top.zemal.model.PermissionGroup;
import top.zemal.model.User;
import top.zemal.model.UserGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author zemal-tan
 * @description
 * @create 2017-04-06 17:52
 **/

@Service
public class SecretbaseService{

    @Autowired
    UserService userService;

    @Autowired
    UserGroupService userGroupService;

    @Autowired
    PermissionService permissionService;

    @Autowired
    PermissionGroupService permissionGroupService;

    /**
     * @param beforeId  前者id
     * @param afterId  后者id
     * @param objectType 对象类型： 1. 解除用户和用户组的关系 2. 解除权限和权限组的关系 3. 解除权限组和用户组的关系
     * @return
     */
    public Boolean removeRelationship(Integer beforeId, Integer afterId, Integer objectType){
        Boolean result = false;
        try {
            switch (objectType){
                case 1:
                    UserGroup userGroup = userGroupService.findObjectByPk(afterId);
                    userGroup.removeUser(userService.findObjectByPk(beforeId));
                    userGroupService.addObject(userGroup);
                    break;
                case 2:
                    PermissionGroup permissionGroup = permissionGroupService.findObjectByPk(afterId);
                    permissionGroup.removePermission(permissionService.findObjectByPk(beforeId));
                    permissionGroupService.addObject(permissionGroup);
                    break;
                case 3:
                    UserGroup userGroup2 = userGroupService.findObjectByPk(afterId);
                    userGroup2.removePermissionGroup(permissionGroupService.findObjectByPk(beforeId));
                    userGroupService.addObject(userGroup2);
                    break;
                default:
                    throw new Exception("对象类型不是1 2 3中的一个！");
            }
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 为用户、用户组、权限、权限组之间添加关系，将beforeId 添加到 afterId中
     * @param beforeId
     * @param afterId
     * @param objectType 对象类型： 1. 建立用户和用户组的关系 2. 建立权限和权限组的关系 3. 建立权限组和用户组的关系
     * @return
     */
    public Boolean addRelationship(Integer beforeId, Integer afterId, Integer objectType){
        Boolean result = false;
        try {
            switch (objectType){
                case 1:
                    UserGroup userGroup = userGroupService.findObjectByPk(afterId);
                    userGroup.addUser(userService.findObjectByPk(beforeId));
                    userGroupService.addObject(userGroup);
                    break;
                case 2:
                    PermissionGroup permissionGroup = permissionGroupService.findObjectByPk(afterId);
                    permissionGroup.addPermission(permissionService.findObjectByPk(beforeId));
                    permissionGroupService.addObject(permissionGroup);
                    break;
                case 3:
                    UserGroup userGroup2 = userGroupService.findObjectByPk(afterId);
                    userGroup2.addPermissionGroup(permissionGroupService.findObjectByPk(beforeId));
                    userGroupService.addObject(userGroup2);
                    break;
                default:
                    throw new Exception("对象类型不是1 2 3中的一个！");
            }
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public void deleteObjectById(Integer objectId, Integer objectType) throws Exception {
        //  对象类型（1.用户、2.用户组、3.权限、4.权限组）
        switch (objectType){
            case 1:
                User user = userService.findObjectByPk(objectId);
                Set<UserGroup> userGroupSet = user.getUserGroups();
                if (userGroupSet != null &&userGroupSet.size()>0){
                    // 解除关系 用户与用户组
                    for (UserGroup userGroup: userGroupSet){
                        removeRelationship(user.getUserId(), userGroup.getUserGroupId(), 1);
                    }
                }
                userService.deleteObjectByPk(objectId);
                break;
            case 2:
                userGroupService.deleteObjectByPk(objectId);  // 因为是关系维护者，所有无需手动解除关系
                break;
            case 3:
                Permission permission = permissionService.findObjectByPk(objectId);
                Set<PermissionGroup> permissionGroupSet = permission.getPermissionGroups();
                if (permissionGroupSet != null && permissionGroupSet.size()>0){
                    // 解除 权限与权限组的关系
                    for (PermissionGroup permissionGroup: permissionGroupSet){
                        removeRelationship(permission.getPermissionId(),
                                permissionGroup.getPermissionGroupId(), 2);
                    }
                }
                permissionService.deleteObjectByPk(objectId);
                break;
            case 4:
                PermissionGroup permissionGroup = permissionGroupService.findObjectByPk(objectId);
                Set<UserGroup> userGroupSet1 = permissionGroup.getUserGroups();
                if (userGroupSet1 != null && userGroupSet1.size()>0){
                    for (UserGroup userGroup: userGroupSet1){
                        removeRelationship(permissionGroup.getPermissionGroupId(),
                                userGroup.getUserGroupId(), 3);
                    }
                }
                permissionGroupService.deleteObjectByPk(objectId);
                break;
            default:
                throw new Exception("对象类型错误，objectType应该为1-4中任意一个");
        }
    }
}

//public List<User> addUsers(List<Integer> userList){
//    List<User> users = new ArrayList<>();
//    for (Integer userId: userList){
//        users.add(new User(userId));
//    }
//    return userRepository.save(users);
//}
//
//public User findUserByUserId(Integer userId){
//    User user = userRepository.findByUserId(userId);
//    return user;
//}
//
//public List<User> deleteUserByUserId(List<Integer> userIds){
//    List<User> users = userRepository.deleteByUserIds(userIds);
//    return users;
//}


//@Autowired
//UserRepository userRepository;
//
//@Autowired
//UserGroupRepository userGroupRepository;
//
//@Autowired
//PermissionRepository permissionRepository;
//
//@Autowired
//PermissionGroupRepository permissionGroupRepository;