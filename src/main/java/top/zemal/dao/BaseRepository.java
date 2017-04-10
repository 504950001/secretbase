package top.zemal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.zemal.model.User;

/**
 * @author zemal-tan
 * @description
 * @create 2017-04-08 16:22
 **/
public interface BaseRepository<T> extends JpaRepository<T, Integer> {
}
