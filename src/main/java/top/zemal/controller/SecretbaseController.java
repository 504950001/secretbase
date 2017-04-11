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
import top.zemal.model.PermissionGroup;
import top.zemal.model.User;
import top.zemal.model.UserGroup;
import top.zemal.service.*;

import java.util.List;

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

    @ApiOperation(value = "添加关系", notes = "添加关系（不是关系维护者的，需要先手动添加关系）<br>" +
            "1. 添加用户和用户组的关系<br>" +
            "2. 添加权限和权限组的关系<br>" +
            "3. 添加权限组和用户组的关系<br>" +
            "例如：将前者对象用户beforeId，添加到后者对象用户组afterId中去")
    @RequestMapping(value = "/A_addRelationship", method = RequestMethod.POST)
    Responses addRelationship(
            @ApiParam(name = "beforeId", value = "前者对象id")
            @RequestParam(name = "beforeId") Integer beforeId,
            @ApiParam(name = "afterId", value = "后者对象id")
            @RequestParam(name = "afterId") Integer afterId,
            @ApiParam(name = "objectType", value = "对象类型（对应上面数字1 2 3）")
            @RequestParam(name = "objectType") Integer objectType) {
        Boolean result = false;
        try {
            result = secretbaseService.addRelationship(beforeId, afterId, objectType);
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

    @ApiOperation(value = "解除关系", notes = "解除关系（不是关系维护者的，需要先手动解除关系）<br>" +
            "1. 解除用户和用户组的关系<br>" +
            "2. 解除权限和权限组的关系<br>" +
            "3. 解除权限组和用户组的关系<br>")
    @RequestMapping(value = "/A_removeRelationship", method = RequestMethod.POST)
    Responses removeRelationship(
            @ApiParam(name = "beforeId", value = "前者对象id")
            @RequestParam(name = "beforeId") Integer beforeId,
            @ApiParam(name = "afterId", value = "后者对象id")
            @RequestParam(name = "afterId") Integer afterId,
            @ApiParam(name = "objectType", value = "对象类型（对应上面数字1 2 3）")
            @RequestParam(name = "objectType") Integer objectType) {
        Boolean result = false;
        try {
            result = secretbaseService.removeRelationship(beforeId, afterId, objectType);
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

    @ApiOperation(value = "删除", notes = "删除（如果不是关系维护者，需要先手动解除关系）")
    @RequestMapping(value = "/B_deleteUserOrPermission", method = RequestMethod.GET)
    Responses deleteObjectById(
            @ApiParam(name = "objectId", value = "对象id")
            @RequestParam(name = "objectId") Integer objectId,
            @ApiParam(name = "objectType", value = "对象类型（1.用户、2.用户组、3.权限、4.权限组）")
            @RequestParam(name = "objectType") Integer objectType) {
        Boolean result = false;
        try {
            secretbaseService.deleteObjectById(objectId, objectType);
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
}
