package top.zemal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import top.zemal.dao.BaseRepository;

import java.util.List;

/**
 * @author zemal-tan
 * @description
 * @create 2017-04-08 16:26
 **/
public class BaseService<T, BASE extends BaseRepository<T>> {

    @Autowired
    BASE baseRepository;
    
    public List<T> addObjects(List<T> objectList){
        return baseRepository.save(objectList);
    }

    public T findObjectByPk(Integer objectId){
        T object = (T) baseRepository.findOne(objectId);
        return object;
    }

    public void deleteObjectByPk(Integer objectId){
        baseRepository.delete(objectId);
    }
}
