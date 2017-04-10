package top.zemal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;
/**
 * @author zemal-tan
 * @description
 * @create 2017-04-08 16:26
 **/
public class BaseService<T, BASE extends JpaRepository<T, Integer>> {

    @Autowired
    BASE baseRepository;
    
    public List<T> addObjects(List<T> objectList){
        return baseRepository.save(objectList);
    }

    public T findObjectByPk(Integer objectId){
        Optional<T> object = baseRepository.findOne(objectId);
        return object.get();
    }

    public void deleteObjectByPk(Integer objectId){
        baseRepository.delete(objectId);
    }
}
