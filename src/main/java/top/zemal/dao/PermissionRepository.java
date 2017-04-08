package top.zemal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.zemal.model.Permission;

/**
 * @author zemal-tan
 * @description
 * @create 2017-04-06 17:07
 **/
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
