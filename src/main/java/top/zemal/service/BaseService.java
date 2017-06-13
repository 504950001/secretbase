package top.zemal.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Transactional
    public List<T> addObjects(List<T> objectList){
        List<T> tList = new ArrayList<T>();
        for (T list: objectList){
            list = baseRepository.save(list);
            tList.add(list);
        }
        return tList;
    }

    public T addObject(T object){
        return baseRepository.save(object);
    }

    public T findObjectByPk(Integer objectId){
        Optional<T> object = baseRepository.findById(objectId);
        return object.get();
    }

    public List<T> findAll(){
        List<T> object = baseRepository.findAll();
        return object;
    }

    public void deleteObjectByPk(Integer objectId){
        baseRepository.deleteById(objectId);
    }
}
