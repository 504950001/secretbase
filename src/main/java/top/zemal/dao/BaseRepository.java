package top.zemal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import top.zemal.model.User;

import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.List;

/**
 * @author zemal-tan
 * @description
 * @create 2017-04-08 11:36
 **/
public interface BaseRepository<T, PK extends Serializable> extends JpaRepository<T, PK> {

}
