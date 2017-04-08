package top.zemal.service;

import java.util.List;

/**
 * @author zemal-tan
 * @description  用户、用户组、权限、权限组等对象
 * @create 2017-04-08 11:10
 **/

public interface BaseService<T> {
    
    List<T> addObjects(List<T> objectList);

    T findObjectById(Integer objectId);

    List<T> deleteObjectById(List<Integer> objectIds);
}
