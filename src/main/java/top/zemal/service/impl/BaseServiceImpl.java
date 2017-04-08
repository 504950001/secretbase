package top.zemal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import top.zemal.service.BaseService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zemal-tan
 * @description
 * @create 2017-04-08 11:14
 **/

//@Service
public class BaseServiceImpl<T, R extends JpaRepository<T, Integer>> implements BaseService<T> {

//    @SuppressWarnings("SpringJavaAutowiringInspection")
//    @Autowired
//    R repostory;

    @Override
    public List<T> addObjects(List<T> objectList) {
        return null;
    }

    @Override
    public T findObjectById(Integer objectId) {
        return null;
    }

    @Override
    public List<T> deleteObjectById(List<Integer> objectIds) {
        return null;
    }
}
