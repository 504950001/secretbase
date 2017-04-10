package top.zemal.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.zemal.model.User;

import java.util.List;

/**
 * @author zemal-tan
 * @description
 * @create 2017-03-31 18:14
 **/
public interface UserRepository extends JpaRepository<User, Integer>,BaseRepository<User> {

    User findByUserId(Integer userId);

    @Query("delete User as u where u.userId in (:userIds)")
    List<User> deleteByUserIds(List<Integer> userIds);
}
