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
import top.zemal.model.User;
import top.zemal.service.SecretbaseService;

import java.util.List;
import java.util.Optional;

/**
 * @author zemal-tan
 * @description
 * @create 2017-04-05 16:53
 **/

@RestController
@RequestMapping("/v1/secretbase")
@Api(description = "权限系统接口，可用于权限数据的增删查改")
public class SecretbaseController {

    @Autowired
    SecretbaseService secretbaseService;

    @ApiOperation(value = "根据用户id获取用户", notes = "根据用户id获取用户")
    @RequestMapping(value = "/A_findUserByUserId", method = RequestMethod.GET)
    Responses findUserByUserId(
            @ApiParam(name = "userId", value = "用户id")
            @RequestParam(name = "userId") Integer userId) {
        User result = null;
        try {
            result = secretbaseService.findUserByUserId(userId);
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
            result = secretbaseService.addUsers(userIds);
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
            @ApiParam(name = "userIds", value = "用户id数组")
            @RequestParam(name = "userId") List<Integer> userIds) {
        List<User> result = null;
        try {
            result = secretbaseService.deleteUserByUserId(userIds);
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

    @ApiOperation(value = "获取用户组", notes = "根据用户id获取用户组")
    @RequestMapping(value = "/B_findUserGroupByUserGroupId", method = RequestMethod.GET)
    Responses findUserGroupByUserGroupId(
            @ApiParam(name = "userGroupId", value = "用户组id")
            @RequestParam(name = "userGroupId") Integer userGroupId) {
        User result = null;
        try {
//            result = secretbaseService.findUserByUserId(userId);
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

    @ApiOperation(value = "添加新用户组", notes = "根据用户组id数组添加新用户组")
    @RequestMapping(value = "/B_addUserGroup", method = RequestMethod.POST)
    Responses addUserGroup(
            @ApiParam(name = "userGroupIds", value = "用户组id数组")
            @RequestParam(name = "userGroupIds") List<Integer> userGroupIds) {
        List<User> result = null;
        try {
//            result = secretbaseService.addUsers(userIds);
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

    @ApiOperation(value = "删除用户组", notes = "根据用户组id数组删除用户组")
    @RequestMapping(value = "/B_deleteUserGroupByUserGroupId", method = RequestMethod.GET)
    Responses deleteUserGroupByUserGroupId(
            @ApiParam(name = "userGroupIds", value = "用户组id数组")
            @RequestParam(name = "userGroupIds") List<Integer> userGroupIds) {
        List<User> result = null;
        try {

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
}
