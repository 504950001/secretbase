package top.zemal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.zemal.content.ResponseConstants;
import top.zemal.content.Responses;
import top.zemal.model.Permission;
import top.zemal.model.PermissionGroup;
import top.zemal.model.User;
import top.zemal.model.UserGroup;
import top.zemal.service.PermissionGroupService;
import top.zemal.service.PermissionService;
import top.zemal.service.UserGroupService;
import top.zemal.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * @author zemal-tan
 * @description 用户、用户组、权限、权限组的增删改查
 * @create 2017-04-08 16:38
 **/

@RestController
@RequestMapping("/v1/base")
@Api(description = "基础接口，用户、用户组、权限、权限组等的增删改")
public class BaseController{

    @Autowired
    UserService userBaseService;

    @Autowired
    UserGroupService userGroupService;

    @Autowired
    PermissionService permissionService;

    @Autowired
    PermissionGroupService permissionGroupService;

    @ApiOperation(value = "根据主键id获取信息", notes = "根据主键id获取信息，<br>" +
            "1.用户<br>" +
            "2.用户组<br>" +
            "3.权限<br>" +
            "4.权限组")
    @RequestMapping(value = "/findObjectByPk", method = RequestMethod.GET)
    Responses findObjectByPk(
            @ApiParam(name = "objectId", value = "对象id")
            @RequestParam(name = "objectId") Integer objectId,
            @ApiParam(name = "objectType", value = "对象类型")
            @RequestParam(name = "objectType") Integer objectType) {
        Object result = null;
        try {
            switch (objectType){
                case 1:
                    result = userBaseService.findObjectByPk(objectId);break;
                case 2:
                    result = userGroupService.findObjectByPk(objectId);break;
                case 3:
                    result = permissionService.findObjectByPk(objectId);break;
                case 4:
                    result = permissionGroupService.findObjectByPk(objectId);break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Responses(ResponseConstants.SUCCESS_FAILED,
                    ResponseConstants.CODE_FAILED,
                    ResponseConstants.CODE_FAILED_VALUE, result);
        }
        return new Responses(ResponseConstants.SUCCESS_OK,
                ResponseConstants.CODE_SUCCESS,
                ResponseConstants.CODE_SUCCESS_VALUE, result);
    }

    @ApiOperation(value = "添加新用户", notes = "根据用户id添加新用户")
    @RequestMapping(value = "/A_addUser", method = RequestMethod.POST)
    Responses addUser(
            @ApiParam(name = "userIds", value = "用户id数组")
            @RequestParam(name = "userIds") List<Integer> userIds) {
        List<User> result = null;
        try {
            List<User> userList = new ArrayList<>();
            for (Integer userId: userIds){
                User user = new User();
                user.setUserId(userId);
                userList.add(user);
            }
            result = userBaseService.addObjects(userList);
        } catch (Exception e) {
            e.printStackTrace();
            return new Responses(ResponseConstants.SUCCESS_FAILED,
                    ResponseConstants.CODE_FAILED,
                    ResponseConstants.CODE_FAILED_VALUE, result);
        }
        return new Responses(ResponseConstants.SUCCESS_OK,
                ResponseConstants.CODE_SUCCESS,
                ResponseConstants.CODE_SUCCESS_VALUE, result);
    }

    @ApiOperation(value = "删除用户", notes = "根据用户id删除用户")
    @RequestMapping(value = "/A_deleteUserByUserId", method = RequestMethod.GET)
    Responses deleteUserByUserId(
            @ApiParam(name = "userId", value = "用户id")
            @RequestParam(name = "userId") Integer userId) {
        Boolean result = false;
        try {
            userBaseService.deleteObjectByPk(userId);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            return new Responses(ResponseConstants.SUCCESS_FAILED,
                    ResponseConstants.CODE_FAILED,
                    ResponseConstants.CODE_FAILED_VALUE, result);
        }
        return new Responses(ResponseConstants.SUCCESS_OK,
                ResponseConstants.CODE_SUCCESS,
                ResponseConstants.CODE_SUCCESS_VALUE, result);
    }

    @ApiOperation(value = "添加权限、权限组或用户组", notes = "添加权限、权限组或用户组<br>" +
            "1.权限<br>" +
            "2.权限组<br>" +
            "3.用户组<br>")
    @RequestMapping(value = "/B_addObject", method = RequestMethod.POST)
    Responses addObject(
//            @ApiParam(name = "objectId", value = "对象id")
//            @RequestParam(name = "objectId") Integer objectId,
            @ApiParam(name = "objectName", value = "对象名字（英文）")
            @RequestParam(name = "objectName") String objectName,
            @ApiParam(name = "objectDescription", value = "对象描述")
            @RequestParam(name = "objectDescription") String objectDescription,
            @ApiParam(name = "objectType", value = "对象类型（1.权限；2权限组；3.用户组）")
            @RequestParam(name = "objectType") Integer objectType) {
        Object result = null;
        try {
            switch (objectType){
                case 1:
                    Permission permission = new Permission();
                    permission.setPermissionName(objectName);
                    permission.setPermissionDescription(objectDescription);
                    result = permissionService.addObject(permission);
                    break;
                case 2:
                    PermissionGroup permissionGroup = new PermissionGroup();
                    permissionGroup.setPermissionGroupName(objectName);
                    permissionGroup.setPermissionGroupDescription(objectDescription);
                    result = permissionGroupService.addObject(permissionGroup);
                    break;
                case 3:
                    UserGroup userGroup = new UserGroup();
                    userGroup.setUserGroupName(objectName);
                    userGroup.setUserGroupDescription(objectDescription);
                    result = userGroupService.addObject(userGroup);
                    break;
                default:
                    result = "对象类型错误，必须是以下数字：（1.权限；2权限组；3.用户组）";
                    throw new Exception((String) result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "添加失败，该对象名字已经存在！";
            return new Responses(ResponseConstants.SUCCESS_FAILED,
                    ResponseConstants.CODE_FAILED,
                    ResponseConstants.CODE_FAILED_VALUE, result);
        }
        return new Responses(ResponseConstants.SUCCESS_OK,
                ResponseConstants.CODE_SUCCESS,
                ResponseConstants.CODE_SUCCESS_VALUE, result);
    }
}
