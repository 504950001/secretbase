package top.zemal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.zemal.model.UserGroup;

/**
 * @author zemal-tan
 * @description
 * @create 2017-04-06 17:05
 **/
public interface UserGroupRepository extends JpaRepository<UserGroup, Integer> {
}
