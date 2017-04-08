package top.zemal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zemal.dao.PermissionGroupRepository;
import top.zemal.dao.PermissionRepository;
import top.zemal.dao.UserGroupRepository;
import top.zemal.dao.UserRepository;
import top.zemal.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author zemal-tan
 * @description
 * @create 2017-04-06 17:52
 **/
@Service
public class SecretbaseService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserGroupRepository userGroupRepository;

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    PermissionGroupRepository permissionGroupRepository;

    public List<User> addUsers(List<Integer> userList){
        List<User> users = new ArrayList<>();
        for (Integer userId: userList){
            users.add(new User(userId));
        }
        return userRepository.save(users);
    }

    public User findUserByUserId(Integer userId){
        User user = userRepository.findByUserId(userId);
        return user;
    }

    public List<User> deleteUserByUserId(List<Integer> userIds){
        List<User> users = userRepository.deleteByUserIds(userIds);
        return users;
    }

}
