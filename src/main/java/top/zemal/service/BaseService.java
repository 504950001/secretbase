package top.zemal.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    public T addObject(T object){
        return baseRepository.save(object);
    }

    public T findObjectByPk(Integer objectId){
        Optional<T> object = baseRepository.findOne(objectId);
        return object.get();
    }

    public List<T> findAll(){
        List<T> object = baseRepository.findAll();
        return object;
    }

    public void deleteObjectByPk(Integer objectId){
        baseRepository.delete(objectId);
    }
}
